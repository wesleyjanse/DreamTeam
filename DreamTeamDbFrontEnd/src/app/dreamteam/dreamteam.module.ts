import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DreamteamService } from './dreamteam.service';
import { DreamteameditComponent } from './dreamteamedit/dreamteamedit.component';
import { DreamteamComponent } from './dreamteam/dreamteam.component';
import { FormSharedModule } from '../core/form.module';
import { MaterialModule } from '../core/material.module';
import { ZoekDreamteamComponent } from './zoek-dreamteam/zoek-dreamteam.component'

@NgModule({
  declarations: [DreamteameditComponent, DreamteamComponent, ZoekDreamteamComponent],
  imports: [
    CommonModule,
    FormSharedModule,
    MaterialModule
  ],
  providers: [
    DreamteamService
  ]
})

export class DreamteamModule { }
