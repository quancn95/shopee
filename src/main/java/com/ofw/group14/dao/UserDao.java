package com.ofw.group14.dao;

import com.ofw.group14.entity.User;
import com.ofw.group14.entity.Verification;

/**
 * 
 * @author VS9X64bit
 * interface for Data access object layer
 */
public interface UserDao {
	 User getUserbyName(String username);
	 boolean addUser(User user);
	 void saveUser(User user);
	 boolean addToken(Verification verification);
	 Verification getToken(String token);
	 boolean checkUserExists(String username);
	 boolean checkEmailExists(String email);
}
