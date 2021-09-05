import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-exercise1',
  templateUrl: './exercise1.component.html',
  styleUrls: ['./exercise1.component.css']
})
export class Exercise1Component implements OnInit {

  public table = false;

  public employees = [
    {
      id: 1, name: 'Mark', email: 'm@gmail.com', gender: 'Male'
    },
    {
      id: 2, name: 'Paul', email: 'p@gmail.com', gender: 'Male'
    },
    {
      id: 3, name: 'Sandra', email: 's@gmail.com', gender: 'Female'
    },
    {
      id: 4, name: 'Clark', email: 'c@gmail.com', gender: 'Male'
    },
    {
      id: 5, name: 'Watson', email: 'w@gmail.com', gender: 'Male'
    }

  ]


  constructor() { }

  ngOnInit(): void {
  }

  showTable() {
    this.table = !this.table
  }

}
