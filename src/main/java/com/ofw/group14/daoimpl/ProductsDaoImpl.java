package com.ofw.group14.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ofw.group14.dao.ProductsDao;
import com.ofw.group14.entity.Products;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ProductsDaoImpl implements ProductsDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * query db to select a quantity items  
	 */
	@Transactional
	public List<Products> getNewProducts(int num) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from products order by product_id desc";
		try {
			//List<Products> listProducts = (List<Products>) session.createQuery("from book ").setFirstResult(num).setMaxResults(8).getResultList();
			Query query = session.createQuery(hql).setMaxResults(num); 
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
 
	/**
	 * query select from db all items with decrease items've been sold
	 */
	@Transactional
	public List<Products> getCommonProducts(int num) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from products order by products_sold desc";
		try {
			Query query = session.createQuery(hql).setMaxResults(num);  
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * select from db to get an item with id-item input
	 * (non-Javadoc)
	 * @see com.ofw.group14.dao.ProductsDao#getProductDetailbyId(int)
	 */
	@Transactional
	public Products getProductDetailbyId(int idproduct) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from products where product_id=:idproduct";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("idproduct", idproduct);
			return (Products) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}

	/**
	 * query get items on db with input're id-category and indexs(min-max result) to pagination
	 */
	@Transactional
	public List<Products> getProductsbyCategory(int categoryId, int at, int total) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from products where category_id =:categoryId order by product_id desc";
		try { 
			Query query = session.createQuery(hql).setFirstResult(at).setMaxResults(total);
			query.setParameter("categoryId", categoryId);
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * query get all items on db  
	 */
	@Transactional
	public List<Products> getAllProduct() {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from products order by product_id desc";
		try { 
			Query query = session.createQuery(hql);
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	
	/**
	 * query get all related items with chosen item on db  
	 */
	@Transactional
	public List<Products> getRelatedProduct(int idproduct, int num) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="FROM products where categories in (select categories from products "
					+ "where product_id =:idproduct ) order by rand() ";
		try { 
			Query query = session.createQuery(hql).setMaxResults(num);
			query.setParameter("idproduct", idproduct);
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * query get items on db with input're indexs(min-max result) to pagination
	 * 
	 */
	@Transactional
	public List<Products> getProductsLimit(int at, int total) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from products order by product_id desc";
		try {
			Query query = session.createQuery(hql).setFirstResult(at).setMaxResults(total); 
			return query.getResultList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * query detele an item on db 
	 */
	@Transactional
	public boolean deleteProductSelected(int productid) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Products object = new Products();
			object.setProduct_id(productid);
			
			session.createQuery("delete orderdetails where product_id ="+productid).executeUpdate();
			session.delete(object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * query add new item on db
	 */
	@Transactional
	public boolean addProduct(Products products) {
		Session session = sessionFactory.getCurrentSession();
		try {
			int save = (Integer) session.save(products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * query update an item on db
	 */
	@Transactional
	public boolean updateProduct(Products products) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * query get items on db with input're indexs(min-max result) to pagination  
	 */
	@Transactional
	public List<Products> getProductPaging(int result, int offsetreal) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Products.class);
		criteria.setFirstResult(offsetreal);
		criteria.setMaxResults(result);
		List<Products>  products = (List<Products>)criteria.list();
		return products;
	}

	@Transactional
	public int getSize() {
		return sessionFactory.getCurrentSession().createCriteria(Products.class).list().size();
	}
	
	
	 

}
