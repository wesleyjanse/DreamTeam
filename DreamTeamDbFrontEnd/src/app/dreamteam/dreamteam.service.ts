import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DreamteamService {

  constructor(private _httpClient: HttpClient) { }

  getTest(): Observable<any[]> {
    return this._httpClient.get<any[]>("http://localhost:8762/edge/listings/allFavorieteSpelers/", {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }
}
