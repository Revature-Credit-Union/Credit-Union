package com.revature.RCUbackend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.RCUbackend.models.Response;
import com.revature.RCUbackend.models.Transaction;
import com.revature.RCUbackend.models.User;
import com.revature.RCUbackend.services.TransactionService;

@RestController("transactionController")
@RequestMapping("/transaction") //this can be changed depending on frontend
@CrossOrigin(origins="*")
public class TransactionController {
	private TransactionService transactionService;
	
	@Autowired
	public TransactionController (TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	//any of these mappings are subject to change depending on HTTP requests from frontend
	/*
    @GetMapping(path = "/allTransactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response allTransactions(@RequestBody User user){
        Response response;
        ArrayList<Transaction> temp = (ArrayList<Transaction>) this.transactionService.findAll();
        		
        if(temp != null){
            response = new Response(true, "Transactions found", temp);
        }else{
            response = new Response(false, "Transactions not found", null);
        }

        return response;
    }*/
	
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE) 
	public Transaction saveTransaction(@RequestBody Transaction transaction) {
		return this.transactionService.saveTransaction(transaction);
	}
	
	@GetMapping(path = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getall(){
		return this.transactionService.findAll();
	}
	
	@GetMapping(path = "/findbyAccount", produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> findbyAccount(@RequestParam int id) {
		return this.transactionService.findByAccountID(id);
	}
	
	@GetMapping(path = "/findDeposits", produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> findDeposits(@RequestParam int id) {
		return this.transactionService.findByTransactionTypeAndAccountID(0, id);
	}
	
	@GetMapping(path = "/findWithdrawls", produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> findWithdrawls(@RequestParam int id) {
		return this.transactionService.findByTransactionTypeAndAccountID(1, id);
	}
	
	@GetMapping(path = "/findTransfers", produces =  MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> findTransfers(@RequestParam int id) {
		return this.transactionService.findByTransactionTypeAndAccountID(2, id);
	}
}
