package com.revature.RCUbackend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.RCUbackend.models.Transaction;
import com.revature.RCUbackend.repository.TransactionRepository;

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
	
	public List<Transaction> findByUserId(int id) {
		return this.transactionRepository.findByUserID(id);
	}
	
	public List<Transaction> findByAccountID(int id) {
		return this.transactionRepository.findByAccountID(id);
	}
	
	public List<Transaction> findByTransactionTypeAndUserID(int type, int id) {
		return this.transactionRepository.findByTransactionTypeAndUserID(type, id);
	}
	
	public List<Transaction> findByUserTransactionTypeAndAccountID(int type, int id) {
		return this.transactionRepository.findByTransactionTypeAndUserID(type, id);
	}
	
	public Transaction saveTransaction(Transaction transaction) {
		return this.transactionRepository.saveTransaction(transaction);
	}
}
