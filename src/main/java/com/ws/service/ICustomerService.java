package com.ws.service;

import com.ws.model.Customer;

import java.util.List;

public interface ICustomerService {

    Customer save (Customer customer);

    List<Customer> findAll();

    Customer findById(Long id);


}
