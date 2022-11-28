package com.cognizant.transaction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinancialTransaction {

    @Id
    private long transactionId;

    @ManyToOne(targetEntity = Account.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Account account;

    @ManyToOne(targetEntity = Counterparty.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Counterparty counterparty;

    @ManyToOne(targetEntity = PaymentMethod.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private PaymentMethod paymentMethod;

    @ManyToOne(targetEntity = TransactionServiceEntity.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private TransactionServiceEntity transactionServiceEntity;

    @ManyToOne(targetEntity = TransactionStatus.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private TransactionStatus transactionStatus;

    @ManyToOne(targetEntity = TransactionType.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private TransactionType transactionType;

    private LocalDate dateOfTransaction;

    private double amountOfTransaction;

    private String otherDetails;
}

