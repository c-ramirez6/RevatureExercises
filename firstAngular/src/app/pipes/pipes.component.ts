import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.css']
})
export class PipesComponent implements OnInit {

  name = 'Mark Smith';
  message = 'Welcome to Angular Training'
  person = {
    firstName: 'Paul',
    lastName: 'Watson'
  }

  currentDate = new Date();
  constructor() { }

  ngOnInit(): void {
  }

}
