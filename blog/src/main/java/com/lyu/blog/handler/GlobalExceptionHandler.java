package com.lyu.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //모든 exception발생시 이 클래스로 들어온다
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=Exception.class) //Exception이 발생하면 여기에 전달
	public String handleArgumentException(Exception e) {
		return "<h1>"+ e.getMessage()+"</h1>";
	}
 
}
