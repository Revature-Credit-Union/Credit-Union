package com.revature.RCUbackend.models;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@Column(name = "accountID")
	int accountID;
	@Column(name = "transactionType")
	int transactionType; //0 = deposit, 1 = withdrawal, 2 = transfer
	@Column(name = "debitcredit") 
	int debitcredit; //0 - debit, 1 - credit
	@Column(name = "amount")
	int amount;
	@Basic(optional = false)
	@Column(name = "transactionTimestamp", nullable = false, updatable = false, 
			insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	Date transactionTimestamp;
}
