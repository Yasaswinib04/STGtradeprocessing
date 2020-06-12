package com.acknackgen.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;

import com.acknackgen.model.cache.Asset;
import com.acknackgen.repository.AssetRepository;
import com.acknackgen.model.cache.Firm;
import com.acknackgen.repository.FirmRepository;

//Class that controls the fetched from MongoDB and stored in cache 
@Controller
public class CacheController {
	
	@Autowired
	FirmRepository firmRepository;
	
	@Autowired
	AssetRepository assetRepository;
	
	//Annotation to store the returned Firm object into cache named firm with the respective firmCode field as key
	@Cacheable (value = "firm", key = "#firmCode")
	public Firm findFirmByCode(String firmCode) {
		
		//Call to method that searches for the firm in the Database using firmCode
		Firm firm=firmRepository.findByFirmCode(firmCode);
		return firm;
	}
	
	//Annotation to store the returned Asset object into cache named asset with the respective assetTypeCode field as key
	@Cacheable (value = "asset", key = "#assetTypeCode")
	public Asset findAssetByCode(String assetTypeCode) {
		
		//Call to method that searches for the asset in the Database using assetTypeCode
		Asset asset=assetRepository.findByAssetTypeCode(assetTypeCode);
		return asset;
	}

}
