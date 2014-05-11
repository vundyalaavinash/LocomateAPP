package com.locomate.java.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.locomate.java.beans.PostRidePO;
import com.locomate.java.beans.RegistrationPO;
import com.locomate.java.helper.UserRegistrationHelper;
import com.locomate.java.proxy.PostRideProxy;
import com.locomate.java.proxy.RegistrationProxy;
import com.locomate.java.validations.RegistrationPOValidator;
@Controller
public class PostRideController {
	

	@Autowired
	private PostRideProxy postProxy;
	
	@Autowired
	private PostRidePO postPO;
	
	@RequestMapping("/displayPostRide")
	public String displayPostRide(@ModelAttribute("postPO") PostRidePO postPO){
		 
		return "postRide";
	}
	
	@RequestMapping("/submitRide")
	public  String submitRideDetails(@ModelAttribute("postPO") PostRidePO postPO){
		return "postRide";
	}
}