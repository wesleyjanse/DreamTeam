import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SpelersComponent } from './spelers/spelers.component';
import { LeaguesComponent } from './leagues/leagues.component';
import { TeamsComponent } from './teams/teams.component';
import { SpelersZoekenService } from './spelers-zoeken.service';
import { MaterialModule } from '../core/material.module';
import { FormsModule } from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';


@NgModule({
  declarations: [SpelersComponent, LeaguesComponent, TeamsComponent],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    MatSnackBarModule
  ],
  providers: [
    SpelersZoekenService
  ]
})
export class SpelersZoekenModule { }
