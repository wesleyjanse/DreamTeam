import { Component, OnInit } from '@angular/core';
import { SpelersZoekenService } from '../spelers-zoeken.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Speler } from 'src/app/models/speler.model';
import { AuthenticateService } from 'src/app/security/authenticate.service';
import { FavorieteSpeler } from 'src/app/models/favoriete-speler.model';
import { MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-spelers',
  templateUrl: './spelers.component.html',
  styleUrls: ['./spelers.component.scss']
})
export class SpelersComponent implements OnInit {
  memberName: string;
  memberId: number;
  team: string;
  spelersNotFavorite: Speler[] = [];
  spelers: Speler[];
  favorieteSpelers: Speler[];
  favorieteSpelersNamen: string[] = [];

  constructor(private _spelersZoekenService: SpelersZoekenService, private _authenticateService: AuthenticateService, private router: Router, private route: ActivatedRoute, private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.team = this.route.snapshot.queryParamMap.get('teamNaam');
    this._authenticateService.isLoggedin.subscribe(e => {
      if (localStorage.getItem('member') != null) {
        this.memberName = localStorage.getItem('member');
        this.memberId = Number(localStorage.getItem('id'));
        this._spelersZoekenService.getFavorieteSpelersByUserId(this.memberId).subscribe(res => {
          this.favorieteSpelers = res;
          this.favorieteSpelers.forEach(favorieteSpeler => {
            this.favorieteSpelersNamen.push(favorieteSpeler.naam);
          })
        });
      }
    });
    this._spelersZoekenService.getAllSpelersByTeamNaam(this.route.snapshot.queryParamMap.get('teamNaam')).subscribe(res => {
      this.spelers = res.player;
    });
  }

  refresh(): void {
    window.location.reload();
  }

  addFavorite(s: FavorieteSpeler) {
    let afbeelding = "";
    this._authenticateService.isLoggedin.subscribe(e => {
      if (localStorage.getItem('member') != null) {
        this.memberName = localStorage.getItem('member');
        this.memberId = Number(localStorage.getItem('id'));
        if (!this.favorieteSpelersNamen.includes(s.strPlayer)) {
          afbeelding = s.strCutout
          if (s.strCutout == null) {
            afbeelding = s.strThumb;
          }
          let speler = new Speler(s.strPlayer, this.memberId, s.strPosition, afbeelding, null);
          this._spelersZoekenService.addFavorieteSpeler(speler).subscribe();
          this.refresh()
        } else {
          console.log("speler al reeds in favorieten");
          this.snackBar.open('Speler is al favoriet!', 'OK');
        }
      }
    })
  }
}