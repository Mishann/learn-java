package com.app.service;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class RandomGeneratorService {
	
	public String generate() {
		return UUID.randomUUID().toString();
	}
}
