
import { Component, OnInit } from '@angular/core';
import { User } from '../models/userModel';
import { Router } from '@angular/router';
import { HttpHeaders } from '@angular/common/http';
import { UserService } from '../services/user.service';




@Component({
  selector: 'app-security-profile',
  templateUrl: './security-profile.component.html',
  styleUrls: ['./security-profile.component.css']
})
export class SecurityProfileComponent implements OnInit {


  form: any = {

    username: null
  };

  isSuccessful = false;
  usernameChangeFailed = false;
  errorMessage = '';

  constructor(private userService:UserService) { }


  ngOnInit(): void {

    
    


    document.getElementById("editInfo")!.style.display = "none";
 //f45939eebffd34500feec9cf7abd74c83e5b85c4
  }



  onSubmit(): void {
    const {username} = this.form;
    
    this.userService.changeUsername(username).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.usernameChangeFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.usernameChangeFailed = true;
      }
    );
  }
  

  updateUserInfo(_userID: any, users: User){
    
  //  this.userService.updateUserInfo(_userID,this.users).subscribe( resp => {this.users = resp;} 
  //   )
  }


  edit(){
    document.getElementById("editInfo")!.style.display = "block";
    document.getElementById("myInfo")!.style.filter = "blur(4px)"; //blur will blur the background content to make it look nicer
  }
 
  close(){
    document.getElementById("editInfo")!.style.display = "close";
  }


  // passwordNotSatisfy() {

  //   if(this.password.length<6) {
  //     this.goodPassword = false;
  //   } else
  //   this.goodPassword = true;
    

  // }

 
}
