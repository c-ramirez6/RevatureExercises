import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ngfor',
  templateUrl: './ngfor.component.html',
  styleUrls: ['./ngfor.component.css']
})
export class NgforComponent implements OnInit {

  public text = "test";

  public employees = [
    {
      id:1, name:'Mark', email:'m@gmail.com', gender:'Male'
    },
    {
      id:2, name:'Paul', email:'p@gmail.com', gender:'Male'
    },
    {
      id:3, name:'Sandra', email:'s@gmail.com', gender:'Female'
    },
    {
      id:4, name:'Clark', email:'c@gmail.com', gender:'Male'
    },
    {
      id:5, name:'Watson', email:'w@gmail.com', gender:'Male'
    }

  ]

  constructor() { }

  ngOnInit(): void {
  }

  addEmployee(input: string)  {
    let parts = input.split(" ");
    this.employees[this.employees.length] = {
      id: +parts[0],
      name: parts[1],
      email: parts[2],
      gender: parts[3]
    }
  }

  trackById(employee: any) {
    return employee.id;
  }

}
