package com.estore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estore.entity.Product;

@Transactional
@Repository
public class ProductDAO {
	@Autowired
	SessionFactory factory;
	
	public List<Product> findAll(){
		Session session = factory.getCurrentSession();
		String hql = "FROM Product";
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		List<Product> list = query.getResultList();
		return list;
	}
	
	public Product findById(Integer id) {
		Session session = factory.getCurrentSession();
		Product entity = session.find(Product.class, id);
		return entity;
	}

	public Product create(Product entity){
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(Product entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public void delete(Integer id) {
		Session session = factory.getCurrentSession();
		session.delete(session.find(Product.class, id));
	}
	
	public List<Product> findByKeywords(String keywords) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Product p WHERE "
				+ " p.name LIKE :kw OR "
				+ " p.category.name LIKE :kw OR "
				+ " p.category.nameVN LIKE :kw";
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("kw", "%"+keywords+"%");
		List<Product> list = query.getResultList();
		return list;
	}
}
