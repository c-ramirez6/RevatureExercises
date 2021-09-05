import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router'

@Component({
  selector: 'app-department-detail',
  templateUrl: './department-detail.component.html',
  styleUrls: ['./department-detail.component.css']
})
export class DepartmentDetailComponent implements OnInit {

  public departmentId: any = 0;

  constructor(private route: ActivatedRoute) { 
    let id = this.route.snapshot.paramMap.get('id');
    this.departmentId = id;
  }

  ngOnInit(): void {
  }

}
