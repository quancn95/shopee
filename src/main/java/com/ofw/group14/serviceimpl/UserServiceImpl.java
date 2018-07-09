package com.ofw.group14.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofw.group14.daoimpl.UserDaoImpl;
import com.ofw.group14.entity.User;
import com.ofw.group14.entity.Verification;
import com.ofw.group14.service.UserService;

/** 
 * @author VS9X64bit
 * class Service implement interface Sercvice
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	public User getUserbyName(String username){
		return userDaoImpl.getUserbyName(username);
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		boolean  checkAdd = userDaoImpl.addUser(user);
		return checkAdd;
	}
	public boolean addToken(Verification verification) {
		// TODO Auto-generated method stub
		boolean  checkAdd = userDaoImpl.addToken(verification);
		return checkAdd;
	}
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		  userDaoImpl.saveUser(user); 
	}
	
	public boolean checkUserExists(String username){
		boolean check = userDaoImpl.checkUserExists(username);
		return check;
	}
	public boolean checkEmailExists(String email){
		boolean check = userDaoImpl.checkEmailExists(email);
		return check;
	}

	public Verification getToken(String token) {
		// TODO Auto-generated method stub
		return userDaoImpl.getToken(token);
	}
}
