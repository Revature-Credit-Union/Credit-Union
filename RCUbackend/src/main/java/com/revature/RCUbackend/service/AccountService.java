package com.revature.RCUbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.RCUbackend.models.Account;
import com.revature.RCUbackend.repository.AccountRepository;

@Service
@Transactional
public class AccountService {
	private AccountRepository accountRepository;
	
	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public List<Account> findAll() {
		return this.accountRepository.findAll();
	}
	
	public void deposit(int amount, Account account) {
		this.accountRepository.depositAccount(amount, account.getAccountId());
	}
	
	public void withdraw(int amount, Account account) {
		this.accountRepository.withdrawAccount(amount, account.getAccountId());
	}
}