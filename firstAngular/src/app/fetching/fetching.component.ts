import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-fetching',
  templateUrl: './fetching.component.html',
  styleUrls: ['./fetching.component.css']
})
export class FetchingComponent implements OnInit {
  public posts:  any[] = [];

  constructor(private dataService: DataService) { 
    this.dataService.getPost().subscribe(data => this.posts = data)

  }

  ngOnInit(): void {
  }

}
