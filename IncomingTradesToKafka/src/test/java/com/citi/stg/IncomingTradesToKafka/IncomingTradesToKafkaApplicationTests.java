package com.citi.stg.IncomingTradesToKafka;

import com.citi.stg.IncomingTradesToKafka.ConverterService.Converter;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class IncomingTradesToKafkaApplicationTests {
    String a = "<Trade>\n" +
            "\t\t\t\t<TradeId>HNC2347</TradeId>\n" +
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
        assertEquals(a, converter.convertXmlfiletoString(path));
    }

}
