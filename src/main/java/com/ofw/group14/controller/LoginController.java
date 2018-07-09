package com.ofw.group14.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ofw.group14.dao.UserDao;
import com.ofw.group14.entity.Auth;
import com.ofw.group14.entity.User;
import com.ofw.group14.service.LoginService;
import com.ofw.group14.service.UserService;
import com.ofw.group14.serviceimpl.ValidationServiceImpl;

/**
 * @author VS9X64bit
 * Control function login and Internationalization then return views
 */
@Controller
@RequestMapping
@SessionAttributes({"username","avatar","user"})
public class LoginController {
	 
	
	@GetMapping(value = "/{locale:en|fr|vi}/login")  
	public String getLoginI18n(){
		return "frontend/login";
	}
	@GetMapping(value = "/login")  
	public String getLogin(HttpSession session){
		if(session.getAttribute("isLogin") != null && (Boolean) session.getAttribute("isLogin") == true){
			return "redirect:/success";
		}
		return "frontend/login";
	}
	
	@Autowired
	LoginService loginService;
	@Autowired
	UserService userService;
	@Autowired
	UserDao userDao;  
	
	@PostMapping(value = "/login")
	@Transactional
	public String excuteLogin(@RequestParam String tendangnhap,@RequestParam String matkhau,
			ModelMap modelMap,HttpSession session){
		
		User user = userService.getUserbyName(tendangnhap); 
		if(user != null){  
				if(user.getPassWord().equals(ValidationServiceImpl.MD5Crypt(matkhau))){ 
					modelMap.addAttribute("username",tendangnhap); 
					modelMap.addAttribute("avatar",user.getAvatar());
					modelMap.addAttribute("user",user);
					session.setAttribute("isLogin", true);
					session.setAttribute("role", user.getActive());
					 
					return "redirect:/";
				} else{ 
					modelMap.addAttribute("checklogin","Kiem tra lai mat khau khong chinh xac");
				} 
		}
		else{
			modelMap.addAttribute("checklogin","Tai khoan khong ton tai");
		}
		
		return "/frontend/login";
		
	}
	
	@Auth(role = Auth.Role.LOGIN)
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String needLogin() {
        return "success";
    }
	 
}
