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

const appRoutes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'dreamteam', component: DreamteamComponent },
  ];
@NgModule({
  declarations: [
    AppComponent,
    DreamteamComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    SecurityModule,
    MaterialModule,
    FormSharedModule,
    DreamteamModule,
    RouterModule.forRoot(appRoutes, { enableTracing: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
