package com.cognizant.transaction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TransactionType {

    @Id
    private long transactionTypeCode;

    /**
     * e.g. Adjustment, Payment, Refund
     */
    private String transactionTypeDescription;
}
