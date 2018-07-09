package com.ofw.group14.daoimpl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ofw.group14.dao.LoginDao;
import com.ofw.group14.entity.User;

 


@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class LoginDaoImpl  implements LoginDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * query database to check user login  with username and password 
	 */
	@Transactional
	public boolean checkLogin(String tendangnhap, String matkhau) {
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "select username, password FROM user WHERE username = :user_name AND password = :password";
			Query query = session.createQuery(hql);
			query.setParameter("user_name", tendangnhap);
			query.setParameter("password", matkhau);
			User user = (User) query.getSingleResult();
			
			if(user!=null){
				return true;
			}else
				return false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	  
	 
	
	/*@Transactional
	public boolean loginExecute(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		try {
			User user = (User) session.createQuery("  from user where email='"+username+"' "
					+ "and password='"+password+"' ").getSingleResult();
			if(user!=null){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {  
			return false;
		} 
		
	}*/
	
	
	
	

	

 
	
	
	 

}
