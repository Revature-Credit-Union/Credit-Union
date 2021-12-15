import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})



export class UserProfileComponent implements OnInit {
  email = this.tokenService.getUser().email;
  firstName = this.tokenService.getUser().first_name;
  lastName = this.tokenService.getUser().last;
  content?:string;

  form: any = {
    email:this.email,
    firstName: this.firstName,
    lastName: this.lastName
  }
  // Placeholders for myInfo variables, to be swapped out for database references
  firstName: string = "Charles";
  lastName: string = "Dickens";
  email: string = "dude@myguy.org";


  constructor(private userService: UserService, private router: Router, private tokenService: TokenStorageService) { }

  ngOnInit(): void {
    document.getElementById("edit-Info")!.style.display = "none";
    console.log(this.form);
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
        console.log(data);
      },
      err => {
        this.content = JSON.parse(err.error).message;
        
      }
    );
  }

}
