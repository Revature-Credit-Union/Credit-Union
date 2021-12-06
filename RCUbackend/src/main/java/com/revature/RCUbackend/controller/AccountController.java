package com.revature.RCUbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.RCUbackend.models.Account;
import com.revature.RCUbackend.service.AccountService;

@RestController("transactionController")
@RequestMapping("/account") //this can be changed depending on frontend
@CrossOrigin(origins="*")
public class AccountController {
	private AccountService accountService;
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@PostMapping(path = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deposit(@RequestParam int amount, @RequestBody Account account) {
		this.accountService.deposit(amount, account);
	}
	
	@PostMapping(path = "/withdraw", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void withdraw(@RequestParam int amount, @RequestBody Account account) {
		this.accountService.withdraw(amount, account);
	}
	
	public void transfer(@RequestParam int amount, @RequestBody Account fromAccount, @RequestBody Account toAccount) {
		this.accountService.withdraw(amount, fromAccount);
		this.accountService.deposit(amount, toAccount);
	}
}
