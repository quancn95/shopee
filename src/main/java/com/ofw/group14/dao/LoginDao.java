package com.ofw.group14.dao;

import com.ofw.group14.entity.User;

/**
 * 
 * @author VS9X64bit
 * interface for Data access object layer
 */
public interface LoginDao {
	boolean checkLogin(String tendangnhap, String matkhau); 
}
