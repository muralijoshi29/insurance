/**
 * 
 */
package com.org.insurance.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.org.insurance.service.InsuranceService;
import com.org.insurance.vo.UserPremiumResVO;
import com.org.insurance.vo.UserPremiumVO;

/**
 * @author BadGateWay
 *
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

	public static final String INSURANCE_MSG = "Health Insurance Premium for";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.insurance.service.InsuranceService#getInsurancePremiumQutation(com.
	 * org.insurance.vo.UserPremiumVO)
	 */
	@Override
	public UserPremiumResVO getInsurancePremiumQutation(UserPremiumVO userPremiumVO) {
		// TODO Auto-generated method stub
		UserPremiumResVO userPremiumResVO = new UserPremiumResVO();
		userPremiumResVO.setName(userPremiumVO.getName());
		if (null != userPremiumVO) {
			if (userPremiumVO.getAge() < 18) {
				BigDecimal result = new BigDecimal("5000");
				userPremiumResVO.setPremiumAmount(result);
				return userPremiumResVO;
			} else {
				BigDecimal cummulativePremium = BigDecimal.ZERO;
				cummulativePremium = validateAgeAndGetAmount(userPremiumVO);
				cummulativePremium = validateGenderAndGetAmount(userPremiumVO, cummulativePremium);
				cummulativePremium = validateHealthAndGetAmount(userPremiumVO, cummulativePremium);
				cummulativePremium = validateHabitsAndGetAmount(userPremiumVO, cummulativePremium);
				BigDecimal cummulativeResult = cummulativePremium.setScale(0,cummulativePremium.ROUND_HALF_UP); 
				userPremiumResVO.setPremiumAmount(cummulativeResult);
				return userPremiumResVO;
			}
		}
		return null;
	}
	
	private BigDecimal validateAgeAndGetAmount(UserPremiumVO userPremiumVO) {
		BigDecimal cummulativePremium = BigDecimal.valueOf(5000);
		BigDecimal tenPercent = BigDecimal.valueOf(0.10);
		BigDecimal twentyPercent = BigDecimal.valueOf(0.20);
		
		if (userPremiumVO.getAge() >= 18) {
			// increase 10%
			BigDecimal tenPercentage = cummulativePremium.multiply(tenPercent);
			cummulativePremium = tenPercentage.add(cummulativePremium);
		}
		
		int starting = 26;
		while(userPremiumVO.getAge()>=starting) {
			if(userPremiumVO.getAge()>40 && starting >40) {
				//increase 20%
				BigDecimal twentyPercentage = cummulativePremium.multiply(twentyPercent);
				cummulativePremium = twentyPercentage.add(cummulativePremium);
			}else {
				// increase 10%
				BigDecimal tenPercentage = cummulativePremium.multiply(tenPercent);
				cummulativePremium = tenPercentage.add(cummulativePremium);
			}
			starting = starting + 5;
		}
		
		return cummulativePremium;
	}
	private BigDecimal validateGenderAndGetAmount(UserPremiumVO userPremiumVO, BigDecimal cummulativePermium) {
		if(userPremiumVO.getGender().equalsIgnoreCase("M")) {
			BigDecimal twoPercent = BigDecimal.valueOf(0.02);
			BigDecimal twoPercentage = cummulativePermium.multiply(twoPercent);
			cummulativePermium = twoPercentage.add(cummulativePermium);
		}
		return cummulativePermium;
	}
	private BigDecimal validateHealthAndGetAmount(UserPremiumVO userPremiumVO, BigDecimal cummulativePermium) {
		BigDecimal onePercent = BigDecimal.valueOf(0.01);
		BigDecimal onePercentage = cummulativePermium.multiply(onePercent);
		if(userPremiumVO.getHypertension().equalsIgnoreCase("Y")) {
			cummulativePermium = cummulativePermium.add(onePercentage);
		}
		if(userPremiumVO.getBloodPressure().equalsIgnoreCase("Y")) {
			cummulativePermium = cummulativePermium.add(onePercentage);
		}
		if(userPremiumVO.getBloodSugar().equalsIgnoreCase("Y")) {
			cummulativePermium = cummulativePermium.add(onePercentage);
		}
		if(userPremiumVO.getOverWeight().equalsIgnoreCase("Y")) {
			cummulativePermium = cummulativePermium.add(onePercentage);
		}
		return cummulativePermium;
	}
	private BigDecimal validateHabitsAndGetAmount(UserPremiumVO userPremiumVO, BigDecimal cummulativePermium) {
		BigDecimal threePercent = BigDecimal.valueOf(0.03);
		BigDecimal threePercentage = cummulativePermium.multiply(threePercent);
		if(userPremiumVO.getDailyExcercise().equalsIgnoreCase("Y")) {
			cummulativePermium = cummulativePermium.subtract(threePercentage);
		}
		if(userPremiumVO.getAlcohol().equalsIgnoreCase("Y")) {
			cummulativePermium = cummulativePermium.add(threePercentage);
		}
		if(userPremiumVO.getSmoking().equalsIgnoreCase("Y")) {
			cummulativePermium = cummulativePermium.add(threePercentage);
		}
		if(userPremiumVO.getDrugs().equalsIgnoreCase("Y")) {
			cummulativePermium = cummulativePermium.add(threePercentage);
		}
		return cummulativePermium;
	}
}
