package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bo.Random;
import com.app.service.RandomGeneratorService;

@RestController
public class RandomGeneratorController {
	
	@Autowired
	private RandomGeneratorService randomGeneratorService;
	
	@RequestMapping("/random")
	public Random random() {
		String randomString = randomGeneratorService.generate();
		return new Random(randomString);
	}
}
