import { Component, OnInit } from '@angular/core';
import { SpelersZoekenService } from '../spelers-zoeken.service';
import { League } from 'src/app/models/league.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-leagues',
  templateUrl: './leagues.component.html',
  styleUrls: ['./leagues.component.scss']
})
export class LeaguesComponent implements OnInit {
  leagues: League[];
  leaguesNotNull: League[] = [];

  constructor(private _spelersZoekenService: SpelersZoekenService, private router: Router) { }

  ngOnInit() {
    this._spelersZoekenService.getAllLeagues().subscribe(res => {
      this.leagues = res.countrys
      this.leagues.forEach(league => {
        this._spelersZoekenService.getAllTeamsByLeagueNaam(league.strLeague).subscribe(res2 => {
          if(res2.teams != null){
            this.leaguesNotNull.push(league);
          }
        })
      })
    })
  }

  leagueClick(l: League) {
    this.router.navigate(['teams'],{queryParams: {leagueNaam: l.strLeague}});
  }
}
