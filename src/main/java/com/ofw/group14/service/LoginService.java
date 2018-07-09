package com.ofw.group14.service;

import com.ofw.group14.entity.User;

/**
 * 
 * @author VS9X64bit
 * interface for business layer
 */
public interface LoginService {
	boolean checkLogin(String tendangnhap, String matkhau); 
}
