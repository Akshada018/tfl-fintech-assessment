package com.bankA.dao;

import java.time.OffsetDateTime;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlRootElement(name = "TransactionRequest")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class TransactionXml {

    private String trxId;
    private String bankId;
    private Long customerId;
    private String fromAccount;
    private String toAccount;
    private Double amount;
    private String currency;
    private String timestamp;

}
