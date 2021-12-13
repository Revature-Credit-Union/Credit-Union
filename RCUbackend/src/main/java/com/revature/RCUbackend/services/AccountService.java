package com.revature.RCUbackend.services;

import com.revature.RCUbackend.models.Account;
import com.revature.RCUbackend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

	public List<Account> getById(int id) {
		return this.accountRepository.getById(id);
	}

	public void deposit(int amount, Account account) {
		this.accountRepository.depositAccount(amount, account.getAccountId());
	}
	
	public void withdraw(int amount, Account account) {
		this.accountRepository.withdrawAccount(amount, account.getAccountId());
	}
}
