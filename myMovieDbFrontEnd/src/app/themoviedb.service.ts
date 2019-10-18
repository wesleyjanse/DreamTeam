import { Injectable } from '@angular/core';
import {retry} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ThemoviedbService {

  constructor(private http: HttpClient) { }
  find(movieId: string){
    return this.http.get('https://api.themoviedb.org/3/find/'+movieId+'?api_key=df827d5d437d52be98e0c8e73c1daee2&language=en-US&external_source=imdb_id').pipe(
        retry(1)
      )
  }
}
