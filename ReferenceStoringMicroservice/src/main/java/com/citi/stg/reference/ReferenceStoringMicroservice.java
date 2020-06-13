package com.citi.stg.reference;

import java.io.File;


import javax.xml.bind.JAXBContext;

import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.citi.stg.reference.model.Assets;
import com.citi.stg.reference.model.Firms;
import com.citi.stg.reference.repository.AssetRepository;
import com.citi.stg.reference.repository.FirmRepository;
import com.citi.stg.reference.service.CacheService;

@SpringBootApplication
@EnableCaching
public class ReferenceStoringMicroservice implements ApplicationRunner {
	
	@Autowired
	private FirmRepository firmRepository;
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private CacheService cacheService;
	
	public static void main(String[] args) {
		SpringApplication.run(ReferenceStoringMicroservice.class, args);
	}
	
	//Code to run after application is executed
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		//load file containing list of firms into database
		File firm_file=new File("src/main/resources/store/firms.xml");
		
		try {
			//Using JAXB to generate firms object containing list of firms
			JAXBContext jaxbContext=JAXBContext.newInstance(Firms.class);
			Unmarshaller jaxbUnmarshaller=jaxbContext.createUnmarshaller();
			Firms firms=(Firms) jaxbUnmarshaller.unmarshal(firm_file);
			
			//Call to saveAll method of repository to add firms to database
			firmRepository.saveAll(firms.getFirms());
			
			//Method call to clear cache
			System.out.println("method called to clear firm cache");
			cacheService.clearCache();
		} 
		 catch (Exception e) {
			e.printStackTrace();
		} 
		
		//load file containing list of assets into database
		File asset_file=new File("src/main/resources/store/assets.xml");
		
		try {
			//Using JAXB to generate assets object containing list of assets
			JAXBContext jaxbContext=JAXBContext.newInstance(Assets.class);
			Unmarshaller jaxbUnmarshaller=jaxbContext.createUnmarshaller();
			Assets assets=(Assets) jaxbUnmarshaller.unmarshal(asset_file);
			
			//Call to saveAll method of repository to add assets to database
			assetRepository.saveAll(assets.getAssets());
			
			//Method call to clear cache
			System.out.println("method called to clear asset cache");
			cacheService.clearCache();	
		} 
		 catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}
		
		
	
}
	

