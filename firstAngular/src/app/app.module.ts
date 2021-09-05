import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { InterpolationsComponent } from './interpolations/interpolations.component';
import { EventsComponent } from './events/events.component';
import { NgifComponent } from './ngif/ngif.component';
import { NgswitchComponent } from './ngswitch/ngswitch.component';
import { NgforComponent } from './ngfor/ngfor.component';
import { Exercise1Component } from './exercise1/exercise1.component';
import { PipesComponent } from './pipes/pipes.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { TitlePipe } from './title.pipe';
import { ChildComponent } from './child/child.component';
import { CounterComponent } from './counter/counter.component';
import { CounterOutputComponent } from './counter-output/counter-output.component';
import { CounterButtonComponent } from './counter-button/counter-button.component';
import { DataServiceComponent } from './data-service/data-service.component';
import { FetchingComponent } from './fetching/fetching.component'
import { HttpClientModule } from '@angular/common/http';
import { GetImagesComponent } from './get-images/get-images.component';
import { DepartmentComponent } from './department/department.component';
import { CompanyComponent } from './company/company.component'
import { AppRoutingModule } from './app-rounting.module';
import { DepartmentDetailComponent } from './department-detail/department-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    InterpolationsComponent,
    EventsComponent,
    NgifComponent,
    NgswitchComponent,
    NgforComponent,
    Exercise1Component,
    PipesComponent,
    EmployeeListComponent,
    TitlePipe,
    ChildComponent,
    CounterComponent,
    CounterOutputComponent,
    CounterButtonComponent,
    DataServiceComponent,
    FetchingComponent,
    GetImagesComponent,
    DepartmentComponent,
    CompanyComponent,
    DepartmentDetailComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
