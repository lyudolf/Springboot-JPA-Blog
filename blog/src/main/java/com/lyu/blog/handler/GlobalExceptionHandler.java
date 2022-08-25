package com.lyu.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.lyu.blog.dto.ResponseDto;

@ControllerAdvice //모든 exception발생시 이 클래스로 들어온다
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=Exception.class) //Exception이 발생하면 여기에 전달
	public ResponseDto<String> handleArgumentException(Exception e) {
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
	}
 
}
