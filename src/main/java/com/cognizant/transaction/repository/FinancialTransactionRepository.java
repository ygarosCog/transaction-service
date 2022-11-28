package com.cognizant.transaction.repository;

import com.cognizant.transaction.domain.FinancialTransaction;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, Integer> {
    @Cacheable(value = "transactions", key = "#customerId")
    List<FinancialTransaction> findAllByAccountCustomerId(long customerId);
}
