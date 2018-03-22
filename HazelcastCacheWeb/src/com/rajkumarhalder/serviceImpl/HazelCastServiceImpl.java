package com.rajkumarhalder.serviceImpl;

import com.hazelcast.core.HazelcastInstance;
import com.rajkumarhalder.service.HazelCastService;

public class HazelCastServiceImpl implements HazelCastService{
	
	private HazelcastInstance hazelcastInstance;
	
	public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
		this.hazelcastInstance = hazelcastInstance;
	}

	@Override
	public void setCachedData(String key, Object value) {
		
		hazelcastInstance.getMap(key).put(key, value);
		
	}

	@Override
	public Object getCachedData(String key) {
		 
		return hazelcastInstance.getMap(key).containsKey(key);
	}

}
