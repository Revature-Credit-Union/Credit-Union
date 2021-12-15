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
  selectedAccount = new Account(0, 0, 0);
  transaction = 0;
  accounts : Account[] = [];
  accountGroup = new FormGroup({selectedAccount : new FormControl})
  
  changeTransaction(entry : number){
    this.transaction = entry;
  }


  changeAccount(account : Account){
    this.selectedAccount = account;
  }

  enactTransaction() {
    if (this.transaction === 1) {
      this.deposit()
    }

    else if (this.transaction === 2) {
      this.withdraw();
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
}
