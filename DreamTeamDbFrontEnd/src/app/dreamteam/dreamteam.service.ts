import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Dreamteam } from '../models/dreamteam.model';

@Injectable()
export class DreamteamService {
  constructor(private _httpClient: HttpClient) { }

  addDreamTeam(dreamteam: Dreamteam): Observable<Dreamteam> {
    return this._httpClient.post<Dreamteam>("http://localhost:8762/edge/listings/dreamteams", dreamteam, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }
}
