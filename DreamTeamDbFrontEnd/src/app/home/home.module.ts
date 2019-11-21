import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { MaterialModule } from '../core/material.module';
import { FormSharedModule } from '../core/form.module';



@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    MaterialModule,
    FormSharedModule,
  ],
  providers:[],
  bootstrap:[HomeComponent],
})
export class HomeModule { }
