/**
 * 
 */
package com.org.insurance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.insurance.service.InsuranceService;
import com.org.insurance.vo.UserPremiumResVO;
import com.org.insurance.vo.UserPremiumVO;

/**
 * @author BadGateWay
 *
 */
@Service
public class InsuranceFacadeService {
	
	@Autowired
	private InsuranceService insuranceService;
	
	public UserPremiumResVO getInsurancePremiumQutation(UserPremiumVO userPremiumVO) {
		return insuranceService.getInsurancePremiumQutation(userPremiumVO);
	}

}
