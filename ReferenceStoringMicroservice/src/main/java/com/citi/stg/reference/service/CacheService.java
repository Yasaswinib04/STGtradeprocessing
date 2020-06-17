package com.citi.stg.reference.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

//Service that contains method to clear cache
@Service
public class CacheService {

	private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

	// Method to clear cache
	@CacheEvict(value = { "firm", "asset" }, allEntries = true)
	public void clearCache() {
		// Log status to console
		logger.info("Cache Cleared");
	}

}
