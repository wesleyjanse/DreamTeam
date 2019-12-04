import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FavorieteSpelersComponent } from './favoriete-spelers/favoriete-spelers.component';
import { FavorieteSpelersService } from './favoriete-spelers.service';
import { MaterialModule } from '../core/material.module';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [FavorieteSpelersComponent],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
  ],
  providers: [
    FavorieteSpelersService
  ]
})
export class FavorieteSpelersModule { }
