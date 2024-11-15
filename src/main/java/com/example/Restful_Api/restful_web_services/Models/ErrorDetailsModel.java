package com.example.Restful_Api.restful_web_services.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetailsModel {
	private LocalDateTime timestamp;
	private String message;
	private String details;

	public ErrorDetailsModel(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
