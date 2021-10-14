package com.ws.repository;

import com.ws.model.table.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<CustomerEntity,Long> {

}
