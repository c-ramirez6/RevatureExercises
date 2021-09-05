import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  public IMAGE_URL = 'http://rjtmobile.com/grocery/images/';

  private END_POINTS = {
    CATEGOTY_URL: 'http://apolis-grocery.herokuapp.com/api/category',
    SUB_CATEGORY: 'http://apolis-grocery.herokuapp.com/api/subcategory/',
    PRODUCT_BY_SUB_URL: 'http://apolis-grocery.herokuapp.com/api/products/sub/',
    PRODUCT_BY_CAT_URL: 'http://apolis-grocery.herokuapp.com/api/products/cat/',
    ORDER_URL: '',
    
  }

  constructor(private http: HttpClient) { }

  getCategories(): Observable<any> {
    return this.http.get<any>(this.END_POINTS.CATEGOTY_URL);
  }

  getSubByCatId(catId: number): Observable<any> {
    return this.http.get<any>(`${this.END_POINTS.SUB_CATEGORY + catId}`);
  }

  getProductsByCatId(catId:number){
    return this.http.get(`${this.END_POINTS.PRODUCT_BY_CAT_URL+catId}`)
  }

  getProductsBySubId(subId:number){
    return this.http.get(`${this.END_POINTS.PRODUCT_BY_SUB_URL + subId}`)
  }
}
