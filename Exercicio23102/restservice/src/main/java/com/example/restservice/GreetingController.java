package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "O valor eh: %d";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/sum")
	public Sum sum(@RequestParam(value = "a", defaultValue = "0") String a, @RequestParam(value = "b", defaultValue = "0") String b) {
		long sum = Integer.valueOf(a) + Integer.valueOf(b);
		return new Sum(counter.incrementAndGet(), String.format(template, sum));
	}
}