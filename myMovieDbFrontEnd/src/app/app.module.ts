import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ShowtextComponent } from './showtext/showtext.component';
import { HttpClientModule } from '@angular/common/http';
imports: [ BrowserModule, HttpClientModule];



@NgModule({
  declarations: [
    AppComponent,
    ShowtextComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
