package com.allinone.reactspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactSpringApplication {

	private static final Logger logger = LoggerFactory.getLogger(ReactSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReactSpringApplication.class, args);
	}

}
