package com.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estore.dao.CategoryDAO;
import com.estore.dao.ProductDAO;
import com.estore.entity.Category;
import com.estore.entity.Product;

@Controller
public class ProductController {
	@Autowired
	CategoryDAO cdao;
	@Autowired
	ProductDAO pdao;
	
	@RequestMapping("/prod/list-by-cate/{id}")
	public String list(Model model, @PathVariable("id") Integer id) {
		Category category = cdao.findById(id);
		model.addAttribute("prods", category.getProducts());
		return "product/list";
	}
	
	@RequestMapping("/prod/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product product = pdao.findById(id);
		model.addAttribute("prod", product);
		return "product/detail";
	}
	
}
