package com.acknackgen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acknackgen.model.trade.Trade;
import com.acknackgen.service.ConvertService;
import com.fasterxml.jackson.databind.ObjectMapper;

//Class to test ConvertService using REST api
@RestController
public class TestController {
	
	@Autowired
	ConvertService convertService;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String test(@RequestBody String testJson) throws Exception {
		
		//Convert JSON to Trade Java Object
		ObjectMapper mapper = new ObjectMapper();
		Trade trade = mapper.readValue(testJson, Trade.class);
		
		//Call to method to convert object to Xml
		String op = convertService.convertObj(trade);
		
		return op;
	}
	
	

}
