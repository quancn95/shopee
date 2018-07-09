package com.ofw.group14.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ofw.group14.dao.SearchDao;
import com.ofw.group14.entity.Products;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SearchDaoImpl implements SearchDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public void indexProducts() throws Exception {
		try {
			Session session = sessionFactory.getCurrentSession();
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
		} catch(Exception e) {
			throw e;
		}
	}
	
	@Transactional
	   public void addProductToDB(String name, String description, String desciption_detail)
	   {
	      Session session = sessionFactory.getCurrentSession();
	      
	     Products product = new Products();
	      
	      //Date dateNow = new Date();
	     //book.setUpdateDate(dateNow);
	     product.setName(name);
	      
	      
	      session.saveOrUpdate(product);
	   }

	/**
	 * function search info items on system with keyword
	 * search full text
	 */
	@Transactional
	public List<Products> search(String keyword) {
		List<Products> results = null;
		try {
			Session session = sessionFactory.getCurrentSession();

			FullTextSession fullTextSession = Search.getFullTextSession(session);

			QueryBuilder qb = fullTextSession.getSearchFactory()
						.buildQueryBuilder().forEntity(Products.class).get();
			org.apache.lucene.search.Query query = qb
						.keyword().onFields("name", "description", "desciption_detail") // Chỉ định tìm theo cột nào
						.matching(keyword)
						.createQuery();

			javax.persistence.Query hibQuery =
						fullTextSession.createFullTextQuery(query, Products.class);

			results = hibQuery.getResultList();
			return results;
	 	} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
}
