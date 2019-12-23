package com.estore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estore.entity.Category;

@Transactional
@Repository
public class CategoryDAO {
	@Autowired
	SessionFactory factory;
	
	public List<Category> findAll(){
		Session session = factory.getCurrentSession();
		String hql = "FROM Category";
		TypedQuery<Category> query = session.createQuery(hql, Category.class);
		List<Category> list = query.getResultList();
		return list;
	}
	
	public Category findById(Integer id) {
		Session session = factory.getCurrentSession();
		Category entity = session.find(Category.class, id);
		return entity;
	}

	public Category create(Category entity){
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(Category entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public void delete(Integer id) {
		Session session = factory.getCurrentSession();
		session.delete(session.find(Category.class, id));
	}
}
