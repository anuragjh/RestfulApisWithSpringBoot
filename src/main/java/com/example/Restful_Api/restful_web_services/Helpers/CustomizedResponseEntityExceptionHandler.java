package com.example.Restful_Api.restful_web_services.Helpers;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;

import com.example.Restful_Api.restful_web_services.Models.ErrorDetailsModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetailsModel> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ErrorDetailsModel errorDetails = new ErrorDetailsModel(LocalDateTime.now(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetailsModel>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserPrincipalNotFoundException.class)
	public final ResponseEntity<ErrorDetailsModel> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDetailsModel errorDetails = new ErrorDetailsModel(LocalDateTime.now(),
				ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetailsModel>(errorDetails, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		ErrorDetailsModel errorDetails = new ErrorDetailsModel(LocalDateTime.now(),
				"Total Errors:" + ex.getErrorCount() + " First Error:" + ex.getFieldError().getDefaultMessage(), request.getDescription(false));

		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
