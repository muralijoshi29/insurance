/**
 * 
 */
package com.org.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.org.insurance.vo.PolicyHolderVO;
import com.org.insurance.vo.PremiumResVO;
import com.org.insurance.vo.UserPremiumResVO;
import com.org.insurance.vo.UserPremiumVO;

import reactor.core.publisher.Mono;

/**
 * @author BadGateWay
 *
 */
@RestController
public class InsuranceController {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@GetMapping("/test")
	public String test() {
		return "Im from Insurance";
	}

	@Autowired
	private com.org.insurance.InsuranceFacadeService insuranceFacadeService;
	
	@PostMapping("/premium-qutation")
	public UserPremiumResVO getInsurancePremiumQutation(@RequestBody UserPremiumVO userPremiumVO) {
		return insuranceFacadeService.getInsurancePremiumQutation(userPremiumVO);
	}
	
	@PostMapping("/premium-and-payment")
	public PremiumResVO writePremiumAndPayment(@RequestBody PolicyHolderVO policyHolderVO) {
		return webClientBuilder.build().post().uri("http://payment/premium-payment")
				.body(Mono.just(policyHolderVO), PolicyHolderVO.class).retrieve().bodyToMono(PremiumResVO.class)
				.block();
	}
	
}
