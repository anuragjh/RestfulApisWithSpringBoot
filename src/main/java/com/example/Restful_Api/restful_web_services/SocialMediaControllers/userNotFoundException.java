package com.example.Restful_Api.restful_web_services.SocialMediaControllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class userNotFoundException extends RuntimeException {
	public userNotFoundException(String userNotFound) {
		super(userNotFound);
	}
}
