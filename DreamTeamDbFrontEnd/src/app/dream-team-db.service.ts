import { Injectable } from '@angular/core';
import {find, retry} from "rxjs/operators";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DreamTeamDbService {

  constructor(private http: HttpClient){

  }
  find(teamName: string){
    return this.http.get('https://www.thesportsdb.com/api/v1/json/1/searchteams.php?t='+teamName).pipe(retry(1))
  }

}
