package com.locomate.java.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.locomate.java.beans.RegistrationPO;
import com.locomate.java.controller.DashboardController;

@Controller
public class UserRoleQueriesController {
	
private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	@Autowired
	RegistrationPO registrationPO;

}
