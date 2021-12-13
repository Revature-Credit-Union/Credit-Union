import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Transaction } from '../models/Transaction';
import { environment } from 'src/environments/environment';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class TransactonSummaryService {

  constructor(private httpClient: HttpClient, private tokenStorage: TokenStorageService) { 

  }

  getDeposits() : Observable<Transaction[]> {
    return this.httpClient.get(environment.getDeposits, 
      { 
      params : {
        id : this.tokenStorage.getUser().user_id
      } 
    }) as Observable<Transaction[]>;
  }

  getWithdrawls() : Observable<Transaction[]> {
    return this.httpClient.get(environment.getWithdrawls, 
      {
        params : {
        id : this.tokenStorage.getUser().user_id
      }
    }) as Observable<Transaction[]>;
  }

  getTransfers() : Observable<Transaction[]> {
    return this.httpClient.get(environment.getTransfers,
      {
        params : {
        id : this.tokenStorage.getUser().user_id
      }
    }) as Observable<Transaction[]>;
  }
}

