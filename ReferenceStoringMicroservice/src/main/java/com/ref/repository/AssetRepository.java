package com.ref.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ref.model.Asset;

public interface AssetRepository extends MongoRepository<Asset,String> {

}
