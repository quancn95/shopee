package com.ofw.group14.dao;

import java.util.List;

import com.ofw.group14.entity.Products;

/**
 * 
 * @author VS9X64bit
 * interface for Data access object layer
 */
public interface SearchDao {
	public void indexProducts()throws Exception;
	public void addProductToDB(String name, String description, String desciption_detail);
	public List<Products> search(String keyword);
}
