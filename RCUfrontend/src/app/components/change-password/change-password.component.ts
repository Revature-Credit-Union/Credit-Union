import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  constructor(private userService: UserService) { }

  form: any = {

    currentPassword: null,
    newPassword: null,
    confirmNewPassword: null
  };

  isSuccessful = false;
  passwordChangeFailed = false;
  errorMessage = '';

  ngOnInit(): void {
  }

  onSubmit(): void {
    const {currentPassword, newPassword, confirmNewPassword} = this.form;
    
    this.userService.changePassword(currentPassword, newPassword, confirmNewPassword).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.passwordChangeFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.passwordChangeFailed = true;
      }
    );
  }

}