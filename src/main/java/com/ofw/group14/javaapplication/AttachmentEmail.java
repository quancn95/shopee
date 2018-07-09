package com.ofw.group14.javaapplication;

import java.net.URL;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class AttachmentEmail {
	public static void main(String[] args) {
		try {
			MultiPartEmail email = new MultiPartEmail();
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath("C:/Users/VS9 X64bit/Desktop/avatar.jpg");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("avater image");
			attachment.setName("avater");
			
			EmailAttachment attachment2 = new EmailAttachment();
			attachment2.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
			attachment2.setDisposition(EmailAttachment.ATTACHMENT);
	          attachment2.setDescription("Apache logo");
	          attachment2.setName("Apache logo");
			
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthentication(Constants.MY_EMAIL, Constants.MY_PASSWORD);
			
			email.setSSLOnConnect(true);
			email.setFrom(Constants.MY_EMAIL);
			email.setSubject("email attachment");
			email.setMsg("got email");
			email.attach(attachment);
			email.attach(attachment2);
			
			email.addTo(Constants.FRIEND_EMAIL,"simple man");
			email.send();
			System.out.println("send !");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
