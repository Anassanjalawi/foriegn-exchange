package com.example.anas.assignment.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class RateService {
	
	@Value("${fast.forex.api.key}")
	private String apiKey;
	
	@SuppressWarnings("unchecked")
	public Map<String,Object> getRate(String fromCurrency , String toCurrency){
		String endPoint = "https://api.fastforex.io/fetch-one?from="+fromCurrency+"&to="+toCurrency;
		endPoint +="&api_key="+apiKey;
		RestTemplate restTemplate = new RestTemplate();
		Map<String,Object> response =  restTemplate.getForObject(endPoint, HashMap.class);
		return response;
	}
}
