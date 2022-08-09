package com.example.anas.assignment.entity;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.anas.assignment.exciption.GeneralExceptionHandler;
import com.example.anas.assignment.service.DealService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Validator {
	
	
	public static void validateAllFieldsRequired(Deal deal) {
		
		Map<String,Object> paramMap =  new HashMap<String, Object>();
		Map<String,Object> objMap = convertObjectToMap(deal);
		
		for(Map.Entry<String,Object> entry : objMap.entrySet()) {
			if(entry.getValue() == null && !entry.getKey().equals("rid")) {
				paramMap.put(entry.getKey(),"required!");
			}
		}
		if(!paramMap.isEmpty()) {
			throw new GeneralExceptionHandler("field requrid","field requrid", paramMap);
		}
	}
	
	public static void handleTypeFormat(Deal deal) throws NoSuchFieldException, SecurityException {
		Map<String,Object> map = new HashMap<String, Object>();
	      Class<?> bigDecimalType = BigDecimal.class;
	      Class<?> stringType = String.class;

			if(!deal.getAmount().getClass().isAssignableFrom(bigDecimalType)) {
				map.put(deal.getClass().getField("amount").toString(), "type must be numaric");
			}
			
			if(!deal.getDealIdentifier().getClass().isAssignableFrom(stringType)) {
				map.put(deal.getClass().getField("dealIdentifier").toString(), "type must be text");
			}
			
			if(!deal.getFromCurrencyCode().getClass().isAssignableFrom(stringType) ) {
				map.put(deal.getClass().getField("fromCurrencyCode").toString(), "type must be text");
			}
			
			if(!deal.getToCurrencyCode().getClass().isAssignableFrom(stringType) ) {
				map.put(deal.getClass().getField("toCurrencyCode").toString(), "type must be text");
			}
			
			if(!map.isEmpty()) {
				throw  new GeneralExceptionHandler("invalid data Type", "invalid data Type !", map);

			}
		
	}
	
	public static void validateValidCurrency(Deal deal) {
	try {
		Currency.getInstance(deal.getFromCurrencyCode());
		Currency.getInstance(deal.getFromCurrencyCode());

	}catch (Exception e) {
		throw  new GeneralExceptionHandler("invalid Currency", "invalid Currency Code !");
	}

	}
	
	public static void validateIsDealIdExists(Boolean isExists) {
		if(isExists) {
			throw  new GeneralExceptionHandler("Deal already exists", "Deal already exists");

		}
	}

	@SuppressWarnings("unchecked")
	private static  Map<String,Object> convertObjectToMap(Deal deal){
		ObjectMapper mapper =  new ObjectMapper();
		Map<String,Object> objMap = mapper.convertValue(deal, Map.class);
		return objMap;
	}
	
	

}
