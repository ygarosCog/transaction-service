package com.cognizant.transaction.dto;

import com.cognizant.transaction.domain.FinancialTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

    private List<FinancialTransaction> history;
}
