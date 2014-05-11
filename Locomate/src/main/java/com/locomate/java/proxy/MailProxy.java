package com.locomate.java.proxy;

import org.springframework.mail.MailSender;

public interface MailProxy {
	public void setMailSender(MailSender mailSender); 
	public void sendMail(String from, String to, String subject, String msg); 
}
