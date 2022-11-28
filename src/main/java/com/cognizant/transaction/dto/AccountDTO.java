package com.cognizant.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private long accountId;
    private long customerId;
    private String accountType;
    private double balance;
}
