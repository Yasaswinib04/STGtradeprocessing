package com.acknackgen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.acknackgen.model.cache.Asset;

public interface AssetRepository extends MongoRepository<Asset,String> {
	
	Asset findByAssetTypeCode(String assetTypeCode);

}
