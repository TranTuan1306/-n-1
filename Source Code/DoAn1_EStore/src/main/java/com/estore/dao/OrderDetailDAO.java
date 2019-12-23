package com.estore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estore.entity.OrderDetail;

@Transactional
@Repository
public class OrderDetailDAO {
	@Autowired
	SessionFactory factory;
	
	public List<OrderDetail> findAll(){
		Session session = factory.getCurrentSession();
		String hql = "FROM OrderDetail";
		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		List<OrderDetail> list = query.getResultList();
		return list;
	}
	
	public OrderDetail findById(Integer id) {
		Session session = factory.getCurrentSession();
		OrderDetail entity = session.find(OrderDetail.class, id);
		return entity;
	}

	public OrderDetail create(OrderDetail entity){
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}
	
	public void update(OrderDetail entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
	}
	
	public void delete(Integer id) {
		Session session = factory.getCurrentSession();
		session.delete(session.find(OrderDetail.class, id));
	}
}
