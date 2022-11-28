package com.cognizant.transaction.service.impl;

import com.cognizant.transaction.client.AccountServiceClient;
import com.cognizant.transaction.client.RuleServiceClient;
import com.cognizant.transaction.domain.FinancialTransaction;
import com.cognizant.transaction.domain.TransactionStatus;
import com.cognizant.transaction.dto.AccountDTO;
import com.cognizant.transaction.dto.RuleStatusDTO;
import com.cognizant.transaction.dto.TransactionHistory;
import com.cognizant.transaction.dto.TransactionStatusDTO;
import com.cognizant.transaction.repository.FinancialTransactionRepository;
import com.cognizant.transaction.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final FinancialTransactionRepository transactionRepository;

    private final AccountServiceClient accountServiceClient;
    private final RuleServiceClient ruleServiceClient;

    @Override
    public TransactionHistory getHistory(long customerId){
        List<FinancialTransaction> transactions = this.transactionRepository.findAllByAccountCustomerId(customerId);
        return new TransactionHistory(transactions);
    }

    @Override
    public TransactionStatus deposit(long accountId, double amount) {
        this.accountServiceClient.deposit(accountId, amount);
        return TransactionStatus.COMPLETED;
    }

    @Override
    public TransactionStatus withdraw(long accountId, double amount) {
        RuleStatusDTO ruleStatus = this.ruleServiceClient.evaluateMinBal(
                amount,
                accountId
        );
        if (ruleStatus.getStatus().equalsIgnoreCase("denied")){
            return TransactionStatus.REJECTED;
        }
        this.accountServiceClient.withdraw(accountId, amount);
        return TransactionStatus.COMPLETED;
    }

    @Override
    public TransactionStatus transfer(long sourceAccountId, long targetAccountId, double amount) {
        TransactionStatus withdrawFromSource = this.withdraw(sourceAccountId, amount);
        if(withdrawFromSource.getTransactionStatusDescription().equalsIgnoreCase(TransactionStatus.REJECTED.getTransactionStatusDescription())){
            return withdrawFromSource;
        }

        TransactionStatus depositToTarget = this.deposit(targetAccountId, amount);
        if(depositToTarget.getTransactionStatusDescription().equalsIgnoreCase(TransactionStatus.REJECTED.getTransactionStatusDescription())){
            this.deposit(sourceAccountId, amount);
            return withdrawFromSource;
        }
        return TransactionStatus.COMPLETED;
    }
}
