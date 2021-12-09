import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})



export class UserProfileComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    document.getElementById("edit-Info")!.style.display = "none";
  }

  
  edit(){
    document.getElementById("edit-Info")!.style.display = "block";
    document.getElementById("myInfo")!.style.filter = "blur(4px)"; //blur will blur the background content to make it look nicer
  }
 
  close(){
    document.getElementById("edit-Info")!.style.display = "close";
  }

}
