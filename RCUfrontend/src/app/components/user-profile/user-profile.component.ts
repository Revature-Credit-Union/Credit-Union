import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})



export class UserProfileComponent implements OnInit {

  // Placeholders for myInfo variables, to be swapped out for database references
  firstName: string = "Charles";
  lastName: string = "Dickens";
  email: string = "dude@myguy.org";

  constructor() { }

  ngOnInit(): void {
    document.getElementById("edit-Info")!.style.display = "none";
    document.getElementById("edit-Pass")!.style.display = "none";
  }

  
  edit(){
    document.getElementById("edit-Info")!.style.display = "block";
    document.getElementById("myInfo")!.style.filter = "blur(4px)"; //blur will blur the background content to make it look nicer
  }
 
  close(){
    document.getElementById("edit-Info")!.style.display = "none";
    document.getElementById("edit-Pass")!.style.display = "none";
    document.getElementById("myInfo")!.style.filter = "blur(0px)"; //blur will blur the background content to make it look nicer

  }

  // Edit Password Method
  changePass() {
    document.getElementById("edit-Pass")!.style.display = "block";
    document.getElementById("myInfo")!.style.filter = "blur(4px)"; //blur will blur the background content to make it look noicer
  }

}
