import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
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

  // let params = new HttpParams();
  // params.append('amount' : amountInput)

  deposit(amountInput : number, accountInput : Account) : Observable<Object>{
    return this.httpClient.post(environment.deposit, amountInput, accountInput) as Observable<Object>
  }

  withdraw(amountInput : number, accountInput : Account) : Observable<Object>{
    return this.httpClient.post(environment.withdraw, amountInput, accountInput) as Observable<Object>
  }

}
