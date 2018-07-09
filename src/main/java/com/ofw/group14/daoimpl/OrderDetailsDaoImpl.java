package com.ofw.group14.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ofw.group14.dao.OrderDetailsDao;
import com.ofw.group14.entity.OrderDetails;
import com.ofw.group14.entity.OrderDetailsID;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderDetailsDaoImpl implements OrderDetailsDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addOrderDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.getCurrentSession(); 
			try {
				OrderDetailsID id =  (OrderDetailsID) session.save(orderDetails);
				if(id != null){
					return true;
				}else
					return false;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	 
	}

}
