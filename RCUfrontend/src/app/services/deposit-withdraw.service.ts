import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Account } from '../models/Account';

@Injectable({
  providedIn: 'root'
})
export class DepositWithdrawService {

  constructor(private httpClient: HttpClient) { 

  }

  //FIX THESE METHODS BELOW!

  // deposit(amountInput : number, accountInput : Account) : Observable<Object>{
  //   return this.httpClient.post(environment.deposit, 
  //     params : {
  //       amount : amountInput; //amount here
  //     }, 
      
  //     account : {
  //       account : accountInput; //Account object here (alternatively an account ID works fine)
  //     })
  // }

  // withdraw(amountInput : number, accountInput : Account) : Observable<Object>{
  //   return this.httpClient.post(environment.withdraw, 
  //     params : {
  //       amount : amountInput; //amount here
  //     }, 
      
  //     account : {
  //       account : accountInput; //Account object here (alternatively an account ID works fine)
  //     })
  // }

}
