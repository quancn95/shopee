package com.ofw.group14.daoimpl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ofw.group14.dao.UserDao;
import com.ofw.group14.entity.User;
import com.ofw.group14.entity.Verification;

/**
 * @author VS9X64bit
 *
 */
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	 /**
	  * query to get user by username on db
	  */
	@Transactional
	public User getUserbyName(String username){
		 
			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM user WHERE username = :user_name";
			try {
				Query query = session.createQuery(hql);
				query.setParameter("user_name", username);
				  
				return (User) query.getSingleResult(); 
				
			} catch (NoResultException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}catch (NonUniqueResultException nure) {
				 // Code for handling NonUniqueResultException
				nure.printStackTrace();
				return null;
			}
	} 
	
	/*@Transactional
	public User getSingleResult(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM user WHERE username = :user_name ";
	    
	    Query query = session.createQuery(hql);
		query.setParameter("user_name", username);
		query.setMaxResults(1);
	    List<User> list = query.getResultList();
	    if (list.isEmpty()) return null;
        else if (list.size() == 1) return list.get(0);
        throw new NonUniqueResultException();
	}*/
	
	 
	 
	@Transactional
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();   
		try {
			int checkuser = (Integer) session.save(user);
			if(checkuser>0){
				return true;
			}else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Transactional
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();   
		try {
			  session.saveOrUpdate(user);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	@Transactional
	public boolean addToken(Verification verification) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();   
	 
			int check = (Integer) session.save(verification);
			if(check>0){
				return true;
			}else
				return false;
		 
		
	}
	/**
	 * token to verify user
	 */
	@Transactional
	public Verification getToken(String token) {
		
		Session session = sessionFactory.getCurrentSession();   
		try {
			 String hql = "from verification where token = :token ";
			 Query query = session.createQuery(hql);
			 query.setParameter("token", token);
			 Verification verification = (Verification) query.getSingleResult();
			 return verification;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	 
	/**
	 * query to check user's username is existed on db
	 */
	@Transactional
	public boolean checkUserExists(String username){ 
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "SELECT 1 FROM user WHERE username = :user_name "; 
			Query query = session.createQuery(hql);
			query.setParameter("user_name", username);
			int check =  (Integer) query.getSingleResult();  
			if(check>0){
				return true;
			}   
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return false;
	}
	
	/**
	 * query to check user's email is existed on db
	 */
	@Transactional
	public boolean checkEmailExists(String email){ 
		Session session = sessionFactory.getCurrentSession(); 
		try {
			String hql2 = "SELECT 1 FROM user WHERE email = :email "; 
			
			Query query = session.createQuery(hql2);
			query.setParameter("email", email);
			int check =  (Integer) query.getSingleResult();
			
			if(check>0){
				return true;
			}
		} catch (NoResultException e) {
			// TODO: handle exception
			return false;
		} 
			
		return false;
	}
}
