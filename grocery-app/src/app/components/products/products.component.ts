import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  public catId: any;
  public catName: any;
  public subId: number  =1;
  public subCategory: any;
  public products: any;
  public IMAGE_URL = 'http://rjtmobile.com/grocery/images/'

  constructor(private dataService: DataService, private route: ActivatedRoute) { 
    this.catName = this.route.snapshot.paramMap.get('catName');
    this.catId = this.route.snapshot.paramMap.get('catId');
  }

  ngOnInit(): void {
    this.dataService.getSubByCatId(this.catId).subscribe(
      data => this.subCategory = data
    )

    this.dataService.getProductsByCatId(this.catId).subscribe(
      data => {
        this.products = data;
        console.log(data)
      }
      
    )
  }

  onSubCategorySelected(sub: any){
    this.dataService.getProductsBySubId(sub.subId).subscribe(
      data => this.products = data
    )
  }

}