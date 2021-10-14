package com.ws.service;

import com.ws.model.Account;
import com.ws.model.dto.TransactionAccount;

import java.util.List;

public interface IAccountService {

    Account save (Account account);

    List<Account> findAll();

    Account findById(Long id);

    String transaction(TransactionAccount transactionAccount);
}
