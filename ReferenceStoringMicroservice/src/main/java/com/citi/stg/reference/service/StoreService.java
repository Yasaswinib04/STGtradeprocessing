package com.citi.stg.reference.service;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.citi.stg.reference.model.Assets;
import com.citi.stg.reference.model.Firms;
import com.citi.stg.reference.repository.AssetRepository;
import com.citi.stg.reference.repository.FirmRepository;

//Class that overrides run method which runs after application start and stores the references into database
@Profile("!test")
@Component
public class StoreService implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(StoreService.class);

	@Autowired
	private FirmRepository firmRepository;

	@Autowired
	private AssetRepository assetRepository;

	@Autowired
	private CacheService cacheService;

	// Runs after application starts
	@Override
	public void run(ApplicationArguments args) throws Exception {

		// create object of file containing list of firms
		logger.info("Getting list of firms from xml file");
		File firm_file = new File("src/main/resources/store/firms.xml");

		// call method to unmarshal the file to get list of firm
		Firms firms = (Firms) UnmarshallingService.makeObject(firm_file, Firms.class);

		// Call to saveAll method of repository to add firms to database
		logger.info("Writing list of firms to database");
		firmRepository.saveAll(firms.getFirms());

		// create object of file containing list of assets
		logger.info("Getiing list of assets from xml file");
		File asset_file = new File("src/main/resources/store/assets.xml");

		// call method to unmarshal the file to get list of asset
		Assets assets = (Assets) UnmarshallingService.makeObject(asset_file, Assets.class);

		// Call to saveAll method of repository to add assets to database
		logger.info("Writing list of assets to database");
		assetRepository.saveAll(assets.getAssets());

		// Method call to clear cache
		logger.info("Method call to clear cache");
		cacheService.clearCache();
	}

}
