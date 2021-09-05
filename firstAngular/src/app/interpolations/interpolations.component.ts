import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-interpolations',
  template: `

  <img src="{{image}}" width="200"/>
  <img [src]="image" width="200"/>
  <br>
  <button disabled="{{isDisabled}}">interpolation</button>
  <button [disabled]="isDisabled">property binding</button>

  `,
  styleUrls: ['./interpolations.component.css']
})
export class InterpolationsComponent implements OnInit {
  public image: string = "https://cdn.icon-icons.com/icons2/836/PNG/512/Google_icon-icons.com_66793.png";
  public isDisabled: boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

}
