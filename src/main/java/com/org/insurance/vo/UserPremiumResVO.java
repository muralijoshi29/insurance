/**
 * 
 */
package com.org.insurance.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author BadGateWay
 *
 */
public class UserPremiumResVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7789270307632802106L;
	private String name;
	private BigDecimal premiumAmount;
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
	
	
	
}
