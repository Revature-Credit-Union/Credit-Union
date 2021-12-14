import { Component, OnInit } from '@angular/core';
import { DepositWithdrawService } from 'src/app/services/deposit-withdraw.service';
import { Account } from 'src/app/models/Account';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-deposit-withdraw',
  templateUrl: './deposit-withdraw.component.html',
  styleUrls: ['./deposit-withdraw.component.css']
})
export class DepositWithdrawComponent implements OnInit {

  constructor(private depositWithdrawService : DepositWithdrawService, private tokenStorage : TokenStorageService) { 

  }

  ngOnInit(): void {
    console.log(this.tokenStorage.getUser().user_id)
    this.getUserAccounts();
  }

  amount = 0;
  selectedAccount = new Account(0, 0, 0);
  transaction = 0;
  accounts : Account[] = [];
  
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
    //add router navigation code here
  }

  withdraw(){
    this.depositWithdrawService.withdraw(this.amount, this.selectedAccount).subscribe();
    //add router navigation code here
  }

  getUserAccounts(){
    return this.depositWithdrawService.getUserAccounts().subscribe((data) => 
    {
      console.log(data);
      this.accounts = data
    });
  }
}
