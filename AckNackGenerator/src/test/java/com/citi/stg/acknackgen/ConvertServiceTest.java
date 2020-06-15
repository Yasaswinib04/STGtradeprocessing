package com.citi.stg.acknackgen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.citi.stg.acknackgen.controller.CacheController;
import com.citi.stg.acknackgen.model.cache.Asset;
import com.citi.stg.acknackgen.model.cache.Firm;
import com.citi.stg.acknackgen.model.trade.CashSecurity;
import com.citi.stg.acknackgen.model.trade.SourceError;
import com.citi.stg.acknackgen.model.trade.Trade;
import com.citi.stg.acknackgen.service.ConvertService;

//Unit test for testing the conversion method
@SpringBootTest
class ConvertServiceTest {

	// Expected output after Conversion
	private static final String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
			+ "<Trade>\n" + "    <ClientName>State Life Insurance</ClientName>\n" + "    <TradeId>HNC2347</TradeId>\n"
			+ "    <SecurityDescription>Equities</SecurityDescription>\n" + "    <Error>\n"
			+ "        <ErrorDateTime>12/11/2011</ErrorDateTime>\n" + "        <Description>Error</Description>\n"
			+ "    </Error>\n" + "    <TradeDate>11/11/2011</TradeDate>\n" + "</Trade>" + "\n";

	@Autowired
	private ConvertService convertService;

	@MockBean
	private CacheController cacheController;

	private Trade trade = new Trade("HNC2347", "SLI", new SourceError("12/11/2011", "Error"),
			new CashSecurity("EQ", "XXX4567"), "11/11/2011");

	@Test
	public void convertObjectTest() {

		// Using Mockito to mock the repository
		when(cacheController.findFirmByCode("SLI")).thenReturn(new Firm("SLI", "State Life Insurance"));
		when(cacheController.findAssetByCode("EQ")).thenReturn(new Asset("EQ", "Equities"));

		// Comparing real output with expected output
		assertEquals(expected, convertService.convertObj(trade));
	}

}
