package com.estore.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estore.dao.OrderDAO;
import com.estore.dao.OrderDetailDAO;
import com.estore.entity.Customer;
import com.estore.entity.Order;
import com.estore.entity.OrderDetail;
import com.estore.entity.Product;
import com.estore.service.CartService;

@Controller
public class OrderController {
	@Autowired
	CartService cart;
	@Autowired
	HttpSession session;
	
	@Autowired
	OrderDAO odao;
	@Autowired
	OrderDetailDAO ddao;

	@RequestMapping("order/items")
	public String purchasedItems(Model model) {
		Customer user = (Customer)session.getAttribute("user");
		List<Product> products = odao.findItemsByUser(user.getId());
		
		model.addAttribute("prods", products);
		return "order/items";
	}
	
	@RequestMapping("order/detail/{id}")
	private String detail(Model model, @PathVariable("id") Integer id) {
		Order order = odao.findById(id);
		model.addAttribute("order", order);
		return "order/detail";
	}
	@RequestMapping("/order/list")
	private String list(Model model) {
		Customer user = (Customer)session.getAttribute("user");
		List<Order> orders = odao.findByUser(user.getId());
		
		model.addAttribute("orders", orders);
		return "order/list";
	} 
	
	@RequestMapping("/order/checkout")
	public String checkout(Model model) {
		Order order = new Order();
		order.setOrderDate(new Date());
		order.setAmount(cart.getAmount());
		order.setCustomer((Customer)session.getAttribute("user"));
		
		model.addAttribute("order", order);
		return "order/checkout";
	}
	
	@RequestMapping("/order/purchase")
	public String checkout(Model model, Order order){
		List<OrderDetail> details = new ArrayList<>();
		for(Product p: cart.getItems()) {
			OrderDetail detail = new OrderDetail();
			detail.setProduct(p);
			detail.setOrder(order);
			detail.setUnitPrice(p.getUnitPrice());
			detail.setDiscount(p.getDiscount());
			detail.setQuantity(p.getQuantity());
			details.add(detail);
		}
		odao.create(order,details);
		cart.clear();
		return "redirect:/order/list";
	}
}
