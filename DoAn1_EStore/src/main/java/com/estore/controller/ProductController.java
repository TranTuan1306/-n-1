package com.estore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.estore.dao.CategoryDAO;
import com.estore.dao.ProductDAO;
import com.estore.entity.Category;
import com.estore.entity.Product;
import com.estore.service.MailerService;

@Controller
public class ProductController {
	@Autowired
	CategoryDAO cdao;
	@Autowired
	ProductDAO pdao;
	@Autowired
	MailerService mailer;
	@Autowired
	HttpServletRequest request;
	
	@ResponseBody
	@RequestMapping("/prod/send-to-friend/{id}")
	public String sendToFriend(
			@PathVariable("id") Integer id,
			@PathParam("from") String from,
			@PathParam("to") String to,
			@PathParam("subject") String subject,
			@PathParam("content") String content
			) {
		String url = request.getRequestURL().toString().replace("send-to-friend", "detail");
		content += "<hr><a href='?'>thông tin hàng hóa</a>".replace("?", url);
		
		mailer.send(to, subject, content, from);
		return "thông tin hàng hóa đã được gửi đến bạn bè";
	}
	
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
	
	@RequestMapping("/prod/list-by-keywords")
	public String listByKeywords(Model model, @RequestParam("keywords") String keywords) {
		List<Product> products = pdao.findByKeywords(keywords);
		model.addAttribute("prods", products);
		return "product/list";
	}

	@RequestMapping("/prod/list-by-spec/{id}")
	public String listBySpecials(Model model, @PathVariable("id") Integer id) {
		List<Product> products = pdao.findBySpecials(id);
		model.addAttribute("prods", products);
		return "product/list";
	}
	
	
}
