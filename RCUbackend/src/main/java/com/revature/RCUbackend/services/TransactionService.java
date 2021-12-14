package com.revature.RCUbackend.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.RCUbackend.models.Transaction;
import com.revature.RCUbackend.repositories.TransactionRepository;

@Service
@Transactional
public class TransactionService {
	private TransactionRepository transactionRepository;
	
	@Autowired
	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	
	public List<Transaction> findAll() {
		return this.transactionRepository.findAll();
	}
	
	public Transaction findByTransactionID(int id) {
		return this.transactionRepository.findByTransactionID(id);
	}
	
	public List<Transaction> findByAccountID(int id) {
		return this.transactionRepository.findByAccountID(id);
	}
	
	public List<Transaction> findByTransactionTypeAndAccountID(int type, int id) {
		return this.transactionRepository.findByTransactionTypeAndAccountID(type, id);
	}
	
	public Transaction saveTransaction(Transaction transaction) {
		return this.transactionRepository.saveTransaction(transaction);
	}
}