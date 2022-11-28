package com.cognizant.transaction.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "services")
public class TransactionServiceEntity {

    @Id
    private long serviceId;

    private LocalDate dateServiceProvided;

    private String otherDetails;
}
