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
  title = 'DreamTeam';
  team = undefined;
  login: boolean;

  constructor(private _authenticateService: AuthenticateService, private _router: Router){
    this.login = this._authenticateService.checkLoggedIn();
    console.log(this.login);

  }

  ngOnInit() {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    
  }

  logOut() {
    localStorage.removeItem("token");
    localStorage.removeItem("id");
    localStorage.removeItem("member");
    this._authenticateService.isLoggedin.next(this.login ? true : false);
    this._router.navigate([""]);
  }
}
