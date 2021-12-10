import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})



export class UserProfileComponent implements OnInit {

  content?:string;

  form: any = {
    email:null,
    first_name: null,
    last_name: null
  }
  // Placeholders for myInfo variables, to be swapped out for database references
  firstName: string = "Charles";
  lastName: string = "Dickens";
  email: string = "dude@myguy.org";

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    document.getElementById("edit-Info")!.style.display = "none";
  }

  
  edit(){
    document.getElementById("edit-Info")!.style.display = "block";
    document.getElementById("myInfo")!.style.filter = "blur(4px)"; //blur will blur the background content to make it look nicer
  }
 
  close(){
    document.getElementById("edit-Info")!.style.display = "none";
    document.getElementById("myInfo")!.style.filter = "blur(0px)"; //blur will blur the background content to make it look nicer

  }

  updateInfo(){
    const{first_name, last_name, email} = this.form;
    this.userService.updateUserInfo(email, first_name, last_name).subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

}
