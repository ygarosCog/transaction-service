package com.cognizant.transaction.controller;

import com.cognizant.transaction.domain.TransactionStatus;
import com.cognizant.transaction.dto.TransactionHistory;
import com.cognizant.transaction.service.impl.TransactionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("transaction-service")
public class TransactionController {

    private final TransactionServiceImpl transactionService;


    @GetMapping("/getTransactions")
    public TransactionHistory getTransactions(@RequestParam("customerId")long customerId){
        return this.transactionService.getHistory(customerId);
    }

    @PostMapping("/deposit")
    public TransactionStatus deposit(@RequestParam("accountId")long accountId,
                                      @RequestParam("amount")double amount){
        return this.transactionService.deposit(accountId, amount);
    }

    @PostMapping("/withdraw")
    public TransactionStatus withdraw(@RequestParam("accountId")long accountId,
                                     @RequestParam("amount")double amount){
        return this.transactionService.withdraw(accountId, amount);
    }

    @PostMapping("/transfer")
    public TransactionStatus withdraw(@RequestParam("sourceAccountId")long sourceAccountId,
                                      @RequestParam("targetAccountId")long targetAccountId,
                                      @RequestParam("amount")double amount){
        return this.transactionService.transfer(sourceAccountId, targetAccountId, amount);
    }
}
