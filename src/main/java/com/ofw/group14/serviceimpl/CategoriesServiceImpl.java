package com.ofw.group14.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofw.group14.dao.CategoriesDao;
import com.ofw.group14.entity.Categories;
import com.ofw.group14.service.CategoriesService;
/** 
 * @author VS9X64bit
 * class Service implement interface Sercvice
 */
@Service
public class CategoriesServiceImpl implements CategoriesService {
	
	@Autowired
	CategoriesDao categoriesDao;
	
	public List<Categories> getCategories() {
		// TODO Auto-generated method stub
		return categoriesDao.getCategories();
	}

}
