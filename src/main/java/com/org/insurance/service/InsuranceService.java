/**
 * 
 */
package com.org.insurance.service;

import com.org.insurance.vo.UserPremiumResVO;
import com.org.insurance.vo.UserPremiumVO;

/**
 * @author BadGateWay
 *
 */
public interface InsuranceService {
	
	public UserPremiumResVO getInsurancePremiumQutation(UserPremiumVO userPremiumVO);

}
