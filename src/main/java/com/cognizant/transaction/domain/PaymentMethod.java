package com.cognizant.transaction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {

    @Id
    private long paymentMethodCode;

    /**
     * e.g. Amex, Bank Transfer, Cash,
     *    Diners Club, MasterCard, Visa
     */
    private String paymentMethodName;

}
