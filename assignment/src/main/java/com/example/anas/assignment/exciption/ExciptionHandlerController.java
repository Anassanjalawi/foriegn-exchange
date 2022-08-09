package com.example.anas.assignment.exciption;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.anas.assignment.entity.Deal;

@ControllerAdvice
public class ExciptionHandlerController extends ResponseEntityExceptionHandler {
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@ExceptionHandler({GeneralExceptionHandler.class})
	public ResponseEntity<Object> handleAllFieldsRequierdExciption(GeneralExceptionHandler e , WebRequest request){
		log.error(e.getMessage());
		Map<String,Object> map =  new HashMap<>();
		
		map.put("error",e.getCode());
		map.put("fields", e.getParamsMap());
		return handleExceptionInternal(e, map,new HttpHeaders(),HttpStatus.BAD_REQUEST, request );
	}
}
