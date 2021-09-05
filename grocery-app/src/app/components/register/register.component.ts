import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/user.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  userModel = new User('', '', '', '', '', '', true);
  constructor() { }

  ngOnInit(): void {
  }

  onFormSubmit(data: any){
    console.log(data)
  }

}
