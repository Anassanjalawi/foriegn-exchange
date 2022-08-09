package com.example.anas.assignment.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anas.assignment.entity.Deal;
import com.example.anas.assignment.entity.Validator;
import com.example.anas.assignment.repository.DealRepo;

@Service
public class DealService  {
	
	@Autowired
	private DealRepo dealRepo;
	
	@Autowired
	private RateService rateService;
	
	public BigDecimal createDeal(Deal deal) {
		deal.setRid(null);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		deal.setDealTimestamp(timestamp);
		Validator.validateAllFieldsRequired(deal);
		isDealExists(deal.getDealIdentifier());
		Validator.validateValidCurrency(deal);
		try {
			Validator.handleTypeFormat(deal);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		Deal savedObj =  dealRepo.saveAndFlush(deal);
		
		Map<String,Object> rate = rateService.getRate(savedObj.getFromCurrencyCode(), savedObj.getToCurrencyCode());
		return convert(deal, rate);
		
	}
	
	public void isDealExists(String dealId) {
		Long count = dealRepo.chackIsDealIdExists(dealId);
		Boolean isExists =  count>0 ? Boolean.TRUE : Boolean.FALSE;
		Validator.validateIsDealIdExists(isExists);
	}
	
	@SuppressWarnings("unchecked")
	public BigDecimal convert(Deal deal , Map<String,Object> rateMap) {
		Map<String,Object> rateResMap = (Map<String, Object>)rateMap.get("result");
		Double rate = Double.valueOf(rateResMap.get(deal.getToCurrencyCode()).toString());
		
		BigDecimal convertedValue = deal.getAmount().multiply(BigDecimal.valueOf(rate));
		return convertedValue.setScale(5,RoundingMode.HALF_UP);
	}
}
