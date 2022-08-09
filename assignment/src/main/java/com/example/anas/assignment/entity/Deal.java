package com.example.anas.assignment.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author anas alsanjalawi
 * @since  07/August/2022   
 *
 */
@Entity
@Table(name = "deal")
public class Deal {
	
	@Column(name = "rid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rid;
	
	@Column(name = "deal_identifier")
	private String dealIdentifier;
	
	@Column(name = "from_currency_code")
	private String fromCurrencyCode;
	
	@Column(name = "to_currency_code")
	private String toCurrencyCode;
	
	@Column(name = "timestamp")
	private Date dealTimestamp;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	

	public Deal() {
		super();
	}

	public Deal( String dealIdentifier,  String fromCurrencyCode, String toCurrencyCode,
			 Date dealTimestamp,  BigDecimal amount) {
		super();
		this.dealIdentifier = dealIdentifier;
		this.fromCurrencyCode = fromCurrencyCode;
		this.toCurrencyCode = toCurrencyCode;
		this.dealTimestamp = dealTimestamp;
		this.amount = amount;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getDealIdentifier() {
		return dealIdentifier;
	}

	public void setDealIdentifier(String dealIdentifier) {
		this.dealIdentifier = dealIdentifier;
	}

	public String getFromCurrencyCode() {
		return fromCurrencyCode;
	}

	public void setFromCurrencyCode(String fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}

	public String getToCurrencyCode() {
		return toCurrencyCode;
	}

	public void setToCurrencyCode(String toCurrencyCode) {
		this.toCurrencyCode = toCurrencyCode;
	}

	public Date getDealTimestamp() {
		return dealTimestamp;
	}

	public void setDealTimestamp(Date dealTimestamp) {
		this.dealTimestamp = dealTimestamp;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object obj) {
		if( obj == null) {
			return false;
		}
		
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		
		Deal deal = (Deal) obj;
		if(deal.dealIdentifier.equals(this.dealIdentifier)) {
			return true;
		} else
		{
			return false;
		}
		
	}

	@Override
	public String toString() {
		return "Deal Id: '"+this.dealIdentifier + "', From Currency Code : '" + this.fromCurrencyCode + "', To Currency Code : '" 
	+ this.toCurrencyCode + "', Deal Timestamp : " + this.dealTimestamp + ", Amount : " + this.amount;
	}


	
	
	
	
	

}
