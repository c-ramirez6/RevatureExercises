import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  template: `
    <h1>Test component</h1>
    <h1>Mark</h1>
    <h1>Hello {{name}}</h1>
    <h1>{{message}}</h1>
    <h1 id="test"></h1>
  `,
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  public name: string = 'Paul';
  public message: string = 'This is angular training';

  constructor() { }

  greet() {
    
  }

  ngOnInit(): void {
  }

}