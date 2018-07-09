package com.ofw.group14.serviceimpl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ofw.group14.daoimpl.LoginDaoImpl;
import com.ofw.group14.entity.User;
import com.ofw.group14.service.LoginService;

/** 
 * @author VS9X64bit
 * class Service implement interface Sercvice
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDaoImpl loginDaoImpl;
	
	public boolean checkLogin(String tendangnhap, String matkhau) {
		// TODO Auto-generated method stub
		boolean check = loginDaoImpl.checkLogin(tendangnhap, matkhau);
		return check;
	}
	
	
	 

}
