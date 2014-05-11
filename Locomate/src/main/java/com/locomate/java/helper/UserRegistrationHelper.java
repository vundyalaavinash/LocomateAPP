package com.locomate.java.helper;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.locomate.java.beans.RegistrationPO;

public class UserRegistrationHelper {
	@Autowired
	private RegistrationPO registerPo;
	private MailSender mailSender;
	public MailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@SuppressWarnings("rawtypes")
	public void afterSuccessfullregistration(RegistrationPO register){
		
		Set userEmail= new HashSet<String>();
		userEmail.add(register.getEmail());
		SimpleMailMessage[] mailMessageArray = new SimpleMailMessage[userEmail.size()
				];
		Iterator iterator = userEmail.iterator();
		for (int index = 0; iterator.hasNext(); index++) {
			SimpleMailMessage message = new SimpleMailMessage();

			String toAddress = (String) iterator.next();

			message.setTo(toAddress);

			message.setSubject("User Registration successful");

			message.setText("The user '" + toAddress
					+ "' is successfully registered '"
					+"'Please use the below link for login'"+"'http://localhost:8080/java/loginform'");

			mailMessageArray[index] = message;

		}
		System.out.println("Sending email ....");
		
		        mailSender.send(mailMessageArray);



	}
	 

}
