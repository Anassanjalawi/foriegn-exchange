package com.example.anas.assignment.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.anas.assignment.entity.Deal;
import com.example.anas.assignment.service.DealService;

@RestController
@RequestMapping("/services")
public class DealController {
	
	@Autowired
	private DealService dealService;
	
	@RequestMapping(value = "/createDeal" , method = RequestMethod.POST)
	public ResponseEntity<BigDecimal> createDeal(@RequestBody Deal deal){
		return new ResponseEntity<BigDecimal>(dealService.createDeal(deal), HttpStatus.OK);
	}

}
