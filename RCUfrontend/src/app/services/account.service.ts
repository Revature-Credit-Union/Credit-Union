import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


//const API_URL = 'http://ec2-54-89-183-177.compute-1.amazonaws.com:8080/revcare/api/test/';
const API_URL =  'http://localhost:8080/users'
const API_URL_A =  'http://localhost:8080/account'
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  // private springServerUrl= environment.baseUrl;

  constructor(private http: HttpClient) { }
  getAllAccounts(): Observable<any> {
    return this.http.get(API_URL + '/getAll', { responseType: 'text' });
  }
  getAccountsById(id:number):Observable<any>{
    return this.http.get('http://localhost:8080/account/getById/', { responseType: 'json' });
  }
  createAccount(account:string):Observable<any>{
    let headers = {'content-type':"application/json"};
    return this.http.post(API_URL_A + '/createAccount/'+account , { 'headers':headers });
  }

  // public addPatientDiagnosis(patientDiagnos: string): Observable<patientForm> {
  //   let headers = {'content-type':"application/json"}
  //   return this.http.post<patientForm>(${this.apiServerUrl}/diagnosis/add, patientDiagnos,{'headers':headers});
  // }
  
}

