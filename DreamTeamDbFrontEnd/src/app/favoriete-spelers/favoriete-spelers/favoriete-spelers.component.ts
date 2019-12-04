import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/security/authenticate.service';
import { FavorieteSpelersService } from '../favoriete-spelers.service';
import { Speler } from 'src/app/models/speler.model';

@Component({
  selector: 'app-favoriete-spelers',
  templateUrl: './favoriete-spelers.component.html',
  styleUrls: ['./favoriete-spelers.component.scss']
})
export class FavorieteSpelersComponent implements OnInit {
  memberName: string;
  memberId: number;
  favorieteSpelers: Speler[];

  constructor(private _authenticateService: AuthenticateService, private _favorieteSpelersService: FavorieteSpelersService) {
   }

  ngOnInit() {
    this._authenticateService.isLoggedin.subscribe(e => {
      if (localStorage.getItem('member') != null) {
        this.memberName = localStorage.getItem('member');
        this.memberId = Number(localStorage.getItem('id'));
        this._favorieteSpelersService.getFavorieteSpelersByUserId(this.memberId).subscribe(res => {
          this.favorieteSpelers = res;
        });
      }
    });
  }

  deleteFavSpeler(f: Speler){
    console.log(this.memberId);
    this._favorieteSpelersService.deleteFavorieteSpeler(f.id, this.memberId).subscribe(() => {
      this.ngOnInit()
    })
  }
}
