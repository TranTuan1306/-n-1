package com.estore.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.estore.dao.CategoryDAO;
import com.estore.dao.ProductDAO;
import com.estore.entity.Category;
import com.estore.entity.Product;

@Controller
public class AdminProductController {
	@Autowired
	ProductDAO pdao;
	
	@Autowired
	ServletContext app;
	
	@Autowired
	CategoryDAO cdao;
	
	@RequestMapping("/admin/product/index")
	public String index(Model model) {
		model.addAttribute("form", new Product());
		model.addAttribute("list", pdao.findAll());
		return "admin/product/index";
	}
	
	@RequestMapping("/admin/product/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("form", pdao.findById(id));
		model.addAttribute("list", pdao.findAll());
		return "admin/product/index";
	}
	
	@RequestMapping("/admin/product/create")
	public String create(Model model, Product form, 
			@RequestParam("_photo") MultipartFile _photo) throws IllegalStateException, IOException {
		if(!_photo.isEmpty()) {
			String filename = _photo.getOriginalFilename();
			form.setImage(filename);
			String path = app.getRealPath("/static/images/products/" + form.getImage());
			_photo.transferTo(new File(path));
		}
		else {
			form.setImage("user.png");
		}
		pdao.create(form);
		model.addAttribute("form", new Product());
		model.addAttribute("list", pdao.findAll());
		model.addAttribute("message", "Bạn đã thêm mới 1 product thành công");
		return "admin/product/index";
	}
	
	@RequestMapping("/admin/product/update")
	public String update(Model model, @ModelAttribute("form") Product form, 
			@RequestParam("_photo") MultipartFile _photo) throws IllegalStateException, IOException {
		if(!_photo.isEmpty()) {
			String filename = _photo.getOriginalFilename();
			form.setImage(filename);
			String path = app.getRealPath("/static/images/products/" + form.getImage());
			_photo.transferTo(new File(path));
		}
		pdao.update(form);
		model.addAttribute("list", pdao.findAll());
		model.addAttribute("message", "Cập nhật thành công!");
		return "admin/product/index";
	}
	
	@RequestMapping("/admin/product/delete")
	public String delete(Model model, @RequestParam("id") Integer id) {
		pdao.delete(id);
		model.addAttribute("form", new Product());
		model.addAttribute("list", pdao.findAll());
		model.addAttribute("message", "Xóa thành công!");
		return "admin/product/index";
	}
	
	@ModelAttribute("cates")
	public List<Category> getCategories(){
		return cdao.findAll();
	}
	
}
