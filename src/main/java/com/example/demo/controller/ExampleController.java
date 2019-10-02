package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ExampleService;

import reactor.core.publisher.Mono;

@RestController
public class ExampleController {

	@Autowired
	private ExampleService exampleService;

	@GetMapping("/name")
	public Mono<String> getName() {
		return exampleService.getName();
	}

}
