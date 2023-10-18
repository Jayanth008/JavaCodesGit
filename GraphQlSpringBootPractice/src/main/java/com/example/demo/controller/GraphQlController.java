package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GraphQlRequestBody;

@RestController
public class GraphQlController {
	
	private graphql.GraphQL gp;
	
	@PostMapping("/")
	public void excute(@RequestBody GraphQlRequestBody body) {

	}
}
