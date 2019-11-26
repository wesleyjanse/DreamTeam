import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { DreamteamService } from '../dreamteam.service';
import { Dreamteam } from 'src/app/models/dreamteam.model';
import { AuthenticateService } from 'src/app/security/authenticate.service';
import { Member } from 'src/app/models/member.model';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Speler } from 'src/app/models/speler.model';
import { ActivatedRoute } from "@angular/router";
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
  andereGebruiker: boolean = false;
  constructor(private fb: FormBuilder, private dts: DreamteamService, private _authenticateService: AuthenticateService, private router: Router, private route: ActivatedRoute) {
    
  }

  ngOnInit() {
    console.log();
    this._authenticateService.isLoggedin.subscribe(e => {
      if (localStorage.getItem('member') != null) {
        this.memberName = localStorage.getItem('member');
        this.memberId = Number(localStorage.getItem('id'));
        let searchId;
        if (this.route.snapshot.queryParamMap.get('id') != null) {
          searchId = this.route.snapshot.queryParamMap.get('id')
          if (searchId != this.memberId) {
            this.andereGebruiker = true;
          }
        } else{
          searchId = this.memberId;
        }

        this.dts.getDreamTeamWithSpelers(searchId).subscribe((res) => {
          if (res != null) {
            this.hasDreamteam = true;
            this.dreamteam = res.dreamTeam;
            this.spelers = res.spelers;
          }
        },
        error => {
            this.hasDreamteam = false;
            this.started = false;
            this.submitted = false;
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


  zoekTeams(){
    this.router.navigate(['zoekdreamteams']);
  }

  clickDelete() {
    this.dts.deleteDreamteam(this.dreamteam.id).subscribe(() => {
      this.ngOnInit()
    })
  }
}
