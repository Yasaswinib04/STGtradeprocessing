package com.acnackgen.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.acknackgen.AckNackMicroservice;
import com.acknackgen.Asset;
import com.acknackgen.Firm;
import com.acknackgen.controller.CacheController;
import com.acknackgen.model.trade.CashSecurity;
import com.acknackgen.model.trade.SourceError;
import com.acknackgen.model.trade.Trade;
import com.acknackgen.service.ConvertService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AckNackMicroservice.class)
class ConvertServiceTests {
	
	private static final String expected="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" + 
			"<Trade>\n" + 
			"    <ClientName>State Life Insurance</ClientName>\n" + 
			"    <TradeId>HNC2347</TradeId>\n" + 
			"    <SecurityDescription>Equities</SecurityDescription>\n" + 
			"    <Error>\n" + 
			"        <ErrorDateTime>12/11/2011</ErrorDateTime>\n" + 
			"        <Description>Error</Description>\n" + 
			"    </Error>\n" + 
			"    <TradeDate>11/11/2011</TradeDate>\n" + 
			"</Trade>"+"\n";
	
	@Autowired
	private ConvertService convertService;
	
	@MockBean
	private CacheController cacheController;
	
	private Trade trade=new Trade("HNC2347","SLI",new SourceError("12/11/2011","Error"),new CashSecurity("EQ","XXX4567"),"11/11/2011");

	@Test
	public void convertObjectTest() {
		
		when(cacheController.findFirmByCode("SLI")).thenReturn(new Firm("SLI","State Life Insurance"));
		when(cacheController.findAssetByCode("EQ")).thenReturn(new Asset("EQ","Equities"));
		assertEquals(expected,convertService.convertObj(trade));
	}

}
