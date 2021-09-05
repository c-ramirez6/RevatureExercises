import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {
  @Input()
  childData = '';

  @Output()
  childEvent = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }

  onClick() {
    this.childEvent.emit('Hello from Child Component');
  }

}
