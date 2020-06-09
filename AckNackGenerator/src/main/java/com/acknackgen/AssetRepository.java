package com.acknackgen;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.acknackgen.Asset;

public interface AssetRepository extends MongoRepository<Asset,String> {
	
	Asset findByAssetTypeCode(String assetTypeCode);

}
