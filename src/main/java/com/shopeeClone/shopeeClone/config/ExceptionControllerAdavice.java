package com.shopeeClone.shopeeClone.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shopeeClone.shopeeClone.exeption.ValidateException;

class ExceptionResponseBody {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

@ControllerAdvice
public class ExceptionControllerAdavice {

	@ExceptionHandler({ ValidateException.class })
	public ResponseEntity<ExceptionResponseBody> handleExceptionA(Exception e) {
		ExceptionResponseBody body = new ExceptionResponseBody();
		body.setMessage(e.getMessage());
		return ResponseEntity.status(400).body(body);
	}

}
