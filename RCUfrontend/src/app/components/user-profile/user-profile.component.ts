import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})



export class UserProfileComponent implements OnInit {

  content?:string;

  form: any = {
    email:null,
    firstName: null,
    lastName: null
  }
  
  isSuccessful = false;
  usernameChangeFailed = false;
  errorMessage = '';


  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    document.getElementById("edit-Info")!.style.display = "none";
  }

  
  edit(){
    document.getElementById("edit-Info")!.style.display = "block";
    document.getElementById("myInfo")!.style.filter = "blur(4px)"; //blur will blur the background content to make it look nicer
  }

  transfer(){
this.router.navigateByUrl('/transfer');
  }

 
  close(){
    document.getElementById("edit-Info")!.style.display = "none";
    document.getElementById("myInfo")!.style.filter = "blur(0px)"; //blur will blur the background content to make it look nicer

  }

  updateInfo(){
    const{firstName, lastName, email} = this.form;
    this.userService.changeProfileSettings(email, firstName, lastName).subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

}
