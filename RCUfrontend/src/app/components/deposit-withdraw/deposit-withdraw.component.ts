import { Component, OnInit } from '@angular/core';
import { DepositWithdrawService } from 'src/app/services/deposit-withdraw.service';
import { Account } from 'src/app/models/Account';

@Component({
  selector: 'app-deposit-withdraw',
  templateUrl: './deposit-withdraw.component.html',
  styleUrls: ['./deposit-withdraw.component.css']
})
export class DepositWithdrawComponent implements OnInit {

  constructor(private depositWithdrawService : DepositWithdrawService) { 

  }

  ngOnInit(): void {
  }

  amount = 0;
  account = new Account(0, 0, 0);

  //FIX THESE METHODS AFTER SERVICE METHODS ARE FIXED!

  // deposit(){
  //   this.depositWithdrawService.deposit(this.amount, this.account).subscribe();
  //   //add router navigation code here
  // }

  // withdraw(){
  //   this.depositWithdrawService.withdraw(this.amount, this.account).subscribe();
  //   //add router navigation code here
  // }
}
