import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../authenticate.service';
import { MemberLogin } from 'src/app/models/memberLogin.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private _authenticateService: AuthenticateService, private _router: Router) { }

  ngOnInit() {
  }

  model: MemberLogin = new MemberLogin('', '');
  submitted: boolean = false;
  userCheck: boolean = false;

  onSubmit() {
    this.submitted = true;
    this._authenticateService.authenticate(this.model).subscribe(result => {
      console.log(result);
      localStorage.setItem("token", result.token);
      localStorage.setItem("member", result.username);
      localStorage.setItem("id", result.id +"");
      this._authenticateService.isLoggedin.next(result.token ? true : false);
    },
      error => {
        this.userCheck = true;
        this.submitted = false;
      },
      () => {
        this._router.navigate(['dreamteam']);
        console.log("It Works!")
      }
    );
  }
}