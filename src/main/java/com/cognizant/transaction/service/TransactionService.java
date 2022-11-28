package com.cognizant.transaction.service;

import com.cognizant.transaction.domain.TransactionStatus;
import com.cognizant.transaction.dto.TransactionHistory;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    TransactionHistory getHistory(long customerId);

    TransactionStatus deposit(long accountId, double amount);

    TransactionStatus withdraw(long accountId, double amount);

    TransactionStatus transfer(long sourceAccountId, long targetAccountId, double amount);
}
