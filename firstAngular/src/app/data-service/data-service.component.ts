import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-data-service',
  templateUrl: './data-service.component.html',
  styleUrls: ['./data-service.component.css']
})
export class DataServiceComponent implements OnInit {
  employees: any = []

  constructor(private dataService: DataService) { 
    this.employees = dataService.getEmployees();
  }
  ngOnInit(): void {
  }

}
