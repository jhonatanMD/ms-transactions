package com.ws.service.impl;

import com.ws.model.Customer;
import com.ws.model.table.CustomerEntity;
import com.ws.repository.ICustomerRepository;
import com.ws.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository repository;

    @Override
    public Customer save(Customer customer) {


        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setLastName(customer.getLastName());

        //Guardar en la BD
        customerEntity = repository.save(customerEntity);
        customer.setId(customerEntity.getId());

        return customer;
    }

    @Override
    public List<Customer> findAll() {

        return repository.findAll()
                .stream()
                .parallel() //realizar flujos paralelos
                .map(customerEntity -> {//Realiza conversiones
                    Customer customer = new Customer();
                    customer.setId(customerEntity.getId());
                    customer.setName(customerEntity.getName());
                    customer.setLastName(customerEntity.getLastName());
            return customer;
        }).collect(Collectors.toList());//Convertir a lista
    }

    @Override
    public Customer findById(Long id) {

        //Optional -> valida que exista el dato , si no existe poes retorna vacio
        Optional<CustomerEntity> response = repository.findById(id);

        Customer customer = new Customer();
        //Valida si el dato esta presente -> si esta presente setea los campos
        //a Customer
        if(response.isPresent()){
            CustomerEntity customerEntity = response.get();
            customer.setId(customerEntity.getId());
            customer.setName(customerEntity.getName());
            customer.setLastName(customerEntity.getLastName());
        }
        return customer;
    }
}
