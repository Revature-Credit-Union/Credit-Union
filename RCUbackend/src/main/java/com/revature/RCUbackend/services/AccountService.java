package com.revature.RCUbackend.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.RCUbackend.models.Account;
import com.revature.RCUbackend.repositories.AccountRepository;

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
	
	public List<Account> findByUserId(int id) {
		return this.accountRepository.findByUserId(id);
	}
	
	public void deposit(int amount, int accountID) {
		this.accountRepository.deposit(amount, accountID);
	}
	
	public void withdraw(int amount, int accountID) {
		this.accountRepository.withdraw(amount, accountID);
	}
	
	public void depositAccount(int amount, Account account) {
		this.accountRepository.depositAccount(amount, account.getAccountId());
	}
	
	public void withdrawAccount(int amount, Account account) {
		this.accountRepository.withdrawAccount(amount, account.getAccountId());
	}
	/*
	public boolean create(int id) {
		Account account = new Account();
		account.setAccountId(id);
		return this.accountRepository.p
	}*/
	
}
