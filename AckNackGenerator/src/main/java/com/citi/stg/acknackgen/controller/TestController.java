package com.citi.stg.acknackgen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citi.stg.acknackgen.model.trade.Trade;
import com.citi.stg.acknackgen.service.ConvertService;
import com.fasterxml.jackson.databind.ObjectMapper;

//Class to test ConvertService using REST api
@RestController
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	ConvertService convertService;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String test(@RequestBody String testJson) throws Exception {
		
		logger.info("Test Method Called");
		
		//Convert JSON to Trade Java Object
		ObjectMapper mapper = new ObjectMapper();
		Trade trade = mapper.readValue(testJson, Trade.class);
		
		//Call to method to convert object to Xml
		String op = convertService.convertObj(trade);
		
		return op;
	}
	
	

}
