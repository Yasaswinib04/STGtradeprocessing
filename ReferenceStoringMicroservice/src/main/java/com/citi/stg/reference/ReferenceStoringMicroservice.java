package com.citi.stg.reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//Main method
@SpringBootApplication
@EnableCaching
public class ReferenceStoringMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(ReferenceStoringMicroservice.class, args);
	}

}
