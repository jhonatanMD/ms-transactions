package com.ws.service.impl;

import com.ws.model.Account;
import com.ws.model.dto.TransactionAccount;
import com.ws.model.table.AccountEntity;
import com.ws.repository.IAccountRepository;
import com.ws.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;


public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository repository;

    @Override
    public Account save(Account account) {


        /* Se crea instancia de objeto para mandar a la BASE DE DATOS*/
        AccountEntity accountEntity = new AccountEntity();

        /*Se setean los objetos a registrar*/
        accountEntity.setIdCustomer(account.getIdCustomer());
        accountEntity.setAmount(account.getAmount());


        /*Registra y me retorna el objeto registrado*/
        accountEntity = repository.save(accountEntity);


        /*Se crea una objeto de respuesta*/
        Account accountResponse = new Account();

        /*Se seta el objeto de respuesta para obtener la informacion registrada*/
        accountResponse.setId(accountEntity.getId());
        accountResponse.setIdCustomer(accountEntity.getIdCustomer());
        accountResponse.setAmount(accountEntity.getAmount());


    return accountResponse;
    }

    @Override
    public List<Account> findAll() {

        return  repository.findAll().stream().map(a -> {
            Account account = new Account();
            account.setId(a.getId());
            account.setIdCustomer(a.getIdCustomer());
            account.setAmount(a.getAmount());
            return account;
        }).collect(Collectors.toList());

    }

    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public String transaction(TransactionAccount transactionAccount) {
        return null;
    }
}
