import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Speler } from '../models/speler.model';
import { Observable } from 'rxjs';

@Injectable()
export class FavorieteSpelersService {

  constructor(private _httpClient: HttpClient) { }

  getFavorieteSpelersByUserId(id: number): Observable<Speler[]> {
    return this._httpClient.get<Speler[]>("http://localhost:8762/edge/listings/getAllFavorieteSpelersById/" + id, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
    });
  }

  deleteFavorieteSpeler(id: string) {
    return this._httpClient.delete<Speler>("http://localhost:8762/edge/listings/favorieteSpeler/" + id, {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }
}
