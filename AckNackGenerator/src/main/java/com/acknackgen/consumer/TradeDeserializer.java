package com.acknackgen.consumer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.acknackgen.model.trade.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TradeDeserializer implements Deserializer<Trade> {
	
	    @Override
	    public Trade deserialize(String arg0, byte[] devBytes) {
	        ObjectMapper mapper = new ObjectMapper();
	        Trade trade = null;
	        try {
	            trade = mapper.readValue(devBytes, Trade.class);
	        } catch (Exception e) {

	            e.printStackTrace();
	        }
	        return trade;
	    }

	    @Override
	    public void close() {
	    }

	    @Override
	    public void configure(Map<String, ?> arg0, boolean arg1) {
	    }

}
