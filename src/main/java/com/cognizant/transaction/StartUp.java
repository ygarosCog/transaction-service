package com.cognizant.transaction;

import com.cognizant.transaction.domain.Account;
import com.cognizant.transaction.domain.Counterparty;
import com.cognizant.transaction.domain.FinancialTransaction;
import com.cognizant.transaction.domain.PaymentMethod;
import com.cognizant.transaction.domain.TransactionServiceEntity;
import com.cognizant.transaction.domain.TransactionStatus;
import com.cognizant.transaction.domain.TransactionType;
import com.cognizant.transaction.repository.FinancialTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class StartUp implements CommandLineRunner {

    @Autowired
    private FinancialTransactionRepository repository;

    private long currentId = 1L;

    @Override
    public void run(String... args) throws Exception {
        FinancialTransaction f1 = this.get(1532.23);
        FinancialTransaction f2 = this.get(15332.23);
        FinancialTransaction f3 = this.get(12.23);
        FinancialTransaction f4 = this.get(232.23);
        FinancialTransaction f5 = this.get(51532.23);
        FinancialTransaction f6 = this.get(1382.23);
        this.repository.saveAll(List.of(f1, f2, f3, f4, f5, f6));

    }
    private FinancialTransaction get(double amount){
        FinancialTransaction entity = new FinancialTransaction();
        entity.setTransactionId(this.currentId);
        entity.setAccount(new Account(this.currentId, this.currentId * 1000));
        entity.setCounterparty(new Counterparty(this.currentId, "counter-party-details"));
        entity.setPaymentMethod(new PaymentMethod(this.currentId, "visa"));
        entity.setTransactionServiceEntity(new TransactionServiceEntity(this.currentId, LocalDate.now(), "service-details"));
        entity.setTransactionStatus(TransactionStatus.COMPLETED);
        entity.setTransactionType(new TransactionType(this.currentId, "payment"));
        entity.setDateOfTransaction(LocalDate.now());
        entity.setAmountOfTransaction(amount);
        entity.setOtherDetails("details-about-this-financial-transaction");
        this.currentId++;
        return entity;
    }
}
