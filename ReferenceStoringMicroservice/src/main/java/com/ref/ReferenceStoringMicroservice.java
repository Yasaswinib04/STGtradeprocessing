package com.ref;

import java.io.File;


import javax.xml.bind.JAXBContext;

import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.ref.model.Assets;
import com.ref.model.Firms;
import com.ref.repository.AssetRepository;
import com.ref.repository.FirmRepository;
import com.ref.service.CacheService;

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
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		File file=new File("src/main/resources/store/firms.xml");
		
		try {
			JAXBContext jaxbContext=JAXBContext.newInstance(Firms.class);
			Unmarshaller jaxbUnmarshaller=jaxbContext.createUnmarshaller();
			Firms firms=(Firms) jaxbUnmarshaller.unmarshal(file);
			firmRepository.saveAll(firms.getFirms());
			
			System.out.println("method called to clear firm cache");
			cacheService.clearCache();
		} 
		 catch (Exception e) {
			e.printStackTrace();
		} 
		
		File file1=new File("src/main/resources/store/assets.xml");
		
		try {
			JAXBContext jaxbContext=JAXBContext.newInstance(Assets.class);
			Unmarshaller jaxbUnmarshaller=jaxbContext.createUnmarshaller();
			Assets assets=(Assets) jaxbUnmarshaller.unmarshal(file1);
			assetRepository.saveAll(assets.getAssets());
			
			System.out.println("method called to clear asset cache");
			cacheService.clearCache();	
		} 
		 catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}
		
		
	
}
	

