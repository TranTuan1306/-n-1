package com.estore.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.estore.dao.CustomerDAO;
import com.estore.entity.Customer;
import com.estore.service.CookieService;
import com.estore.service.MailerService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class AccountController {
	@Autowired
	CustomerDAO dao;
	
	@Autowired
	MailerService mailer;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CookieService cookie;
	
	@Autowired
	ServletContext app;
	
	@Autowired
	HttpServletRequest request;
	
	// login & logoff
	@GetMapping("/account/login")
	public String login(Model model) {
		String[] user = cookie.getvalue("user", "").split("~");
		if(user.length == 2) {
			model.addAttribute("username", user[0]);
			model.addAttribute("password", user[1]);
		}
		return "account/login";
	}
	@PostMapping("/account/login")
	public String login(Model model,
			@RequestParam("id") String id,
			@RequestParam("password") String pw,
			@RequestParam(name="remember", defaultValue="false") Boolean rm) {
		Customer user = dao.findById(id);
		if(user == null) {
			model.addAttribute("message", "Tên người sử dụng không hợp lệ!");
		}
		else if(!user.getPassword().equals(pw)) {
			model.addAttribute("message", "password không hợp lệ");
		}
		else if(!user.isActivated()) {
			model.addAttribute("messsage", "tài khoản chưa được kích hoạt!");
		}
		else {
			model.addAttribute("message", "Đăng nhập thành công!");
			session.setAttribute("user", user);
			if(rm==false) {
				cookie.create("user", "", 0);
			}
			else {
				cookie.create("user", id+"~"+pw, 30);
			}
			String secureUrl = (String) session.getAttribute("secure-url");
			if(secureUrl != null) {
				return "redirect:"+secureUrl;
			}
		}
		return "account/login";
	}
	@RequestMapping("/account/logoff")
	public String logoff(Model model) {
		session.removeAttribute("user");
		return "redirect:/home/index";
	}
	
	//register & activate
	@RequestMapping("/account/register")
	public String register(@ModelAttribute("user") Customer user) {
		return "account/register";
	}
	
	@PostMapping("/account/register")
	public String register(Model model,
			@Validated @ModelAttribute("user") Customer user,
			BindingResult errors,
			@RequestParam("_photo") MultipartFile _photo) {
		user.setActivated(false);
		user.setAdmin(false);
		if(_photo.isEmpty()) {
			user.setPhoto("user.png");
		}
		else {
			String filename = _photo.getOriginalFilename();
			filename = UUID.randomUUID()+filename.substring(filename.lastIndexOf('.'));
			user.setPhoto(filename);
			String path = app.getRealPath("/static/images/customers/"+user.getPhoto());
			try {
				_photo.transferTo(new File(path));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(errors.hasErrors()) {
			model.addAttribute("message", "vui lòng sửa các lỗi sau: ");
		}
		else {
			dao.create(user);
			model.addAttribute("message", "đăng lý thành công!");
			user.setActivated(true);
			dao.update(user);
		}
		return "account/register";
	}
	
//	 forgot password
	@GetMapping("/account/forgot")
	public String forgot(Model model) {
		return "account/forgot";
	}
	@PostMapping("/account/forgot")
	public String forgot(Model model,
			@RequestParam("id") String id,
			@RequestParam("email") String email) {
		Customer user = dao.findById(id);
		if(user==null) {
			model.addAttribute("message", "Tên người dùng không hợp lệ!");
		}
		else if(!email.equals(user.getEmail())) {
			model.addAttribute("message", "email đăng nhập không hợp lệ!");
		}
		else {
			model.addAttribute("message", "mật khẩu đã gửi về người dùng!");
			String subject = "Your password";
			String body = user.getPassword();
			mailer.send(user.getEmail(), subject, body);
		}
		return "account/forgot";
	}
	
	// change password
	@GetMapping("/account/change")
	public String change(Model model) {
		return "account/change";
	}
	@PostMapping("account/change")
	public String change(Model model,
			@RequestParam("id") String id,
			@RequestParam("password") String pw,
			@RequestParam("password") String pw1,
			@RequestParam("password") String pw2) {
		if(!pw1.equals(pw2)) {
			model.addAttribute("message", "Xác nhận mật khẩu không hợp lệ!");
		}
		else {
			Customer user = dao.findById(id);
			if(user == null) {
				model.addAttribute("message", "Tên người dùng không hợp lệ!");			
			}
			else if(!pw.equals(user.getPassword())){
				model.addAttribute("message", "Mật khẩu không hợp lệ!");
			}
			else {
				user.setPassword(pw1);
				dao.update(user);
				model.addAttribute("message", "Mật khẩu của bạn đã được thay đổi!");
			}
		}
		return "account/change";
	}
	 
	// profile edition
	@GetMapping("/account/edit")
	public String edit(Model model) {
		model.addAttribute("user", session.getAttribute("user"));
		return "account/edit";
	}
	@PostMapping("/account/edit")
	public String edit(Model model,
			@Validated @ModelAttribute("user") Customer user,
			BindingResult errors,
			@RequestParam("_photo") MultipartFile file) {
		if(!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			filename = UUID.randomUUID()+filename.substring(filename.lastIndexOf('.'));
			user.setPhoto(filename);
			String path = app.getRealPath("/static/images/customers/"+user.getPhoto());
			try {
				file.transferTo(new File(path));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(errors.hasErrors()) {
			model.addAttribute("massage", "Vui lòng sửa các lỗi sau!");
		}
		else {
			dao.update(user);
			session.setAttribute("user", user);
			session.setAttribute("message", "Cập nhật thành công !");
		}
		return "account/edit";
	}
}


















