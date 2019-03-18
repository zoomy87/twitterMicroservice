/**
 * 
 */
package com.seniorproject.twitterMicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ericz
 *
 */

//@EnableWebMvc
//@Configuration
public class WebConfig implements WebMvcConfigurer {

//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
//
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addViewControllers(registry);
//		
//		registry.addViewController("/")
//			.setViewName("forward:/index");
//		registry.addViewController("/index");
//		registry.addViewController("/secure");
//	}
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**")
//			.addResourceLocations("/resources/");
//	}
//
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
//	
//	@Bean
//	public RequestContextListener requestContextListener() {
//		return new RequestContextListener();
//	}
//	
}
