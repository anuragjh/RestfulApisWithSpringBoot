package com.example.Restful_Api.restful_web_services.HelloControllers;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

	private MessageSource messageSource;

	HelloWorldController(MessageSource messageSource){
		this.messageSource = messageSource;
	}

	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	@GetMapping(path = "/hell0-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello, this is a long message to demonstrate the functionality of the HelloWorldBean class in our Spring Boot application.");
	}

	@GetMapping(path = "hello-world-internationalized")
	public String helloWorldInternationalized() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null,locale);
	}
}