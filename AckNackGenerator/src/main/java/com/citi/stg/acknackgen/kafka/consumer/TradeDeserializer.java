package com.citi.stg.acknackgen.kafka.consumer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.stg.acknackgen.model.trade.Trade;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Custom Deserializer to deserialize the data consumed from topic
 * Uses jackson fasterxml library to bind the byte array data consumed and create Trade object
 * readValue() method of ObjectMapper class is used for binding
 */

public class TradeDeserializer implements Deserializer<Trade> {

	private static final Logger logger = LoggerFactory.getLogger(TradeDeserializer.class);

	@Override
	public Trade deserialize(String arg0, byte[] devBytes) {
		ObjectMapper mapper = new ObjectMapper();
		Trade trade = null;
		try {
			// mapping the byte stream to Trade class
			trade = mapper.readValue(devBytes, Trade.class);
		} catch (Exception e) {
			logger.error("Failed to desrialize trade",e);
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
