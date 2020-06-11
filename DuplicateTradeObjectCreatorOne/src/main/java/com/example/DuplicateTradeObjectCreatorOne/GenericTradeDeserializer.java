package com.example.DuplicateTradeObjectCreatorOne;

import java.util.Map;
import com.example.DuplicateTradeObjectCreatorOne.GenericTradeModel.*;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenericTradeDeserializer implements Deserializer<GenericTrade> {
	
    @Override
    public GenericTrade deserialize(String arg0, byte[] devBytes) {
        ObjectMapper mapper = new ObjectMapper();
        GenericTrade genericTrade = null;
        try {
        	genericTrade = mapper.readValue(devBytes, GenericTrade.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return genericTrade;
    }

    @Override
    public void close() {
    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
    }
}
