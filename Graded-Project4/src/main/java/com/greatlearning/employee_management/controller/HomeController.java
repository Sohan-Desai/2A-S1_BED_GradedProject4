package com.greatlearning.employee_management.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	//@RequestMapping(value="/", method=POST)
	@RequestMapping("/")
	public String homePage() {
		return "<h1>Employee Management Rest API</h1>";
	}
}
