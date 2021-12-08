import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-account-settings',
  templateUrl: './account-settings.component.html',
  styleUrls: ['./account-settings.component.css']
})
export class AccountSettingsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  clickMethod(name: string) {
    if(confirm("This account will not be able to be recovered!")) {
      console.log("Implement delete functionality here");
    }
  }
}
