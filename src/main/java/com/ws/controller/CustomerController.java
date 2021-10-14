package com.ws.controller;

import com.ws.model.Customer;
import com.ws.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService service;


    @GetMapping("/findAll")
    public List<Customer> findAllCustomer(){
        return service.findAll();
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer){
        return service.save(customer);
    }

    @GetMapping("/findById")
    public Customer findByIdCustomer(@RequestParam Long id){
        return service.findById(id);
    }


}
