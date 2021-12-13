
package com.revature.RCUbackend.controllers;

import com.revature.RCUbackend.models.Account;
import com.revature.RCUbackend.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("accountController")
@RequestMapping("/account") //this can be changed depending on frontend
@CrossOrigin(origins="*")
public class AccountController {
	private AccountService accountService;
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//any of these mappings are subject to change depending on HTTP requests from frontend
	
	@GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> findAll(){
		List<Account> accounts = this.accountService.findAll();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}
	
	@PostMapping(path = "/deposit", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deposit(@RequestParam int amount, @RequestBody Account account) {
		this.accountService.deposit(amount, account);
	}
	
	@PostMapping(path = "/withdraw", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void withdraw(@RequestParam int amount, @RequestBody Account account) {
		this.accountService.withdraw(amount, account);
	}
	
	@PostMapping(path = "/transfer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void transfer(@RequestParam int amount, @RequestBody Account fromAccount, @RequestBody Account toAccount) {
		this.accountService.withdraw(amount, fromAccount);
		this.accountService.deposit(amount, toAccount);
	}
}

	

	

