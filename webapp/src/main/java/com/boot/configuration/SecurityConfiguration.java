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
				.antMatchers("/").permitAll()
				.antMatchers("/console/*").permitAll()
			.and()
				.csrf().disable();
	}
}
