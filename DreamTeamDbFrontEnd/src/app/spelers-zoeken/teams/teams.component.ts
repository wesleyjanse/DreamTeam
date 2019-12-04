import { Component, OnInit } from '@angular/core';
import { Team } from 'src/app/models/team.model';
import { SpelersZoekenService } from '../spelers-zoeken.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.scss']
})
export class TeamsComponent implements OnInit {
  teams: Team[];
  teamsNotNull: Team[] = [];
  league: string;

  constructor(private _spelersZoekenService: SpelersZoekenService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.league = this.route.snapshot.queryParamMap.get('leagueNaam');
    this._spelersZoekenService.getAllTeamsByLeagueNaam(this.route.snapshot.queryParamMap.get('leagueNaam')).subscribe(res => {
      this.teams = res.teams;
      this.teams.forEach(team => {
        this._spelersZoekenService.getAllSpelersByTeamNaam(team.strTeam).subscribe(res2 => {
          if(res2.player != null){
              this.teamsNotNull.push(team);
          }
        })
      })
    })
  }

  teamClick(t: Team) {
    this.router.navigate(['spelers'],{queryParams: {teamNaam: t.strTeam}});
  }
}
