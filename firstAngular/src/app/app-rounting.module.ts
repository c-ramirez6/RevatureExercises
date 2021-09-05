import { NgModule } from "@angular/core";
import { Routes, RouterModule } from '@angular/router';
import { DepartmentComponent } from "./department/department.component";
import { CompanyComponent } from "./company/company.component";
import { DepartmentDetailComponent } from "./department-detail/department-detail.component";

const routes: Routes = [
    { path: 'department', component: DepartmentComponent },
    { path: 'company', component: CompanyComponent },
    { path: 'department/:id', component: DepartmentDetailComponent }
]


@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{

}