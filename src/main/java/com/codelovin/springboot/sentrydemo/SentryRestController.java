package com.codelovin.springboot.sentrydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentryRestController {

	@GetMapping("/hello")
	public String home(@RequestParam String msg) {
		if (msg == null || msg.isEmpty()) {
			//Sentry.capture("This is a test");
			throw new NullPointerException("message is null");
		}
		return "Hello World!";
	}
}
