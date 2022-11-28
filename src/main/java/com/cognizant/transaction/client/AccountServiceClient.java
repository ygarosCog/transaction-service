package com.cognizant.transaction.client;

import com.cognizant.transaction.dto.AccountDTO;
import com.cognizant.transaction.dto.TransactionStatusDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("account-service")
public interface AccountServiceClient {

    @GetMapping("account-service/getAccount")
    AccountDTO getAccount(@RequestParam("accountId")long accountId);

    @PostMapping("account-service/deposit")
    TransactionStatusDTO deposit(@RequestParam("accountId")long accountId,
                                 @RequestParam("amount")double amount);

    @PostMapping("account-service/withdraw")
    TransactionStatusDTO withdraw(@RequestParam("accountId")long accountId,
                                  @RequestParam("amount")double amount);
}
