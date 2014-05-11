package com.locomate.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.locomate.java.beans.RegistrationPO;
import com.locomate.java.proxy.LoginProxy;
import com.locomate.java.validations.LoginPOValidator;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes({"name","username"})
public class LoginController {
	
	@Autowired
	private LoginProxy loginproxy;
	
	@Autowired
	private RegistrationPO registrationPO;
	
	@Autowired
	private RegistrationPO sessionRegister;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/*
	 * @Autowired private MessageHandler messageHandler;
	 */
	@RequestMapping("/loginform")	
	public String showForm(@ModelAttribute("registerpo") RegistrationPO register,@RequestParam(value="referrer", required=false)String referrer,Model model) {
		 if("fromRegister".equals(referrer)){
	        	register.setShowMessage("Successfully register please login...");
	        	model.addAttribute(register);
	        }
		return "Login";
	}

	@RequestMapping(value = "/submitLogin")
	public String list(@ModelAttribute("registerpo") RegistrationPO register,
			Model model) throws IOException {
		
		String usrName = register.getUserName();
		String pswd = register.getPassword();
		Boolean Credentials = checkCredentials(usrName, pswd);
		List<RegistrationPO> userFrmService = loginproxy.list();
		if (Credentials) {
			for (int i = 0; i < userFrmService.size(); i++) {
				if (userFrmService.get(i).getUserName().equals(usrName)
						&& userFrmService.get(i).getPassword().equals(pswd)) {					
					sessionRegister=loginproxy.getUser(usrName);					
					model.addAttribute("username", usrName);
					model.addAttribute("name", sessionRegister.getFirstName()+" "+sessionRegister.getLastName());
					return "redirect:dashboard";
				}
			}
		}
		register.setErrormsg("username  not found or password not found");
		register.setUserName("");
		return "Login";		
	}

	private boolean checkCredentials(String usrName, String pswd) {
		if ((usrName != null  && !usrName.isEmpty() ) ||(pswd != null &&!pswd.isEmpty()) ) {
			return true;
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "home";
	}

}
