package com.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estore.dao.CategoryDAO;
import com.estore.entity.Category;


@Controller
public class AdminCategoryController {
	@Autowired 
	CategoryDAO cdao;
	
	@RequestMapping("/admin/category/index")
	public String index(Model model) {
		model.addAttribute("form", new Category());
		model.addAttribute("list", cdao.findAll());
		return "admin/category/index";
	}
	
	@RequestMapping("admin/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("form", cdao.findById(id));
		model.addAttribute("list", cdao.findAll());
		return "admin/category/index";
	}
	
	@RequestMapping("admin/category/create")
	public String create(Model model, Category form){
		cdao.create(form);
		model.addAttribute("form", new Category());
		model.addAttribute("list", cdao.findAll());
		model.addAttribute("message", "Đã thêm mới thành công!");
		return "admin/category/index";
	}
	
	@RequestMapping("/admin/category/update")
	public String update(Model model, @ModelAttribute("form") Category form) {
		cdao.update(form);
		model.addAttribute("list", cdao.findAll());
		model.addAttribute("message", "Cập nhật thành công!");
		return "admin/category/index";
	}
	
	@RequestMapping("/admin/category/delete")
	public String delete(Model model, @RequestParam("id") Integer id) {
		cdao.delete(id);
		model.addAttribute("form", new Category());
		model.addAttribute("list", cdao.findAll());
		model.addAttribute("message", "Xóa thành công!");
		return "admin/category/index";
	}

}
