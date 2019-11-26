import { Component, OnInit } from '@angular/core';
import { DreamteamService } from '../dreamteam.service';
import { DreamteamMetSpelersEnUsers } from 'src/app/models/dreamteamMetSpelersEnUsers.model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-zoek-dreamteam',
  templateUrl: './zoek-dreamteam.component.html',
  styleUrls: ['./zoek-dreamteam.component.scss']
})
export class ZoekDreamteamComponent implements OnInit {

  teams: DreamteamMetSpelersEnUsers;

  constructor(private _dreamteamService: DreamteamService, private router: Router) { 
    this._dreamteamService.getDreamTeamWithSpelersEnUsers().subscribe(res => {
      this.teams = res;
      console.log(this.teams)
    })
  }

  ngOnInit() {

  }

  openTeam(userId: number){
    this.router.navigate([
      'dreamteam'
    ],{queryParams: {id: userId}})
  }

}
