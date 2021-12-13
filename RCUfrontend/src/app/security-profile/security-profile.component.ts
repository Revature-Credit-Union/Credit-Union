
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


  users: User[] = [];
  
  
  userID = null;
  username = "";
  password = "";
  goodPassword = true;

  constructor(private userService:UserService) { }

  ngOnInit(): void {

    

    document.getElementById("editInfo")!.style.display = "none";
 //f45939eebffd34500feec9cf7abd74c83e5b85c4
  }

  getUsers() {
    this.userService.getallusers().subscribe( resp => this.users =resp)
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


  passwordNotSatisfy() {

    if(this.password.length<6) {
      this.goodPassword = false;
    } else
    this.goodPassword = true;
    

  }

 
}
