package com.citi.stg.Microservice1;

import com.citi.stg.Microservice1.converter.Converter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

class Microservice1ApplicationTests {
	String a="<Trade>\n" +
			"\t\t\t\t<TradeId>HNC23471111</TradeId>\n" +
			"\t\t\t\t<Firm>SLI</Firm>\n" +
			"\t\t\t\t<CashSecurity>\n" +
			"\t\t\t\t\t\t<SecurityType>EQ</SecurityType>\n" +
			"\t\t\t\t\t\t<SecurityIdentifier>XX4567</SecurityIdentifier>\n" +
			"\t\t\t\t</CashSecurity>\n" +
			"\t\t\t\t<TradeDate>2020-05-13</TradeDate>\n" +
			"</Trade>";
	String path = "src/main/resources/Trades/Trade1.xml";

	Converter converter = new Converter();
	@Test
	void contextLoads() {
		assertEquals(a,converter.convertXmlfiletoString(path));
	}

}
