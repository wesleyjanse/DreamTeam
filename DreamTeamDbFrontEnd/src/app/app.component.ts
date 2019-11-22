import { Component } from '@angular/core';
import {DreamTeamDbService} from "./dream-team-db.service";
import { AuthenticateService } from './security/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Dream Team';
  team = undefined;
  login: boolean;

  constructor(private dreamTeamDbService : DreamTeamDbService, private _authenticateService: AuthenticateService, private _router: Router){
    this.dreamTeamDbService.find('Arsenal').subscribe(
      res => {this.team = res;}
    )
    this._authenticateService.isLoggedin.subscribe(e=> {
      this.login = !e.valueOf();
      
  })
  }

  logOut() {
    localStorage.removeItem("token");
    localStorage.removeItem("id");
    localStorage.removeItem("member");
    this._authenticateService.isLoggedin.next(this.login ? true : false);
    this._router.navigate([""]);
  }
}
