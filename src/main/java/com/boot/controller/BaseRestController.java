package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseRestController {
	
	@RequestMapping("/")
	public String helloWorld(){
		return "Hi, welcome to spring boot";
	}
}
