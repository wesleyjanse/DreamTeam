import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { DreamteamService } from '../dreamteam.service';
import { Dreamteam } from 'src/app/models/dreamteam.model';
import { AuthenticateService } from 'src/app/security/authenticate.service';
import { Member } from 'src/app/models/member.model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dreamteam',
  templateUrl: './dreamteam.component.html',
  styleUrls: ['./dreamteam.component.scss']
})
export class DreamteamComponent implements OnInit {
  member: Member;
  hasDreamteam: boolean = false;
  dreamteam: Dreamteam;

  constructor(private fb: FormBuilder, private dts: DreamteamService, private _authenticateService: AuthenticateService, private router: Router) {
    this._authenticateService.isLoggedin.subscribe(e => {
      if (localStorage.getItem('member') != null) {
        this.member = JSON.parse(localStorage.getItem('member'));
        this.dts.getDreamTeam(1).subscribe((res) => {
          console.log(res);
          if (res != null) {
            this.dreamteam = res;
            this.hasDreamteam = true;
          }
        })
      }
    })
  }

  ngOnInit() {

  }



  titleForm = this.fb.group({
    title: ['', [Validators.required, Validators.minLength(2)]]
  });

  submitted: Boolean = false;
  started: Boolean = false;


  onSubmit() {
    this.submitted = true;
    let newDreamteam = new Dreamteam(this.titleForm.get('title').value, 1, null, )
    this.dts.addDreamTeam(newDreamteam).subscribe(() => {
      console.log("yes");
    });
  }

  onBegin() {
    this.started = true;
  }

  clickEdit(){
    console.log('edit');
    this.router.navigate(['dreamteamedit']);
  }

  clickDelete(){
    console.log('delete');
  }
}
