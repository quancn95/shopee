package com.ofw.group14.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ofw.group14.dao.CategoriesDao;
import com.ofw.group14.entity.Categories;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CategoriesDaoImpl implements CategoriesDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * qurey database return all Categories on system
	 */
	@Transactional
	public List<Categories> getCategories() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		List<Categories> listCategories ;
		try {
			listCategories = (List<Categories>) session.createQuery("from categories ").getResultList();
 
			return listCategories;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

}
 