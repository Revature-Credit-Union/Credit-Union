import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Account } from '../models/Account';

import { Transaction } from '../models/Transaction';
import { TokenStorageService } from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class DepositWithdrawService {

  constructor(private httpClient: HttpClient, private tokenStorage: TokenStorageService) { 

  }

  deposit(amountInput : number, accountInput : Account) : Observable<Object>{
    const body = JSON.stringify(accountInput);
    let params = new HttpParams();
    params.append("amount", amountInput);
    return this.httpClient.post(environment.deposit, body, {params : params}) as Observable<Object>
  }

  withdraw(amountInput : number, accountInput : Account) : Observable<Object>{
    const body = JSON.stringify(accountInput);
    let params = new HttpParams();
    params.append("amount", amountInput);
    return this.httpClient.post(environment.withdraw, body, {params : params}) as Observable<Object>
  }
  
  getUserAccounts() : Observable<Account[]>{
    return this.httpClient.get(environment.getUserAccounts, 
    {
      params : {
      id : this.tokenStorage.getUser().user_id
    }
  }) as Observable<Account[]>;
  }

}
