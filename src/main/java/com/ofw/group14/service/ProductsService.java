package com.ofw.group14.service;

import java.util.List;

import com.ofw.group14.entity.Products;

/**
 * 
 * @author VS9X64bit
 * interface for business layer
 */
public interface ProductsService {
	List<Products> getNewProducts(int num);
	List<Products> getProductsLimit(int at, int total);
	List<Products> getCommonProducts(int num);
	Products getProductDetailbyId(int idproduct);
	List<Products> getProductsbyCategory(int categoryId, int at, int total);
	List<Products> getAllProduct();
	List<Products> getRelatedProduct(int idproduct, int num);
	boolean deleteProductSelected(int productid);
	boolean addProduct(Products products);
	boolean updateProduct(Products products);
	
	List<Products> getProductPaging(int result, int offsetreal) ; 
	int getSize();
}
