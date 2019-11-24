import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { DreamteamService } from '../dreamteam.service';
import { Dreamteam } from 'src/app/models/dreamteam.model';
import { AuthenticateService } from 'src/app/security/authenticate.service';
import { Member } from 'src/app/models/member.model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Speler } from 'src/app/models/speler.model';

@Component({
  selector: 'app-dreamteam',
  templateUrl: './dreamteam.component.html',
  styleUrls: ['./dreamteam.component.scss']
})
export class DreamteamComponent implements OnInit {
  memberName: string;
  memberId: number;
  hasDreamteam: boolean = false;
  dreamteam: Dreamteam;
  spelers: Speler[];

  constructor(private fb: FormBuilder, private dts: DreamteamService, private _authenticateService: AuthenticateService, private router: Router) {
    
  }

  ngOnInit() {
    this._authenticateService.isLoggedin.subscribe(e => {
      if (localStorage.getItem('member') != null) {
        this.memberName = localStorage.getItem('member');
        this.memberId = Number(localStorage.getItem('id'));
        
        this.dts.getDreamTeamWithSpelers(this.memberId).subscribe((res) => {
          if (res != null) {
            console.log(res);
            this.dreamteam = res.dreamTeam;
            this.spelers = res.spelers;
            this.hasDreamteam = true;
          }
        })
      }
    })
  }


  

  titleForm = this.fb.group({
    title: ['', [Validators.required, Validators.minLength(2)]]
  });

  submitted: Boolean = false;
  started: Boolean = false;


  onSubmit() {
    this.submitted = true;
    let spelers = ["","","","","","","","","","",""]
    let newDreamteam = new Dreamteam(this.titleForm.get('title').value, this.memberId, null, spelers)
    this.dts.addDreamTeam(newDreamteam).subscribe(() => {
      this.ngOnInit();
    });
  }

  onBegin() {
    this.started = true;
  }

  clickEdit() {
    this.router.navigate(['dreamteamedit']);
  }

  clickDelete() {
    console.log('delete');
  }
}
