package com.ofw.group14.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofw.group14.dao.OrdersDao;
import com.ofw.group14.entity.Orders;
import com.ofw.group14.service.OrdersService;

/** 
 * @author VS9X64bit
 * class Service implement interface Sercvice
 */
@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	OrdersDao ordersDao;
	
	public int addOrders(Orders orders) {
		// TODO Auto-generated method stub
		return ordersDao.addOrders(orders);
	}

}
