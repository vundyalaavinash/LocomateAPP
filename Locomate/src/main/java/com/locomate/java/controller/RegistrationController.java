package com.locomate.java.controller;


import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locomate.java.beans.RegistrationPO;
import com.locomate.java.helper.UserRegistrationHelper;
import com.locomate.java.proxy.RegistrationProxy;
import com.locomate.java.validations.LoginPOValidator;
import com.locomate.java.validations.RegistrationPOValidator;

@Controller
public class RegistrationController {
	
	
	@Autowired
	private RegistrationProxy registerproxy;
	
	@Autowired
	private RegistrationPO registrationPO;
	@Resource(name="registerValidator")  
    private RegistrationPOValidator registerValidator;  
	@Autowired
	private UserRegistrationHelper userService;
      
    @InitBinder  
    private void initBinder(WebDataBinder binder) {  
        binder.setValidator( registerValidator); 
    }
	
	@RequestMapping("/register")
	public String redirectToRegisterPage(Map<String, Object> map,Model model,@ModelAttribute("registerpo") RegistrationPO register){
		 
		return "register";
	}
	
	@RequestMapping("/submitForm")
	public String submitRegisterForm(@ModelAttribute("registerpo")@Valid RegistrationPO register,BindingResult result,
			Model model,@RequestParam(value="referrer", required=false)String referrer) throws IOException{
		
		System.out.println("userr===="+register.getUserName());
		System.out.println("passss===="+register.getPassword());
		System.out.println("passss===="+register.getFirstName());
		System.out.println("length"+register.getUserName().length());
		if(result.hasErrors()){	
			return "register";
		}
        try {
        	String password=register.getPassword();
    		String confirmPassword=register.getConfirmpassword();
    		if(password.equals(confirmPassword)){
        	registerproxy.registerNewUser(register);
        	}
    		else{
    			register.setErrormsg("Password doesn't match");
    			return "register";
    		}
       } catch(Exception e) {
            e.printStackTrace();
       }  
       
        register.setReferrer(referrer);
      
        /*UserRegistrationService service = (UserRegistrationService) context
				.getBean("userRegistrationService");*/
        userService.afterSuccessfullregistration(register);
       return "redirect:loginform?referrer="+referrer;
        
	}

	
	
}
