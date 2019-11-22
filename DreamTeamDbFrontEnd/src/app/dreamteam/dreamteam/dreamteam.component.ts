import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { DreamteamService } from '../dreamteam.service';
import { Dreamteam } from 'src/app/models/dreamteam.model';
import { AuthenticateService } from 'src/app/security/authenticate.service';
import { Member } from 'src/app/models/member.model';

@Component({
  selector: 'app-dreamteam',
  templateUrl: './dreamteam.component.html',
  styleUrls: ['./dreamteam.component.scss']
})
export class DreamteamComponent implements OnInit {
  member: Member;

  constructor(private fb: FormBuilder, private dts: DreamteamService, private _authenticateService: AuthenticateService) {
    this._authenticateService.isLoggedin.subscribe(e => {
      if (localStorage.getItem('member') != null) {
        this.member = JSON.parse(localStorage.getItem('member'));
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
    let newDreamteam = new Dreamteam(this.titleForm.get('title').value, "1")
    this.dts.addDreamTeam(newDreamteam).subscribe(() => {
      console.log("yes");
    });
  }

  onBegin() {
    this.started = true;
  }

}
