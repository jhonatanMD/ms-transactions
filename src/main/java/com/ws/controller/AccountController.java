package com.ws.controller;

import com.ws.model.Account;
import com.ws.model.dto.TransactionAccount;
import com.ws.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    /*Instancer las clases que estan en el bean*/

    private final IAccountService service;

    @PostMapping("/save")
    public Account saveAccount(@RequestBody Account account){
        return  service.save(account);
    }


    @PostMapping("/transaction")
    public String transaction(@RequestBody TransactionAccount transactionAccount){
        return service.transaction(transactionAccount);
    }

    @GetMapping("/findById")
    public Account findByIdAccount(@RequestParam Long id){
        return service.findById(id);
    }

    @GetMapping("/findAll")
    public List<Account> findAll(){
        return service.findAll();
    }
}
