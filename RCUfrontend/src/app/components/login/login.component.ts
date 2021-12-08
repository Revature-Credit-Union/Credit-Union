import { Component, OnInit } from '@angular/core';

import { UserService } from 'src/app/services/user.service';
import { LoginMessage } from 'src/app/models/login-message';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';

import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

import { HttpHeaders } from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  login: LoginMessage = new LoginMessage('','');
  status: string = '';

  constructor(private router: Router, private userService: UserService) { }
  ngOnInit(): void {}

  public logIn(): void
  {
    if(this.login.password.length > 0 && this.login.username.length > 0) {
      this.userService.logIn(this.login)
      .subscribe(
        data => {
          const user: User = data.body;
          if('email' in data.body && user.username == this.login.username)
            this.router.navigate(['/home']);
        },
        error => {
          console.log(`Error occured trying to login: ${error}`);
          this.showLoginStatus(error);
        }
      );
    }
  }

  private showLoginStatus(error: string): void
  {
    this.status = 'Failed to login';
        
    if(error.startsWith('no user exists')) {
      this.status = 'Incorrect username or password';
    }
    if(error.startsWith('incorrect password')) {
      this.status = 'Incorrect username or password';
    }
    if(error.startsWith('logout before')) {
      this.status = 'You are already logged in';
    }
  }

}

  username = "";
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  jwtToken = this.tokenStorage.getUser();

  headers = new HttpHeaders().set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*')
  .set('authorization', this.jwtToken);

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;//does not work
    }
  }

  onSubmit(): void {
    const { username, password } = this.form;

    this.authService.login(username, password).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.username = this.tokenStorage.getUser().username;
        // this.reloadPage();
        console.log(this.tokenStorage.getUser());
        console.log(this.tokenStorage.getUser().token);
       
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }
}

