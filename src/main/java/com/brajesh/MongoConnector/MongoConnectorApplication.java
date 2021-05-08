package com.brajesh.MongoConnector;

import com.brajesh.MongoConnector.repositories.CustomerRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MongoConnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoConnectorApplication.class, args);
		
	}

}
