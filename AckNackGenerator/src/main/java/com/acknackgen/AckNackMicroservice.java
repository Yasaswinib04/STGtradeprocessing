package com.acknackgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AckNackMicroservice {
	
	public static void main(String[] args) {
		SpringApplication.run(AckNackMicroservice.class, args);
	}
	
}
