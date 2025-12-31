package com.bankA.dao;

import lombok.Data;

@Data
public class TransactionRequestDao {

    private Long customerId;
    private String fromAccount;
    private String toAccount;
    private Double amount;
    private String currency;

}
