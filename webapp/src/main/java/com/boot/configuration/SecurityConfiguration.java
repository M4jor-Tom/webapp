package com.boot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.headers().frameOptions().disable()
			.and()
				.authorizeRequests()
				.antMatchers("/", "/console/*").permitAll()
				.anyRequest().permitAll()
	        .and()
	        	.formLogin().loginPage("/login").permitAll()
	        .and()
	        	.logout().permitAll()
			.and()
				.csrf().disable();
	}
}
