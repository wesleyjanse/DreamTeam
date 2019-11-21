import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MemberLogin } from '../models/memberLogin.model';
import { Member } from '../models/member.model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {
  isLoggedin = new BehaviorSubject(false);

  constructor(private _httpClient: HttpClient) { }
  authenticate(memberLogin: MemberLogin): Observable<Member> {
    return this._httpClient.post<Member>("http://localhost:8762/auth/", memberLogin);
  }

  getTest(): Observable<any[]> {
    return this._httpClient.get<any[]>("http://localhost:8762/edge/listings/allFavorieteSpelers/", {
      headers: new HttpHeaders().set("Authorization", "Bearer " + localStorage.getItem("token"))
      });
  }

  checkLoggedIn() {
    if (localStorage.getItem("token")) {
      return true;
    } else {
      return false;
    }
  }
}
