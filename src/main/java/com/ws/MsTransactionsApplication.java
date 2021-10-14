package com.ws;

import com.ws.model.Account;
import com.ws.service.IAccountService;
import com.ws.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class MsTransactionsApplication {


	@Autowired
	private IAccountService service;

	public static void main(String[] args) {
		SpringApplication.run(MsTransactionsApplication.class, args);
	}


	@Bean
	void upLoadAccount(){

		service.save(new Account(Long.valueOf(1),Long.valueOf(1), new BigDecimal(2000)));
		service.save(new Account(Long.valueOf(2),Long.valueOf(7), new BigDecimal(70)));
		service.save(new Account(Long.valueOf(1),Long.valueOf(8), new BigDecimal(2100)));
		service.save(new Account(Long.valueOf(1),Long.valueOf(5), new BigDecimal(3600)));
	}

	@Bean
	IAccountService upLoad(){

		return  new AccountServiceImpl();
	}

}
