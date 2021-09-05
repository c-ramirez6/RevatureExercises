import { Component, OnInit } from '@angular/core';
import {DataImageService} from '../services/data-image.service'

@Component({
  selector: 'app-get-images',
  templateUrl: './get-images.component.html',
  styleUrls: ['./get-images.component.css']
})
export class GetImagesComponent implements OnInit {
  public photos: any[] = [];
  constructor(private dataImageService: DataImageService) {
    this.dataImageService.getImages().subscribe(data => this.photos = data)
   }

  ngOnInit(): void {
  }

}
