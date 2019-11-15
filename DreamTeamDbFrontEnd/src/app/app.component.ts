import { Component } from '@angular/core';
import {DreamTeamDbService} from "./dream-team-db.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Dream Team';
  team = undefined;

  constructor(private dreamTeamDbService : DreamTeamDbService){
    this.dreamTeamDbService.find('Arsenal').subscribe(
      res => {this.team = res;}
    )
  }
}
