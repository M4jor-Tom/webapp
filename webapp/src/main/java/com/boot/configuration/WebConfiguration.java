package com.boot.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

	@Bean
	ServletRegistrationBean<WebServlet> h2ConsoleRegistration() {
		return new ServletRegistrationBean<WebServlet>(new WebServlet(), "/console/*");
	}
}
