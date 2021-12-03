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
	
	public Transaction findbyTransactionID(int id) {
		return this.transactionRepository.findbyTransactionID(id);
	}
	
	public List<Transaction> findbyUserID(int id) {
		return this.transactionRepository.findbyUserID(id);
	}
	
	public List<Transaction> findbyAccountID(int id) {
		return this.transactionRepository.findbyAccountID(id);
	}
	
	public List<Transaction> findbyTranscationType(int type) {
		return this.transactionRepository.findbyTranscationType(type);
	}
	
	public List<Transaction> findbyrTranscationTypeAndUserID(int type, int id) {
		return this.transactionRepository.findbyTranscationTypeAndUserID(type, id);
	}
	
	public List<Transaction> findbyUserTranscationTypeAndAccountID(int type, int id) {
		return this.transactionRepository.findbyTranscationTypeAndUserID(type, id);
	}
}
