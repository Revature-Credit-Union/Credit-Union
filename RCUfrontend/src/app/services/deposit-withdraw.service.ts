import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Account } from '../models/Account';


const url = 'http://localhost:8080/api/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
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


  transfer(amount: number, toAccount: string, fromAccount: string): Observable<any> {
    return this.httpClient.post(url+ 'transfer', {
     amount, toAccount, fromAccount
    }, httpOptions);
  }
}
