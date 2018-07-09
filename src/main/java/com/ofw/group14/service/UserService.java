package com.ofw.group14.service;

import com.ofw.group14.entity.User;
import com.ofw.group14.entity.Verification;

/**
 * 
 * @author VS9X64bit
 * interface for business layer
 */
public interface UserService {

	 User getUserbyName(String username);
	 boolean addUser(User user);
	 void saveUser(User user);
	 boolean addToken(Verification verification);
	 Verification getToken(String token);
	 boolean checkUserExists(String username);
	 boolean checkEmailExists(String email);
}
