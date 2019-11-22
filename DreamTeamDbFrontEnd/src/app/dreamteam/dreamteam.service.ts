import { Injectable } from '@angular/core';
<<<<<<< HEAD
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
=======
import { Dreamteam } from '../models/dreamteam.model';
import { HttpClient } from '@angular/common/http';
>>>>>>> tussencommit dreamteam

@Injectable({
  providedIn: 'root'
})
export class DreamteamService {

  constructor(private _httpClient: HttpClient) { }

<<<<<<< HEAD
  getTest(): Observable<any[]> {
    return this._httpClient.get<any[]>("http://localhost:8762/edge/listings/allFavorieteSpelers/", {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }
=======
  addDreamTeam(dreamteam: Dreamteam){
    return this._httpClient.post<Dreamteam>("http://localhost:8050/listings/dreamTeams", dreamteam)
  }

>>>>>>> tussencommit dreamteam
}
