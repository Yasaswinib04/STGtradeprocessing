package com.ref.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

//Service that contains method to clear cache
@Service
public class CacheService {
	
	//Method to clear cache
	@CacheEvict (value = { "firm","asset"}, allEntries=true)
	public void clearCache() {
		//Log status to console
		System.out.println("Cache Cleared");
	}

}
