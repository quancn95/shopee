package com.ofw.group14.javaapplication;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.SimpleEmail;

public class SimpleTextEmail {
	public static void main(String[] args) {
		try {
			Email email = new SimpleEmail(); 
			
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthentication(Constants.MY_EMAIL, Constants.MY_PASSWORD);
			
		 
			email.setSSLOnConnect(true);
			email.setFrom(Constants.MY_EMAIL, "tkdk");
			email.setSubject("Test sendding gamil");
			email.setMsg("You have got my email");
			
			
			
			email.addTo(Constants.FRIEND_EMAIL,"simple"); 
			email.send();
			System.out.println("sent !");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
