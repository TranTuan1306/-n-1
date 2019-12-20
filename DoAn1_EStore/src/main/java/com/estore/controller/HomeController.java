package com.estore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estore.dao.ProductDAO;
import com.estore.entity.Product;

@Controller
public class HomeController {
	@Autowired
	ProductDAO pdao;
	
	@RequestMapping("/home/index")
	public String index(Model model) {
		List<Product> list = pdao.findBySpecials(0);
		model.addAttribute("prods", list);
		return "home/index";
	}
	
	@RequestMapping("/home/about")
	public String about(Model model) {
		return "home/about";
	}
	
	@RequestMapping("/home/contact")
	public String contact(Model model) {
		return "home/contact";
	}
	
	@RequestMapping("/home/feedback")
	public String feedback(Model model) {
		return "home/feedback";
	}
	
	@RequestMapping("/home/faq")
	public String faq(Model model) {
		return "home/faq";
	}
	
	@ResponseBody
	@RequestMapping("/home/lang")
	public void lang(Model model) {
	}
}
