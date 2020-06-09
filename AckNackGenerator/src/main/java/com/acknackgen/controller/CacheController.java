package com.acknackgen.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;

import com.acknackgen.Asset;
import com.acknackgen.AssetRepository;
import com.acknackgen.Firm;
import com.acknackgen.FirmRepository;

@Controller
public class CacheController {
	
	@Autowired
	FirmRepository firmRepository;
	
	@Autowired
	AssetRepository assetRepository;
	
	@Cacheable (value = "firm", key = "#firmCode")
	public Firm findFirmByCode(String firmCode) {
		
		Firm firm=firmRepository.findByFirmCode(firmCode);
		return firm;
	}
	
	@Cacheable (value = "asset", key = "#assetTypeCode")
	public Asset findAssetByCode(String assetTypeCode) {
		
		Asset asset=assetRepository.findByAssetTypeCode(assetTypeCode);
		return asset;
	}

}
