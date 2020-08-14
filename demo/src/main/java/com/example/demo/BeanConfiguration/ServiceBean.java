package com.example.demo.BeanConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.ServiceInter.DimissionService;
import com.example.demo.ServiceInter.EntryService;
import com.example.demo.ServiceInter.UserService;
import com.example.demo.ServiceInterImpl.DimissionServiceImpl;
import com.example.demo.ServiceInterImpl.EntryServiceImpl;
import com.example.demo.ServiceInterImpl.UserServiceImpl;

@Configuration
public class ServiceBean {
	@Bean
	public UserService userService(@Autowired UserServiceImpl bean) {	
		return bean;
	}
	
	@Bean
	public EntryService entryService(@Autowired EntryServiceImpl bean) {
		return bean;
	}
	
	@Bean
	public DimissionService dimissionService(@Autowired DimissionServiceImpl bean) {
		return bean;
	}
	
	/*@Bean
	public UserDetailsService userDetailsService() {
		return null;
	}*/
}

