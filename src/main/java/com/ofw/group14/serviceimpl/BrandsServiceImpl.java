package com.ofw.group14.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofw.group14.dao.BrandsDao;
import com.ofw.group14.entity.Brands;
import com.ofw.group14.service.BrandsService;

/**
 * 
 * @author VS9X64bit
 * class Service implement interface Sercvice
 */
@Service
public class BrandsServiceImpl implements BrandsService{
	@Autowired
	BrandsDao brandsDao;
	public List<Brands> getBrands() {
		// TODO Auto-generated method stub
		return brandsDao.getBrands();
	}

}
