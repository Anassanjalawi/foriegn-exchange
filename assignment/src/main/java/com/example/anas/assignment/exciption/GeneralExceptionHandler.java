package com.example.anas.assignment.exciption;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="No such Order")  // 404
public class GeneralExceptionHandler extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private Map<String,Object> paramsMap;
	
	public GeneralExceptionHandler(String stackTraceError) {
		super(stackTraceError);
	}
	public GeneralExceptionHandler(String stackTraceError, String code, Map<String, Object> paramsMap) {
		super(stackTraceError);
		this.code = code;
		this.paramsMap = paramsMap;
	}
	public GeneralExceptionHandler(String stackTraceError, String code) {
		super(stackTraceError);
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}
	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}
	
	
	
	

	
	

}
