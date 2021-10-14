package com.ws.service.impl;

import com.ws.model.Account;
import com.ws.model.dto.TransactionAccount;
import com.ws.model.table.AccountEntity;
import com.ws.repository.IAccountRepository;
import com.ws.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
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

        Optional<AccountEntity> response = repository.findById(id);

        if(response.isPresent()){

            AccountEntity accountEntity = response.get();

            Account account = new Account();

            account.setIdCustomer(accountEntity.getIdCustomer());
            account.setId(accountEntity.getId());
            account.setAmount(accountEntity.getAmount());

            return account;
        }

        throw  new NullPointerException("No se entro cuenta!");

    }

    @Override
    public String transaction(TransactionAccount transactionAccount) {

        Optional<AccountEntity> response =  repository.findById(transactionAccount.getIdAccount());

        String msj = "";
        if(response.isPresent()){

            AccountEntity accountEntity = response.get();

            if(transactionAccount.getOperation().equals("RETIRO"))
                accountEntity.setAmount(accountEntity.getAmount().subtract(transactionAccount.getAmount()));

            if(transactionAccount.getOperation().equals("DEPOSITO"))
                accountEntity.setAmount(accountEntity.getAmount().add(transactionAccount.getAmount()));

            repository.save(accountEntity);

            msj = "OPERACION EXITOSA";

            return msj;

        }

        msj = "OCURRIO ALGO EN EL PROCESO";

        return msj;
    }
}
