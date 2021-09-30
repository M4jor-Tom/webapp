package com.boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("mdp")
				.roles("USER")
				.build();
		UserDetails admin =
				User.withDefaultPasswordEncoder()
				.username("admin")
				.password("mdp")
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}
}
