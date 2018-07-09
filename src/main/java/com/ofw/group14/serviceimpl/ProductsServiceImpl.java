package com.ofw.group14.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofw.group14.dao.ProductsDao;
import com.ofw.group14.entity.Products;
import com.ofw.group14.service.ProductsService; 

/** 
 * @author VS9X64bit
 * class Service implement interface Sercvice
 */
@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	ProductsDao productsDao; 

	public List<Products> getNewProducts(int num) {
		// TODO Auto-generated method stub
		return productsDao.getNewProducts(num);
	}

	public List<Products> getCommonProducts(int num) {
		// TODO Auto-generated method stub
		return productsDao.getCommonProducts(num);
	}

	public Products getProductDetailbyId(int idproduct) {
		// TODO Auto-generated method stub
		return productsDao.getProductDetailbyId(idproduct);
	}

	public List<Products> getProductsbyCategory(int categoryId, int at , int total) {
		// TODO Auto-generated method stub
		return productsDao.getProductsbyCategory(categoryId, at, total);
	}

	public List<Products> getAllProduct() {
		// TODO Auto-generated method stub
		return productsDao.getAllProduct();
	}

	public List<Products> getRelatedProduct(int idproduct, int num) {
		// TODO Auto-generated method stub
		return productsDao.getRelatedProduct(idproduct, num);
	}

	public List<Products> getProductsLimit(int at, int total) {
		// TODO Auto-generated method stub
		return productsDao.getProductsLimit(at, total);
	}

	public boolean deleteProductSelected(int productid) {
		// TODO Auto-generated method stub
		return productsDao.deleteProductSelected(productid);
	}

	public boolean addProduct(Products products) {
		// TODO Auto-generated method stub
		return productsDao.addProduct(products);
	}

	public boolean updateProduct(Products products) {
		// TODO Auto-generated method stub
		return productsDao.updateProduct(products);
	}

	public List<Products> getProductPaging(int result, int offsetreal) {
		// TODO Auto-generated method stub
		return productsDao.getProductPaging(result, offsetreal);
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return productsDao.getSize();
	}

	 

}
