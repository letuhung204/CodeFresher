package com.codefresher.buoi9.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	@GetMapping
	public String testHello() {
		return "Hello Code fresher";
	}
	
	@GetMapping("/hung")
	public String testText() {
		return "xin chao";
	}

}
