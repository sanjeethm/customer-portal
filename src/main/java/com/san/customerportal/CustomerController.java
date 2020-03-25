package com.san.customerportal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public class CustomerController {
	@GetMapping
	public String get() {
		return "We good";
	}
}

