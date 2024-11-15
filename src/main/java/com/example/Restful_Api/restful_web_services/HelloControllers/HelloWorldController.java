package com.example.Restful_Api.restful_web_services.HelloControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	@GetMapping(path = "/hell0-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello, this is a long message to demonstrate the functionality of the HelloWorldBean class in our Spring Boot application.");
	}
}