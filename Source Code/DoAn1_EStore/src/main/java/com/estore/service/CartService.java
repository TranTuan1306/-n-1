package com.estore.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.estore.dao.ProductDAO;
import com.estore.entity.Product;

@SessionScope
@Service("cart")
public class CartService {
	@Autowired
	ProductDAO dao;
	
	Map<Integer, Product> map = new HashMap<>();
	public void add(Integer id) {
		Product p = map.get(id);
		if(p == null) {
			p = dao.findById(id);
			p.setQuantity(1);
			map.put(id, p);
		}
		else {
			p.setQuantity(p.getQuantity() + 1);
		}
	}
	public void remove(Integer id) {
		map.remove(id);
	}
	public void update(Integer id, int qtt) {
		Product p = map.get(id);
		p.setQuantity(qtt);
	}
	public void clear() {
		map.clear();
	}
	public Collection<Product> getItems() {
		return map.values();
	}
	public int getCount() {
		int count = 0;
		for(Product p : getItems()) {
			count += p.getQuantity();
		}
		return count;
	}
	public double getAmount() {
		double amount = 0;
		for(Product p : getItems()) {
			amount += p.getQuantity() * p.getUnitPrice() * (1-p.getDiscount());
		}
		return amount;
	}
}
