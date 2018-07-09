package com.ofw.group14.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ofw.group14.dao.OrdersDao;
import com.ofw.group14.entity.Orders;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public int addOrders(Orders orders) {
		Session session = sessionFactory.getCurrentSession();  
				int id =  (Integer) session.save(orders); 
				if(id>0){
					return id;
				}else{
					return 0;
				} 
	}

}
