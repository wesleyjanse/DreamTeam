import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Dreamteam } from '../models/dreamteam.model';
import { Speler } from '../models/speler.model';
import { DreamteamMetSpelers } from '../models/dreamteamMetSpelers.model';
import { DreamteamMetSpelersEnUsers } from '../models/dreamteamMetSpelersEnUsers.model';

@Injectable()
export class DreamteamService {
  constructor(private _httpClient: HttpClient) { }

  addDreamTeam(dreamteam: Dreamteam): Observable<Dreamteam> {
    return this._httpClient.post<Dreamteam>("http://localhost:8762/edge/listings/dreamteams", dreamteam, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }

  getDreamTeam(id: number): Observable<Dreamteam> {
    return this._httpClient.get<Dreamteam>("http://localhost:8762/edge/listings/dreamteams/" + id, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }

  getFavorieteSpelersByUserId(id: number): Observable<Speler[]> {
    return this._httpClient.get<Speler[]>("http://localhost:8762/edge/listings/getAllFavorieteSpelersById/" + id, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }

  updateDreamteam(id: string, dreamteam: Dreamteam){
    return this._httpClient.put<Dreamteam>("http://localhost:8762/edge/listings/updateDreamteam/" + id, dreamteam, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }

  getDreamTeamWithSpelers(id: number): Observable<DreamteamMetSpelers> {
    return this._httpClient.get<DreamteamMetSpelers>("http://localhost:8762/edge/listings/getDreamteamWithPlayers/" + id, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }

  getDreamTeamWithSpelersEnUsers(): Observable<DreamteamMetSpelersEnUsers> {
    return this._httpClient.get<DreamteamMetSpelersEnUsers>("http://localhost:8762/edge/listings/allDreamTeamsWithUsers", {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }

  deleteDreamteam(id: string) {
    return this._httpClient.delete<Dreamteam>("http://localhost:8762/edge/listings/dreamTeam/" + id, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }
}
