import { Component, OnInit } from '@angular/core';
import { DepositWithdrawService } from 'src/app/services/deposit-withdraw.service';
import { Account } from 'src/app/models/Account';
import { FormControl, FormGroup } from '@angular/forms';
import { Transaction } from 'src/app/models/Transaction';
import { Router } from '@angular/router';


@Component({
  selector: 'app-deposit-withdraw',
  templateUrl: './deposit-withdraw.component.html',
  styleUrls: ['./deposit-withdraw.component.css']
})
export class DepositWithdrawComponent implements OnInit {

  constructor(private depositWithdrawService : DepositWithdrawService, private router : Router) { 
    this.getUserAccounts();
  }

  ngOnInit(): void {
  }

  amount = 0;
  selectedAccount = new Account(0, 0, 0, 0);
  transaction = 0;
  accounts : Account[] = [];
  accountGroup = new FormGroup({selectedAccount : new FormControl})
  enactedTransaction : Transaction = {
    accountID : 0,
    transactionType : 0,
    amount : 0,
    date : new Date()}
  
  changeTransaction(entry : number){
    this.transaction = entry;
  }


  changeAccount(account : Account){
    this.selectedAccount = account;
  }

  enactTransaction() {
    if (this.transaction === 1) {
      this.deposit()
      this.enactedTransaction =  {
        accountID : this.selectedAccount.accountId,
        transactionType : 0,
        amount : this.amount,
        date : new Date()
      }

      this.saveTransaction(this.enactedTransaction)
    }

    else if (this.transaction === 2) {
      this.withdraw();
      this.enactedTransaction =  {
        accountID : this.selectedAccount.accountId,
        transactionType : 1,
        amount : this.amount,
        date : new Date()
      }

      this.saveTransaction(this.enactedTransaction)
    }
  }

  deposit(){
    this.depositWithdrawService.deposit(this.amount, this.selectedAccount).subscribe();
    this.router.navigateByUrl("/summary");
  }

  withdraw(){
    if (this.amount > this.selectedAccount.balance) {
      this.depositWithdrawService.withdraw(this.amount, this.selectedAccount).subscribe();
      this.router.navigateByUrl("/summary");
    }

    else {
      //some pop-up here would be cool
    }
  }

  getUserAccounts(){
    return this.depositWithdrawService.getUserAccounts().subscribe((data) => 
    {
      console.log(data);
      this.accounts = data
    });
  }

  saveTransaction(transaction : Transaction){
    this.depositWithdrawService.saveTransaction(transaction).subscribe();
  }
}
