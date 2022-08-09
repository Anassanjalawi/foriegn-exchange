package com.example.anas.assignment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Map;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.anas.assignment.entity.Deal;
/**
 * 
 * @author anas alsanjalawi
 * @since 09/August/2022
 *
 */
@SpringBootTest
public class DealServiceTest {
	@Autowired
	private DealService dealService;
	
	@Autowired
	private RateService rateService;
	//Deal deal = null;
	
	
	/*@BeforeAll
	public void initialize() {
		deal = new Deal("123","JOD","USD",new Timestamp(System.currentTimeMillis()), new BigDecimal(120));
	}*/
	

	@Test
	public void testConvertor() {
		Deal deal =  new Deal("123","JOD","USD",new Timestamp(System.currentTimeMillis()), new BigDecimal(120));
	
		Map<String,Object> rate = rateService.getRate(deal.getFromCurrencyCode(), deal.getToCurrencyCode());
		assertEquals(169.58040,dealService.convert(deal,rate));
	}
}
