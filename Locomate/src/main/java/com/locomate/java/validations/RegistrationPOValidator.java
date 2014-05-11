package com.locomate.java.validations;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.StringUtilities;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.locomate.java.beans.RegistrationPO;

@Component 
public class RegistrationPOValidator  implements Validator{
	
	 @Override 
		public boolean supports(Class<?> clazz) {
			return RegistrationPO.class.isAssignableFrom(clazz);
	}
		
		 @Override 
		public void validate(Object target, Errors errors) {
			 RegistrationPO register = (RegistrationPO) target; 
			 Integer userName = register.getUserName().length();
			 System.out.println("------"+userName);
			 System.out.println("------"+register.getPassword());
			ValidationUtils.rejectIfEmpty(errors, "userName", "messages.userName");
			ValidationUtils.rejectIfEmpty(errors, "password", "messages.password");
			ValidationUtils.rejectIfEmpty(errors, "mobileNumber", "messages.common");
			ValidationUtils.rejectIfEmpty(errors, "Occupation", "messages.common");
			ValidationUtils.rejectIfEmpty(errors, "firstName", "messages.common");
			ValidationUtils.rejectIfEmpty(errors, "lastName", "messages.common");
			ValidationUtils.rejectIfEmpty(errors, "email", "messages.common");
			if (userName < 1 && userName >25 ){
				 errors.rejectValue("userName", "messages.userName.length"); 
				  
			}
		verifyEmail(errors,register);
		verifyNumber(errors,register);	
		}

		private void verifyNumber(Errors errors, RegistrationPO register) {
			if((!ESAPI.validator().isValidInput("mobileNumber", register.getMobileNumber(), "Number", 20, false))){
				errors.rejectValue("mobileNumber", "messages.number");
				
			}	
		}

		private void verifyEmail(Errors errors, RegistrationPO register) {
			if((!ESAPI.validator().isValidInput("email", register.getEmail(), "Email", 100, false))){
				errors.rejectValue("email", "messages.email");
				
			}
		}
		 }


