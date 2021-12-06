package com.revature.RCUbackend.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
	@Id
	@Column(name = "transactionID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int transactionID;
	@Column(name = "userID")
	int userID;
	@Column(name = "accountID")
	int accountID;
	@Column(name = "transactionType")
	int transactionType; //0 = deposit, 1 = withdrawal, 2 = transfer
	@Column(name = "debitcredit") //0 - debit, 1 - credit
	int debitcredit;
	@Column(name = "amount")
	int amount;
	@Column(name = "transactionTimestamp")
	Date transactionTimestamp;
}
