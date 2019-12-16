package com.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHomeController {
	
	@RequestMapping("/admin/home/index")
	public String index(Model model) {
		return "admin/home/index";
	}
	
}
