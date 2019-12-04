import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { League } from '../models/league.model';
import { Observable } from 'rxjs';
import { Team } from '../models/team.model';
import { Speler } from '../models/speler.model';

@Injectable()
export class SpelersZoekenService {
  constructor(private _httpClient: HttpClient) { }

  getAllLeagues(): Observable<League[]>{
    return this._httpClient.get<League[]>("https://www.thesportsdb.com/api/v1/json/1/search_all_leagues.php?s=Soccer")
  }

  getAllTeamsByLeagueNaam(leagueNaam: string): Observable<Team[]>{
    return this._httpClient.get<Team[]>("https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=" + leagueNaam)
  }

  getAllSpelersByTeamNaam(teamNaam: string): Observable<Speler[]>{
    return this._httpClient.get<Speler[]>("https://www.thesportsdb.com/api/v1/json/9124689124922/searchplayers.php?t=" + teamNaam)
  }

  addFavorieteSpeler(speler: Speler): Observable<Speler> {
    return this._httpClient.post<Speler>("http://localhost:8762/edge/listings/favorieteSpelers", speler, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }

  getFavorieteSpelersByUserId(id: number): Observable<Speler[]> {
    return this._httpClient.get<Speler[]>("http://localhost:8762/edge/listings/getAllFavorieteSpelersById/" + id, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }
}
