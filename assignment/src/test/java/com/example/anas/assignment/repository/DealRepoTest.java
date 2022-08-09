package com.example.anas.assignment.repository;


import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.anas.assignment.entity.Deal;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * 
 * @author anas alsanjalawi
 * @since 09/August/2022
 *
 */
@SpringBootTest
public class DealRepoTest {
	
	@Autowired
	private DealRepo dealRepo;
	
	@Test
	void isDealExistsByDealId() {
		Deal deal =  new Deal("11111111","JOD","USD",new Timestamp(System.currentTimeMillis()), new BigDecimal(100));
		dealRepo.saveAndFlush(deal);
		Boolean actualResult = dealRepo.chackIsDealIdExists(deal.getDealIdentifier())>0L?Boolean.TRUE:Boolean.FALSE;
       // assertThat(actualResult).isTrue();
		assertEquals(Boolean.TRUE, actualResult);
	}
	
	@Test
	void isDealNotExistsByDealId() {
		Deal deal =  new Deal("11111111","JOD","USD",new Timestamp(System.currentTimeMillis()), new BigDecimal(100));
		Boolean actualResult = dealRepo.chackIsDealIdExists(deal.getDealIdentifier())>0L?Boolean.TRUE:Boolean.FALSE;
       // assertThat(actualResult).isTrue();
		assertEquals(Boolean.FALSE, actualResult);
	}

}
