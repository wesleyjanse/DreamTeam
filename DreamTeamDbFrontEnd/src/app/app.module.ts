import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './security/login/login.component';
import { SecurityModule } from './security/security.module'
import { MaterialModule } from './core/material.module';
import { FormSharedModule } from './core/form.module';
import { DreamteamComponent } from './dreamteam/dreamteam/dreamteam.component';
import { DreamteamModule } from './dreamteam/dreamteam.module';
import { TestComponent } from './test/test.component';
import { DreamteameditComponent } from './dreamteam/dreamteamedit/dreamteamedit.component';
import { HomeComponent } from './home/home.component';
import { HomeModule } from './home/home.module';
import { ZoekDreamteamComponent } from './dreamteam/zoek-dreamteam/zoek-dreamteam.component';

const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'dreamteam', component: DreamteamComponent },
  { path: 'dreamteamedit', component: DreamteameditComponent },
  { path: 'zoekdreamteams', component: ZoekDreamteamComponent },
  { path: 'home', component: HomeComponent },
  ];
@NgModule({
  declarations: [
    AppComponent,
    TestComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    SecurityModule,
    MaterialModule,
    FormSharedModule,
    DreamteamModule,
    HomeModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
