package com.ofw.group14.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ofw.group14.entity.User;
import com.ofw.group14.entity.Verification;
import com.ofw.group14.service.LoginService;
import com.ofw.group14.service.UserService;
import com.ofw.group14.serviceimpl.ValidationServiceImpl;

/**
 * @author VS9X64bit
 * function control user sign-up
 */ 
@Controller 
@SessionAttributes({"username","avatar","user"})
public class RegisterController {

	@GetMapping("/signup")
	public String getRegister(){
		return "/frontend/register";
	}
	
	@Autowired
	LoginService loginService;
	@Autowired
	UserService userService;
	@Autowired
	ValidationServiceImpl valid ;
	 @Autowired
	 private JavaMailSender mailSender;
	
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	/**
	 * function user register a new acount on system
	 * @param request
	 * @param map
	 * @param redirectAttributes
	 * @return view register
	 */
	@RequestMapping(value={"/signup"},method = RequestMethod.POST)
	public String execSignup(HttpServletRequest request,ModelMap map, RedirectAttributes redirectAttributes	){
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String passWord = request.getParameter("password");
		String repassWord = request.getParameter("repassword"); 
		 
		
		System.out.println(format.format(timestamp.getTime()));
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String username = valid.validUserName(userName);
		String emailaddress = valid.validEmailAddress(email);
		String password = valid.validPassWord(passWord);
		String repassword =valid.validPassWordAgian(passWord, repassWord);
		String token = UUID.randomUUID().toString();
		if(username==""&& emailaddress==""&& password=="" && repassword==""){
			User user = new User();
			user.setEmail(email);
			user.setUserName(userName);
			user.setPassWord(ValidationServiceImpl.MD5Crypt(passWord));
			user.setAvatar("avatar.jpg"); 
			user.setJoindDate(timestamp); 
			 
			boolean addUser = userService.addUser(user);
			if(addUser){
				
				Verification verification = new Verification();
				verification.setUser(user);
				verification.setToken(token);
				verification.setExpiryDate(timestamp);
				userService.addToken(verification);
				
				String recipient = user.getEmail();
				String subject = "Registration Confirmation";
				String urlconfirm = "http://localhost:8080/FrameWorkOriented/regitrationConfirm?token="+token;
				
				SimpleMailMessage mail = new SimpleMailMessage();
				mail.setTo(recipient);
				mail.setSubject(subject);
				mail.setText("Click this link to success active your account \n" +urlconfirm);
				mailSender.send(mail);
				System.out.println("send mail");
				return "redirect:/success";
			}else{
				map.addAttribute("checkregister","That bai");
			}
		} 
		if(username!=""|| emailaddress!="" || password!="" || repassword!=""){
			map.addAttribute("usercontain",userName);
			map.addAttribute("emailcontain",email);
		} 
		if(username!=""){
			map.addAttribute("errorUserName",username);
			
		} 
		if(emailaddress!=""){
			map.addAttribute("errorEmailAddress",emailaddress);
			
		} 
		if(password!=""){
			map.addAttribute("errorPasswd",password);
		} 
		if(repassword!=""){
			map.addAttribute("errorPasswdAgain",repassword);
		}
		
		return "/frontend/register";
	}
	
	/*@RequestMapping(value="/success",method={RequestMethod.GET})
	public String doGetSuccess(){
	     
	    return "/frontend/success";
	}*/

	
	/**
	 * Method verify new acount has been created is valid
	 * @param request with token on url has sent to user's email 
	 * @param map
	 * @param token
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value={"/regitrationConfirm"},method = RequestMethod.GET)
	public String regitrationConfirm(HttpServletRequest request,ModelMap map, @RequestParam String token, HttpSession httpSession){
		Verification verification = userService.getToken(token);
		if(verification == null){
			map.addAttribute("nulltoken"," Null token "); 
		}
	
		User user = verification.getUser();
		Calendar calendar = Calendar.getInstance();
		long diffHours = (calendar.getTime().getTime() - verification.getExpiryDate().getTime())/(60*60*1000);
		 
		if(diffHours > 24){ 
			System.out.println(verification.getExpiryDate() + " "+diffHours);
			map.addAttribute("expiredout","Token time out "+diffHours);
		}
		  
		user.setEnabled(true);
		userService.saveUser(user);  
		System.out.println(user.getUserName());
		return "redirect:/login";
	}
	
	/////
	static String emailToRecipient, emailSubject, emailMessage;
	static final String emailFromRecipient = "quancn995@gmail.com";

	static ModelAndView modelViewObj;

	@Autowired
	private JavaMailSender mailSenderObj;

	/*@RequestMapping(value = {"/emailForm"}, method = RequestMethod.GET)
	public ModelAndView showEmailForm(ModelMap model) {
		modelViewObj = new ModelAndView("/frontend/emailForm");
		return  modelViewObj;		
	}*/
	@GetMapping("/emailForm")
	public String emailForm(){
		
		return "/frontend/emailForm";
	}
	
	// This Method Is Used To Prepare The Email Message And Send It To The Client
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public ModelAndView sendEmailToClient(HttpServletRequest request, final @RequestParam CommonsMultipartFile attachFileObj) {

		// Reading Email Form Input Parameters		
		emailSubject = request.getParameter("subject");
		emailMessage = request.getParameter("message");
		emailToRecipient = request.getParameter("mailTo");

		// Logging The Email Form Parameters For Debugging Purpose
		System.out.println("\nReceipient?= " + emailToRecipient + ", Subject?= " + emailSubject + ", Message?= " + emailMessage + "\n");

		mailSenderObj.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
				mimeMsgHelperObj.setTo(emailToRecipient);
				mimeMsgHelperObj.setFrom(emailFromRecipient);				
				mimeMsgHelperObj.setText(emailMessage);
				mimeMsgHelperObj.setSubject(emailSubject);

				// Determine If There Is An File Upload. If Yes, Attach It To The Client Email				
				if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals(""))) {
					System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
					mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() {					
						public InputStream getInputStream() throws IOException {
							return attachFileObj.getInputStream();
						}
					});
				} else {
					System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
				}
			}
		});
		System.out.println("\nMessage Send Successfully.... Hurrey!\n");

		modelViewObj = new ModelAndView("/frontend/success","messageObj","Thank You! Your Email Has Been Sent!");
		return  modelViewObj;	
	}
	
	
	 
	/*@RequestMapping(value="/prgTest.html",method={RequestMethod.GET})
	public String doGet(Model model){
	    PRGForm prgForm = new PRGForm();
	    model.addAttribute("prgForm", prgForm);
	    return "prgTest";
	}
	@RequestMapping(value="/prgTest.html",method={RequestMethod.POST})
	public String doPost(PRGForm prgForm, Model model){
		redirectAttributes.addFlashAttribute(request);
	    return "redirect:/prgTest.html";
	}*/
}
