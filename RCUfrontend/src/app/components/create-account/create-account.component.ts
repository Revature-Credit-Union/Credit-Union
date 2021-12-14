import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/models/Account';
import { User } from 'src/app/models/userModel';
import { AccountService } from 'src/app/services/account.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {

  constructor(private userService: UserService , private accService: AccountService, private tService: TokenStorageService) { }
  content: User = this.tService.getUser();
  accounts?: Account[];
  ngOnInit(): void {
   console.log(this.content);
    //  this.accService.getAccountsById(this.content.user_id).subscribe(
    //   data=>{
    //     this.accounts = data;
    //     console.log(data);
    //   }
    //  );

  }

  createAccount()
  {
      this.accService.createAccount(this.content.user_id);
  }
  
}
