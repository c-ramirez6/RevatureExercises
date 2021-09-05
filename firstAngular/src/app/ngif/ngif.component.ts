import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ngif',
  templateUrl: './ngif.component.html',
  styleUrls: ['./ngif.component.css']
})
export class NgifComponent implements OnInit {
  public isLoggedIn = true;

  LogChange() {
    this.isLoggedIn = !this.isLoggedIn;
  }

  constructor() { }

  ngOnInit(): void {
  }

}
