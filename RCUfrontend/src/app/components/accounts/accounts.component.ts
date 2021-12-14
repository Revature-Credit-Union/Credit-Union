import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/userModel';
import { AccountService } from 'src/app/services/account.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { Account } from 'src/app/models/Account';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.component.css']
})
export class AccountsComponent implements OnInit {

  constructor(private accountService:AccountService,private tokenService:TokenStorageService) { }

  user:User=this.tokenService.getUser();
  type:string='';
  amount:string='';
  account!:Account;

  ngOnInit(): void {
  }

  createAccount():void{
    this.account.balance=Number.parseInt(this.amount);
    this.account.ownerId=this.user.user_id;
    this.account.type=Number.parseInt(this.type);
    
  }
}
