package com.ws.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionAccount {

    private Long idAccount;
    private String operation;
    private BigDecimal amount;
}
