import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-counter-button',
  templateUrl: './counter-button.component.html',
  styleUrls: ['./counter-button.component.css']
})
export class CounterButtonComponent implements OnInit {
  value = 0;

  @Output()
  childEvent = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  increment() {
    this.value += 1
    this.childEvent.emit(this.value);
  }

  decrement() {
    this.value -= 1
    this.childEvent.emit(this.value);
  }

}
