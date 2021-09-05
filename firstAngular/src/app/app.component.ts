import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'firstAngular';
  public parentData = 'Hi from parent component';
  public value = 0;
  public message = '';
}
