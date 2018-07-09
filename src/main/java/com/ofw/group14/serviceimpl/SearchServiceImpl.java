package com.ofw.group14.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofw.group14.dao.SearchDao;
import com.ofw.group14.entity.Products;
import com.ofw.group14.service.SearchService;

/** 
 * @author VS9X64bit
 * class Service implement interface Sercvice
 */
@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	SearchDao searchDao;
	
	public List<Products> search(String keyword) {
		// TODO Auto-generated method stub
		return searchDao.search(keyword);
	}

	public void indexProducts()throws Exception {
		// TODO Auto-generated method stub
		searchDao.indexProducts();
	}

	public void addProductToDB(String name, String description, String desciption_detail) {
		// TODO Auto-generated method stub
		searchDao.addProductToDB(name, description, desciption_detail);
	}

}
