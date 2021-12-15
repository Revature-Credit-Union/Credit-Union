import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/userModel';
import { AccountService } from 'src/app/services/account.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { Account } from 'src/app/models/Account';
import { FormControl, FormGroup } from '@angular/forms';

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

accountForm = new FormGroup({   balance: new FormControl(''),   userId: new FormControl(''), accountType: new FormControl(''),});

  ngOnInit(): void {
  }

  createAccount():void{
    //this.account.balance=Number.parseInt(this.accountForm.get("type").value);
    this.account.ownerId=this.user.user_id;
    this.account.type=Number.parseInt(this.type);

    // let pform:string = {
    //   "balance":"${}",
    //   "userId":"${}",
    //   "accountType":"${type}",
    
      
    //   };
    
  }
}
