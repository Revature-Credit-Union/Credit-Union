import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Transaction } from '../models/Transaction';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TransactonSummaryService {

  constructor(private httpClient: HttpClient) { 

  }

  //FIX THESE METHODS BELOW!

  // getDeposits() : Observable<Transaction[]> {
  //   return this.httpClient.get(environment.getDeposits, 
  //     params : {
  //       id : //User ID here (alternatively a User object can suffice)
  //     }) as Observable<Transaction[]>;
  // }

  // getWithdrawls() : Observable<Transaction[]> {
  //   return this.httpClient.get(environment.getWithdrawls, 
  //     params : {
  //       id : //User ID here (alternatively a User object can suffice)
  //     }) as Observable<Transaction[]>;
  // }

  // getTransfers() : Observable<Transaction[]> {
  //   return this.httpClient.get(environment.getWithdrawls, 
  //     params : {
  //       id : //User ID here
  //     }) as Observable<Transaction[]>;
  // }
}
