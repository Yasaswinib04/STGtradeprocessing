package com.acknackgen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.acknackgen.model.cache.Asset;

//Repository Interface responsible for Communication with MongoDB 
public interface AssetRepository extends MongoRepository<Asset,String> {
	
	//Method to search Database for asset using assetTypeCode
	Asset findByAssetTypeCode(String assetTypeCode);

}
