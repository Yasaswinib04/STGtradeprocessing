package com.example.ExceptionListMaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExceptionListMakerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(ExceptionListMakerApplication.class, args);
		
        ListBuilder lb = context.getBean(ListBuilder.class);		
		lb.buildList();	
		context.close();
	}

}
