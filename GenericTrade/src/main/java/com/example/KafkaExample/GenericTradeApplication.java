package com.example.KafkaExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class GenericTradeApplication {

public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx =SpringApplication.run(GenericTradeApplication.class, args);
		
		//get instance of controller class to call required method
		Controller controller=ctx.getBean(Controller.class);
		
		//method call to invoke operations
		controller.prodToTopic();
	}
}

