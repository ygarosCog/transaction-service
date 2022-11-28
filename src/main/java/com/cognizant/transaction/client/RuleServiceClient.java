package com.cognizant.transaction.client;

import com.cognizant.transaction.dto.RuleStatusDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("rule-service")
public interface RuleServiceClient {

    @GetMapping("rule-service/evaluateMinBal")
    RuleStatusDTO evaluateMinBal(@RequestParam("amount")double amount, @RequestParam("accountId")long accountId);

    @GetMapping("rule-service/getServiceCharges")
    float serviceCharges();

}
