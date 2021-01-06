/**
 * 
 */
package com.org.insurance.vo;

import java.math.BigDecimal;

/**
 * @author BadGateWay
 *
 */
public class PremiumResVO {
	
	private String name;
	private BigDecimal premiumAmount;
	private String status;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the premiumAmount
	 */
	public BigDecimal getPremiumAmount() {
		return premiumAmount;
	}
	/**
	 * @param premiumAmount the premiumAmount to set
	 */
	public void setPremiumAmount(BigDecimal premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
