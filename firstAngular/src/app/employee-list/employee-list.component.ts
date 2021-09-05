import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees = [
    {code: 'emp101', name: 'Mark', gender: "Male", salary: 5000, dob: "12/20/2000"},
    {code: 'emp102', name: 'Paul', gender: "Male", salary: 4500, dob: "02/04/1999"},
    {code: 'emp103', name: 'Watson', gender: "Male", salary: 7000, dob: "05/20/2000"},
    {code: 'emp104', name: 'Sarah', gender: "Female", salary: 5000, dob: "08/10/2000"},
    {code: 'emp105', name: 'Stacy', gender: "Female", salary: 8000, dob: "01/21/2000"}
  ]

  constructor() { }

  ngOnInit(): void {
  }

}
