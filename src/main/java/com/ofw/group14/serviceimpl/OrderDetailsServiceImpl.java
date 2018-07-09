package com.ofw.group14.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofw.group14.dao.OrderDetailsDao;
import com.ofw.group14.entity.OrderDetails;
import com.ofw.group14.service.OrderDetailsService;

/** 
 * @author VS9X64bit
 * class Service implement interface Sercvice
 */
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsDao orderDetailsDao;
	
	public boolean addOrderDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		return orderDetailsDao.addOrderDetails(orderDetails);
	}

}
