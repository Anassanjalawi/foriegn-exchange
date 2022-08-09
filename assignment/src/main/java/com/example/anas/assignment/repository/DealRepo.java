package com.example.anas.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.anas.assignment.entity.Deal;

@Repository("DealRepo")
public interface DealRepo extends JpaRepository<Deal, ID> {
	
	@Query("SELECT COUNT(d) FROM Deal d where d.dealIdentifier = :dealId ")
	public Long chackIsDealIdExists(@Param("dealId") String dealId);

}
