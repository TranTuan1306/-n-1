package com.estore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estore.entity.Order;

@Transactional
@Repository
public class OrderDAO {
	@Autowired
	SessionFactory factory;
	
	public List<Order> findAll(){
		Session session = factory.getCurrentSession();
		String hql = "FROM Order";
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		List<Order> list = query.getResultList();
		return list;
	}
	
	public Order findById(Integer id) {
		Session session = factory.getCurrentSession();
		Order entity = session.find(Order.class, id);
		return entity;
	}

	public Order create(Order entity){
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(Order entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public void delete(Integer id) {
		Session session = factory.getCurrentSession();
		session.delete(session.find(Order.class, id));
	}
}
