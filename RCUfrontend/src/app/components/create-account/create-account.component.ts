import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/models/Account';
import { AccountService } from 'src/app/services/account.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  constructor(private userService: UserService , private accService: AccountService) { }
  content! : string;
  accounts?: Account[];
  ngOnInit(): void {
    this.userService.getPublicContent().subscribe(
      data => {
        this.content = data;
        console.log(data);
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
     this.accService.getAccountsById().subscribe(
      data=>{
        this.accounts = data;
        console.log(data);
      }
     );

  }

  createAccount()
  {
    
  }
  
}
