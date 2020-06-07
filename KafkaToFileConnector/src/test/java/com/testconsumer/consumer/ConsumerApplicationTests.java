package com.testconsumer.consumer;

import org.apache.commons.io.FileUtils;
import org.assertj.core.api.FileAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ConsumerApplicationTests {
    String s="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<Trades>\n" +
            "\t<Trade>\n" +
            "\t\t\t\t\t<TradeId>HNC234712121212</TradeId>\n" +
            "\t\t\t\t\t<Firm>SLI</Firm>\n" +
            "\t\t\t\t\t<CashSecurity>\n" +
            "\t\t\t\t\t\t\t<SecurityType>EQ</SecurityType>\n" +
            "\t\t\t\t\t\t\t<SecurityIdentifier>XX4567</SecurityIdentifier>\n" +
            "\t\t\t\t\t</CashSecurity>\n" +
            "\t\t\t\t\t<TradeDate>2020-05-13</TradeDate>\n" +
            "\t</Trade>\n" +
            "</Trades>";
    File f=new File("src/main/resources/Trade1.xml");
    @Test
    public void testCase() throws IOException {
        Converter converter=new Converter();
        converter.convert(s,1);
        File f1=new File("Output Trades/Trade1.xml");
        f1.deleteOnExit();
        assertTrue(FileUtils.contentEquals(f,f1));
    }
}
