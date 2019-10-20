package com.estore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/home/index")
	public String index(Model model) {
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
