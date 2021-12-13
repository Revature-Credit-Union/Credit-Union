import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User} from 'src/app/models/userModel';
import { Account} from 'src/app/models/Account';
import jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
 
  constructor(private userService:UserService) {}
  content?: string;
  private accounts: Account[] = [];
  ngOnInit(): void {
    this.userService.getPublicContent().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );

  }

}
