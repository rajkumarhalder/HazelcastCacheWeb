package com.rajkumarhalder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajkumarhalder.service.HazelCastService;
import com.rajkumarhalder.web.HazelcastConstant;

@RestController
@RequestMapping("hazelcast")
public class HazelController {
	
	@Autowired
	private HazelCastService hazelCastService;
	
	public Object getUserList(HttpServletRequest request,HttpServletResponse response) {
		return hazelCastService.getCachedData(HazelcastConstant.USERLIST_CACHED_DATA_KEY);
		
	}

}
