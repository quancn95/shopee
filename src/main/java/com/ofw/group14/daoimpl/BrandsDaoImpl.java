package com.ofw.group14.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ofw.group14.dao.BrandsDao;
import com.ofw.group14.entity.Brands;

/**
 * @author VS9X64bit
 * class data-access  implement interface _Dao 
 * 
 */
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class BrandsDaoImpl implements BrandsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * query database return data're  Brands on system 
	 */
	@Transactional 
	public List<Brands> getBrands() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession(); 
		List<Brands> listBrands ;
		try {
			listBrands = (List<Brands>) session.createQuery("from brands ").getResultList();
 
			return listBrands;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}

}
