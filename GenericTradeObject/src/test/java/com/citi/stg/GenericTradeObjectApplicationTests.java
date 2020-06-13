package com.citi.stg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citi.stg.Controller.ControllerService;
import com.citi.stg.Trade.GenericSecurity;
import com.citi.stg.Trade.GenericTrade;

//Unit test for testing the conversion method
@SpringBootTest
class ControllerTest {

	// Expected output after Conversion
	private static final String trade = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<AlpsUploader xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + "<Header>\n"
			+ "			<Sender>FTP Info</Sender>\n" + "</Header>\n" + "<Trades>\n" + "	<Trade>\n"
			+ "					<TradeId>HAC1354</TradeId>\n" + "					<Firm>JDC</Firm>\n"
			+ "					<CashSecurity>\n" + "							<SecurityType>CP</SecurityType>\n"
			+ "							<SecurityIdentifier>XX4567</SecurityIdentifier>\n"
			+ "					</CashSecurity>\n" + "					<TradeDate>2020-05-13</TradeDate>\n"
			+ "	</Trade>\n" + "</Trades>\n" + "</AlpsUploader>";

	private GenericTrade generictrade = new GenericTrade("HAC1354", "JDC", new GenericSecurity("CP", "XX4567"),
			"2020-05-13");

	@Autowired
	ControllerService controllerservice;

	@Test
	public void convertObjectTest() {

		// Comparing real output with expected output
		assertEquals(generictrade.getClass(), controllerservice.convertObject(trade).getClass());
		assertEquals(generictrade.getTradeId(), controllerservice.convertObject(trade).getTradeId());
		assertEquals(generictrade.getFirm(), controllerservice.convertObject(trade).getFirm());
		assertEquals(generictrade.getGenericSecurity().getClass(),
				controllerservice.convertObject(trade).getGenericSecurity().getClass());
		assertEquals(generictrade.getDate(), controllerservice.convertObject(trade).getDate());

	}

}