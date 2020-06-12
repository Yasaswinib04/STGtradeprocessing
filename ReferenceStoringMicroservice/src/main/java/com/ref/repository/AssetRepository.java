package com.ref.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ref.model.Asset;

//Asset Repository interface to store data to MongoDB
public interface AssetRepository extends MongoRepository<Asset,String> {

}
