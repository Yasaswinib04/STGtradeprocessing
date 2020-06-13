package com.citi.stg.TradeProcessingConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class TradeProcessingConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeProcessingConfigServerApplication.class, args);
    }

}
