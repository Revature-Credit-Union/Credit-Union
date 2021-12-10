import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  edit(){
    document.getElementById("edit-Info")!.style.display = "block";
    document.getElementById("myInfo")!.style.filter = "blur(4px)"; //blur will blur the background content to make it look nicer
    document.getElementById("myInfo")!.style.pointerEvents = "none"; //pointerEvents to none will not let the mouse click anything else besides the form

  }
 
  close(){
    document.getElementById("edit-Info")!.style.display = "close";
  }

  // Edit Password Method
  changePass() {
    document.getElementById("edit-Pass")!.style.display = "block";
    document.getElementById("myInfo")!.style.filter = "blur(4px)"; //blur will blur the background content to make it look noicer
  }


}
