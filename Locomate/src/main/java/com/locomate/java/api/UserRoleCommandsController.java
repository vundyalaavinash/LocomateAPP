package com.locomate.java.api;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.*;

import com.locomate.java.beans.RegistrationPO;
import com.locomate.java.controller.DashboardController;
import com.locomate.java.proxy.LoginProxy;
import com.locomate.java.proxy.Impl.LoginProxyImpl;

@Controller
@RequestMapping("/api/login")
public class UserRoleCommandsController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);		
	@Autowired
	private LoginProxy loginproxy;
	
	@Autowired
	private RegistrationPO registrationPO;
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String list(@RequestParam(value="username", required=false)String username,@RequestParam(value="password", required=false)String password) throws IOException {
		JSONObject json = new JSONObject();
		if(username != null && !username.trim().equals("")){
			registrationPO = loginproxy.getUser(username.toLowerCase());
			if (registrationPO!=null && registrationPO.getPassword().equals(password)){
				json.put("status", "success");
				json.put("username", registrationPO.getUserName());
				json.put("occupation", registrationPO.getOccupation());
				json.put("firstname", registrationPO.getFirstName());
				json.put("lastname", registrationPO.getLastName());
				json.put("mobile", registrationPO.getMobileNumber());
				json.put("email", registrationPO.getEmail());
				json.put("gender", registrationPO.getGender());
			}
			else{
				json.put("status", "error");
				json.put("message", "Authentication Failed!");		
			}
		}
		else{
			json.put("status", "error");
			json.put("message", "Missing Fields");			
		}		
		return json.toString();
	}

}
