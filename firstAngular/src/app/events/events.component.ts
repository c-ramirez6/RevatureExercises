import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-events',
  template:`
    <button (click)="onButtonClicked()">Click Me</button>
    <br>
    <input type="text" #textInput><button (click)="displayText(textInput.value)">Enter</button>
    <br>
    <h1>{{ message }}</h1>
    <br><br>
    <textarea #input (keyup)="length(input.value)" maxlength="140"></textarea>
    <h4>{{amount.length}}/140</h4>

  `,
  styleUrls: ['./events.component.css']
})
export class EventsComponent implements OnInit {
  public message: string = "";
  public amount: string = "";
  constructor() { }

  onButtonClicked() {
    console.log("Test");
  }

  ngOnInit(): void {
  }

  displayText(value: any){
    this.message = value;
  }
  
  length(length: any)  {
    this.amount = length;
  }

}
