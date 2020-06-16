package com.citi.stg.acknackgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//Class containing main method 
@EnableCaching
@SpringBootApplication
public class AckNackMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(AckNackMicroservice.class, args);
	}

}
