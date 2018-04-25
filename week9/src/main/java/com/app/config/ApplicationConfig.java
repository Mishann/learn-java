package com.app.config;

import com.app.service.RandomGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public RandomGeneratorService randomGeneratorService() {
		return new RandomGeneratorService();
	}
}
