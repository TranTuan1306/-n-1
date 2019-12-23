package com.estore.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.estore.dao.CustomerDAO;
import com.estore.entity.Customer;

@Controller
public class AdminCustomerController {
	@Autowired
	CustomerDAO cdao;
	
	@Autowired
	ServletContext app;
	
	@RequestMapping("/admin/customer/index")
	public String index(Model model) {
		model.addAttribute("form", new Customer());
		model.addAttribute("list", cdao.findAll());
		return "admin/customer/index";
	}
	
	@RequestMapping("/admin/customer/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		model.addAttribute("form", cdao.findById(id));
		model.addAttribute("list", cdao.findAll());
		return "admin/customer/index";
	}
	
	@RequestMapping("/admin/customer/create")
	public String create(Model model, Customer form, 
			@RequestParam("_photo") MultipartFile _photo) throws IllegalStateException, IOException {
		if(!_photo.isEmpty()) {
			String filename = _photo.getOriginalFilename();
			filename = UUID.randomUUID()+filename.substring(filename.lastIndexOf('.'));
			form.setPhoto(filename);
			String path = app.getRealPath("/static/images/customers/" + form.getPhoto());
			_photo.transferTo(new File(path));
		}
		else {
			form.setPhoto("user.png");
		}
		cdao.create(form);
		model.addAttribute("form", new Customer());
		model.addAttribute("list", cdao.findAll());
		model.addAttribute("message", "Đã thêm mới thành công!");
		return "admin/customer/index";
	}
	
	@RequestMapping("/admin/customer/update")
	public String update(Model model, @ModelAttribute("form") Customer form, 
			@RequestParam("_photo") MultipartFile _photo) throws IllegalStateException, IOException {
		if(!_photo.isEmpty()) {
			String filename = _photo.getOriginalFilename();
			form.setPhoto(filename);
			String path = app.getRealPath("/static/images/customers/" + form.getPhoto());
			_photo.transferTo(new File(path));
		}
		cdao.update(form);
		model.addAttribute("list", cdao.findAll());
		model.addAttribute("message", "Cập nhật thành công!");
		return "admin/customer/index";
	}
	
	@RequestMapping("/admin/customer/delete")
	public String delete(Model model, @RequestParam("id") String id) {
		cdao.delete(id);
		model.addAttribute("form", new Customer());
		model.addAttribute("list", cdao.findAll());
		model.addAttribute("message", "Xóa thành công!");
		return "admin/customer/index";
	}
	
}
