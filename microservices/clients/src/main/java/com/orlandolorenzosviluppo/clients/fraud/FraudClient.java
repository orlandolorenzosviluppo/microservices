package com.orlandolorenzosviluppo.clients.fraud;

import com.orlandolorenzosviluppo.clients.fraud.response.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("FRAUD")
public interface FraudClient {
    @GetMapping("api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}