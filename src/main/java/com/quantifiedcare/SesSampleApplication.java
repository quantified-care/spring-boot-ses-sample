package com.quantifiedcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SesProperties.class)
public class SesSampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SesSampleApplication.class, args);
	}
}
