package com.ws.repository;

import com.ws.model.table.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<AccountEntity,Long> {

}
