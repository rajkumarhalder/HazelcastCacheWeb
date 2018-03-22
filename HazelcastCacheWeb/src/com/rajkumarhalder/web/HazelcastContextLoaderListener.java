package com.rajkumarhalder.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoaderListener;

import com.rajkumarhalder.service.HazelCastService;

public class HazelcastContextLoaderListener extends ContextLoaderListener{
	
	@Autowired
	private HazelCastService hazelCastService;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext rootContext=event.getServletContext();
		
		initWebApplicationContext(rootContext);
		
		HazelcastWebUtil.setsystemvariableFromPropFile("applicationConfiguration.properties");
		
		List<String> userList=new ArrayList<>();
		
		userList.add("Rajkumar Halder");
		userList.add("Shubha Sarkar");
		userList.add("Shankha Mondal");
		
		
		hazelCastService.setCachedData(HazelcastConstant.USERLIST_CACHED_DATA_KEY, userList);
		
	}

}
