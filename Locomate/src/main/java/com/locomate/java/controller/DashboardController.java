package com.locomate.java.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.locomate.java.beans.RegistrationPO;

@Controller
public class DashboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	RegistrationPO registrationPO;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/dashboard")
	public String home(RegistrationPO registrationPO, Model model) {
		model.addAttribute("username",registrationPO.getFirstName()+" "+registrationPO.getLastName());
		return "dashboard";
	}
}
