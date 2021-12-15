import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Account } from '../models/Account';
import { Transaction } from '../models/Transaction';
import { TokenStorageService } from './token-storage.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class DepositWithdrawService {

  constructor(private httpClient: HttpClient, private tokenStorage: TokenStorageService, private router : Router) { 

  }

  deposit(amount : number, account : Account) : Observable<Object>{
    const body = JSON.stringify(account);
    let params = new HttpParams().append("amount", amount).append("accountID", account.accountId);
    const head = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});
    this.router.navigateByUrl("/summary");
    return this.httpClient.post(environment.deposit, body, 
      {params : params,
      headers : head}
      ) as Observable<Object>
  }

  withdraw(amount : number, account : Account) : Observable<Object>{
    const body = JSON.stringify(account);
    let params = new HttpParams().append("amount", amount).append("accountID", account.accountId);
    const head = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});
    this.router.navigateByUrl("/summary");
    return this.httpClient.post(environment.withdraw, body, 
      {params : params,
      headers : head}
      ) as Observable<Object>
  }
  
  getUserAccounts() : Observable<Account[]>{
    return this.httpClient.get(environment.getUserAccounts, 
    {
      params : {
      id : this.tokenStorage.getUser().id
    }
  }) as Observable<Account[]>;
  }

}
