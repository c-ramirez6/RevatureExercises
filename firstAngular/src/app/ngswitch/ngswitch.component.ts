import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ngswitch',
  templateUrl: './ngswitch.component.html',
  styleUrls: ['./ngswitch.component.css']
})
export class NgswitchComponent implements OnInit {
  public value = 1;
  constructor() { }

  ngOnInit(): void {
  }

  increment() {
    this.value += 1;
  }

  decrement() {
    this.value -= 1;
  }

}
