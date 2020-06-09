package com.ref.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
		
	@CacheEvict (value = { "firm","asset"}, allEntries=true)
	public void clearCache() {
		//intentionally blank
		System.out.println("Cache Cleared");
	}

}
