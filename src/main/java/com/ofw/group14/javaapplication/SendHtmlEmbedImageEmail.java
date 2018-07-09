package com.ofw.group14.javaapplication;

import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

public class SendHtmlEmbedImageEmail {
	   public static void main(String[] args) {
	       try {
	           // Mẫu  nội dung Email gửi đi.
	           // Ở đây Img có đường dẫn tương đối  (**)
	           String htmlEmailTemplate = "<h2>Hello!</h2>"
	                   +"This is Apache Logo <br/>"
	                   +"<img src='proper/commons-email/images/commons-logo.png'/>";            
	 
	           // Tạo đối tượng Email.
	           ImageHtmlEmail email = new ImageHtmlEmail();
	            
	 
	           // Cấu hình
	           email.setHostName("smtp.googlemail.com");
	           email.setSmtpPort(465);
	           email.setAuthenticator(new DefaultAuthenticator(
	                   Constants.MY_EMAIL, Constants.MY_PASSWORD));
	            
	           email.setSSLOnConnect(true);
	           email.setFrom(Constants.MY_EMAIL, "TRAN");
	 
	           email.addTo(Constants.FRIEND_EMAIL);
	           email.setSubject("Sending HTML formatted email with embedded images");
	 
	           // Định nghĩa URL cơ sở để xác định đúng vị trí nguồn dữ liệu (img,..)
	           // (Trong trường hợp nó có đường dẫn tương đối, ví dụ Img trên)
	           URL url = new URL("http://commons.apache.org");
	                    
	           email.setDataSourceResolver(new DataSourceUrlResolver(url) );
	            
	           // Sét nội dung email
	           email.setHtmlMsg(htmlEmailTemplate);
	 
	           // Sét đặt nội dung thay thế.
	           // (Trong trường hợp chương trình đọc email của người nhận ko hỗ trợ HTML).
	           email.setTextMsg("Your email client does not support HTML messages");
	 
	           // Gửi email
	           email.send();
	 
	           System.out.println("Sent!!");
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	   }
	}
