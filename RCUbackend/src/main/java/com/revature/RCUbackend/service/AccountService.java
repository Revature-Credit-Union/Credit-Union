package com.revature.RCUbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.RCUbackend.models.Account;
import com.revature.RCUbackend.repository.AccountRepository;

@Service
public class AccountService {
	private AccountRepository accountRepository;
	
	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public void deposit(int amount, Account account) {
		this.accountRepository.depositAccount(amount, account.getAccountID());
	}
	
	public void withdraw(int amount, Account account) {
		this.accountRepository.withdrawAccount(amount, account.getAccountID());
	}
}
