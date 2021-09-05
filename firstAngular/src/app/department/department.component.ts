import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css']
})
export class DepartmentComponent implements OnInit {
  departments = [
    {id: 1, name: 'HR'},
    {id: 2, name: 'Production'},
    {id: 3, name: 'Management'},
  ]

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onClick(department: any) {
    this.router.navigate(['/department', department.id])
  }

}
