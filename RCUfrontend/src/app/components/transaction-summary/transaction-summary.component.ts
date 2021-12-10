import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Transaction } from 'src/app/models/Transaction';
import { TransactonSummaryService } from 'src/app/services/transaction-summary.service';

@Component({
  selector: 'app-transaction-summary',
  templateUrl: './transaction-summary.component.html',
  styleUrls: ['./transaction-summary.component.css']
})
export class TransactionSummaryComponent implements OnInit {

  deposits : Transaction[] = [];
  withdrawals : Transaction[] = [];
  transfers : Transaction[] = [];

  constructor( private transactionService : TransactonSummaryService) { }

  ngOnInit(): void {

  }

  //FIX THESE AFTER SERVICE METHODS ARE FIXED 

  // getDeposits(){
  //   return this.transactionService.getDeposits().subscribe((data) => 
  //   {
  //     console.log(data);
  //     this.deposits = data;
  //   }

  //   )
  // }

  // getWithdrawals(){
  //   return this.transactionService.getWithdrawals().subscribe((data) => 
  //   {
  //     console.log(data);
  //     this.deposits = data;
  //   }

  //   )
  // }

  // getTransfers(){
  //   return this.transactionService.getTransfers().subscribe((data) => 
  //   {
  //     console.log(data);
  //     this.deposits = data;
  //   }

  //   )
  // }
}
