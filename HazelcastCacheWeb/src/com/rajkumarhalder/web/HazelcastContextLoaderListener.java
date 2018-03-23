package com.rajkumarhalder.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.rajkumarhalder.service.HazelCastService;

public class HazelcastContextLoaderListener extends ContextLoaderListener{
	
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext rootContext=event.getServletContext();
		System.setProperty("hazelcast-config","classpath:hazelcast.xml");
		
		initWebApplicationContext(rootContext);
		
		List<String> userList=new ArrayList<>();
		
		userList.add("Rajkumar Halder");
		userList.add("Shubha Sarkar");
		userList.add("Shankha Mondal");
		
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(rootContext);
		HazelCastService hazelCastService=(HazelCastService) context.getBean("hazelCastService");
		
		
		hazelCastService.setCachedData(HazelcastConstant.USERLIST_CACHED_DATA_KEY, userList);
		
	}

}
