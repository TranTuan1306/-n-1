package com.estore.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estore.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService cart;
	
	@ResponseBody
	@RequestMapping("/cart/update/{id}/{qtt}")
	public Map<String, Object> update(@PathVariable("id") Integer id,
			@PathVariable("qtt") Integer qtt) {
		cart.update(id, qtt);
		
		Map<String, Object> map = new HashMap<>();
		map.put("count", cart.getCount());
		map.put("amount", cart.getAmount());
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/cart/clear")
	private void clear() {
		cart.clear();
	}
	
	@ResponseBody
	@RequestMapping("/cart/remove/{id}")
	public Map<String, Object> remove(@PathVariable("id") Integer id){
		cart.remove(id);
		
		Map<String, Object> map = new HashMap<>();
		map.put("count", cart.getCount());
		map.put("amount", cart.getAmount());
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/cart/add/{id}")
	public Map<String, Object> add(@PathVariable("id") Integer id){
		cart.add(id);
		
		Map<String, Object> map = new HashMap<>();
		map.put("count", cart.getCount());
		map.put("amount", cart.getAmount());
		return map;
	}
	
	@RequestMapping("/cart/view")
	public String view(Model model) {
		model.addAttribute("cart", cart);
		return "cart/view";
	}
}
