package com.cloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@Log4j
@ControllerAdvice
public class CommonExceptionAdvice {

	//오류 코드 등 예외 처리
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		log.error("Exception......." + ex.getMessage());
		model.addAttribute("exception", ex);
		
		log.error(model);
		return "error_page";
	}
	
	//404 - 페이지를 찾을 수 없습니다.
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		return "custom404";
	}
}
