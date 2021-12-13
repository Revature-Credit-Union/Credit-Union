import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { DepositWithdrawService } from 'src/app/services/deposit-withdraw.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})


export class TransferComponent implements OnInit {
  form: any = {
    amount: null,
    toAccount: null,
    fromAccount: null


  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  content!: string;
  accounts!: any[];
  constructor(private authService: AuthService, private userService: UserService, private moneyService: DepositWithdrawService) { }


  ngOnInit(): void {
    this.userService.getPublicContent().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

  onSubmit(): void {
    const { amount, toAccount, fromAccount } = this.form;

    this.moneyService.transfer(amount, toAccount, fromAccount).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        
      },
      err => {
        this.errorMessage = err.error.message;
        
      }
    );
  }
}
