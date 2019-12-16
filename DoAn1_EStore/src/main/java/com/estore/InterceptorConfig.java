package com.estore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.estore.inter.AuthInterceptor;
import com.estore.inter.GlobalInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	GlobalInterceptor global;
	@Autowired
	AuthInterceptor auth;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(global)
			.addPathPatterns("/**")
			.excludePathPatterns("/admin/**");
		registry.addInterceptor(auth)
		.addPathPatterns("/account/change", "/account/edit", "/order/**");
	}
}
