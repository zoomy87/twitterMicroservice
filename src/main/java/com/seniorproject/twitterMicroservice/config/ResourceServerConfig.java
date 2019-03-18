package com.seniorproject.twitterMicroservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//@Configuration
//@EnableResourceServer
public class ResourceServerConfig extends WebSecurityConfigurerAdapter{

//	@Lazy
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		// TODO Auto-generated method stub
//		return super.authenticationManagerBean();
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.requestMatchers()
//			.antMatchers("/login","/oauth/authorize")
//			.and()
//			.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.formLogin()
//			.permitAll();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.parentAuthenticationManager(authenticationManager)
//			.inMemoryAuthentication()
//			.withUser("Peter")
//			.password("peter")
//			.roles("USER");
//		
//	}
	
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

//	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
//		this.authenticationManager = authenticationManager;
//	}s
	
	
}


