import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { catchError, retry } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { User } from '../models/userModel';
import { EmailValidator } from '@angular/forms';


import { TokenStorageService } from './token-storage.service';



//const API_URL = 'http://ec2-54-89-183-177.compute-1.amazonaws.com:8080/revcare/api/test/';

const API_URL =  'http://localhost:8080/api/users'


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  // private springServerUrl= environment.baseUrl;

  constructor(private http: HttpClient, private tokenStorageService: TokenStorageService) { }
  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }



  changePassword(currentPassword: string, newPassword: string, confirmNewPassword: string, username?: string): Observable<any> {

    console.log(this.tokenStorageService.getToken);
    console.log(this.tokenStorageService.getUser);
    username = this.tokenStorageService.getUser().username;

    return this.http.put(API_URL + '/changePassword',
    {
      currentPassword,
      newPassword,
      confirmNewPassword,
      username
    }, httpOptions);
  }


  changeUsername(username: string): Observable<any> {

    console.log(this.tokenStorageService.getToken);
    console.log(this.tokenStorageService.getUser);
    username = this.tokenStorageService.getUser().username


    return this.http.put(API_URL + 'changeUsername',
    {
      username

    }, httpOptions);
  }


  changeProfileSettings(firstName: string, lastName: string, email: string, username?: string): Observable<any> {

    console.log(this.tokenStorageService.getToken());
    console.log(this.tokenStorageService.getUser());
    username = this.tokenStorageService.getUser().username

    return this.http.put(API_URL + 'changeProfileSettings',
    {
      firstName,
      lastName,
      email,
      username
    },httpOptions);
  

  }



}

