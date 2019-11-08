import { Component } from '@angular/core';
import {DreamTeamDbService} from "./dream-team-db.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'DreamTeamDbFrontEnd';
  team = undefined;

  constructor(private dreamTeamDbService : DreamTeamDbService){
    this.dreamTeamDbService.find('Arsenal').subscribe(
      res => {this.team = res;}
    )
  }
}
