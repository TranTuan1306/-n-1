package com.estore.service;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	public Cookie get(String name) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals(name)) {
					String value = new String(Base64.decodeBase64(cookie.getValue()));
					cookie.setValue(value);
					return cookie;
				}
			}
		}
		return null;
	}
	
	public void create(String name, String value, int days) {
		String encoded = Base64.encodeBase64String(value.getBytes());
		Cookie cookie = new Cookie(name, encoded);
		cookie.setPath("/");
		cookie.setMaxAge(days * 24 * 60 * 60);
		response.addCookie(cookie);
	}
	
	public void delete(String name) {
		this.create(name, "", 0);
	}
	
	public String getvalue(String name, String defaultValue) {
	Cookie cookie = this.get(name);
	if(cookie == null) {
		return defaultValue;
	}
	return cookie.getValue();
	}
}
