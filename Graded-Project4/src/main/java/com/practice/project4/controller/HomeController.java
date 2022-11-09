package com.practice.project4.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String homePage() {
		return "<h1>Employee Management Rest API</h1>";
	}
}
