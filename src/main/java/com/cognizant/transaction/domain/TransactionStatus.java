package com.cognizant.transaction.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionStatus {

    @Transient
    public static final TransactionStatus COMPLETED = new TransactionStatus(1L, "completed");


    @Transient
    public static final TransactionStatus REJECTED = new TransactionStatus(0L, "rejected");

    @Id
    private long transactionStatusCode;

    /**
     * e.g. Cancelled, Completed, Dispute, Challenged
     */
    private String transactionStatusDescription;
}
