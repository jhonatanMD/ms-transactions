package com.ws.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionAccount {

    private Long id;
    private String operation;
    private BigDecimal amount;
}
