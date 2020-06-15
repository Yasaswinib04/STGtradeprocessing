package com.citi.stg.acknackgen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;

import com.citi.stg.acknackgen.model.cache.Asset;
import com.citi.stg.acknackgen.model.cache.Firm;
import com.citi.stg.acknackgen.repository.AssetRepository;
import com.citi.stg.acknackgen.repository.FirmRepository;

//Class that controls the fetched from MongoDB and stored in cache 
@Controller
public class CacheController {

	private static final Logger logger = LoggerFactory.getLogger(CacheController.class);

	@Autowired
	FirmRepository firmRepository;

	@Autowired
	AssetRepository assetRepository;

	// Annotation to store the returned Firm object into cache named firm with the
	// respective firmCode field as key
	@Cacheable(value = "firm", key = "#firmCode")
	public Firm findFirmByCode(String firmCode) {
		
		logger.info("Getting Firm from Cache");
		
		// Call to method that searches for the firm in the Database using firmCode
		Firm firm = firmRepository.findByFirmCode(firmCode);
		return firm;
	}

	// Annotation to store the returned Asset object into cache named asset with the
	// respective assetTypeCode field as key
	@Cacheable(value = "asset", key = "#assetTypeCode")
	public Asset findAssetByCode(String assetTypeCode) {
		
		logger.info("Getting Asset from Cache");
		
		// Call to method that searches for the asset in the Database using
		// assetTypeCode
		Asset asset = assetRepository.findByAssetTypeCode(assetTypeCode);
		return asset;
	}

}
