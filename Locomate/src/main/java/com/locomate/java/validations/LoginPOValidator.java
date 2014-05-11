package com.locomate.java.validations;


import org.owasp.esapi.ESAPI;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.locomate.java.beans.RegistrationPO;
@Component  
public  class LoginPOValidator implements Validator  {
	
	 @Override 
	public boolean supports(Class<?> clazz) {
		return RegistrationPO.class.isAssignableFrom(clazz);
}
	
	 @Override 
	public void validate(Object target, Errors errors) {
		 RegistrationPO register = (RegistrationPO) target; 
		 System.out.println("------"+register.getUserName());
		 System.out.println("------"+register.getPassword());
		ValidationUtils.rejectIfEmpty(errors, "userName", "messages.userName");
		ValidationUtils.rejectIfEmpty(errors, "password", "messages.password");
		/*ValidationUtils.rejectIfEmpty(errors, "mobileNumber", "messages.common");
		ValidationUtils.rejectIfEmpty(errors, "Occupation", "messages.common");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "messages.common");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "messages.common");
		if (userName < 1 && userName >25 ){
			 errors.rejectValue("userName", "messages.userName.length");  
			  
		}*/
		
	}


	/*private void verifyUserName(Errors errors, RegistrationPO register) {
		if(!StringUtilities.isEmpty(register.getUserName()) && !ESAPI.validator().R) {
			errors.rejectValue("userName","locomate.ValidateText");
		
		ValidationUtils.rejectIfEmpty(errors, "username", "locomate.userName");
		}
	


	private void verifySearchStudentIdName(Errors errors,
			RegistrationPO register) {
		// TODO Auto-generated method stub
		
	}*/



}
