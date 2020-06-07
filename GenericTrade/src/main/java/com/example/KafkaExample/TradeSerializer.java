package com.example.KafkaExample;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TradeSerializer implements Serializer<Trade> {
	
	    @Override
	    public byte[] serialize(String arg0, Trade trade) {
	        byte[] serializedBytes = null;
	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            serializedBytes = objectMapper.writeValueAsString(trade).getBytes();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return serializedBytes;
	    }

	    @Override
	    public void close() {
	        // TODO Auto-generated method stub
	    }

	    @Override
	    public void configure(Map<String, ?> arg0, boolean arg1) {
	        // TODO Auto-generated method stub
	    }
	
}