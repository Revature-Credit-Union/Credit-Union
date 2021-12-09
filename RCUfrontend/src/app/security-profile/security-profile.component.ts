
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

  
  userID = null;
  username = "FUCKYO";
  password = "fuckyo";
  goodPassword = true;

  constructor(private userService:UserService) { }

  ngOnInit(): void {

    document.getElementById("edit-Info")!.style.display = "none";
  }

  //  getusers(): void{
  //  this.userService.updateUserInfo(this.username, this.password).subscribe( resp => {this.userID = resp;} 
  //   )
  // }


  edit(){
    document.getElementById("edit-Info")!.style.display = "block";
    document.getElementById("myInfo")!.style.filter = "blur(4px)"; //blur will blur the background content to make it look nicer
  }
 
  close(){
    document.getElementById("edit-Info")!.style.display = "close";
  }


  passwordNotSatisfy() {

    if(this.password.length<6) {
      this.goodPassword = false;
    } else
    this.goodPassword = true;
    

  }

 
}
