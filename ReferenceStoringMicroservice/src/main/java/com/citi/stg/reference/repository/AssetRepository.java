package com.citi.stg.reference.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.citi.stg.reference.model.Asset;

//Asset Repository interface to store data to MongoDB
public interface AssetRepository extends MongoRepository<Asset,String> {

}
