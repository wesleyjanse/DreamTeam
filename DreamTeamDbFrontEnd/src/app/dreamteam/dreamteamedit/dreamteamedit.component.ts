import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, NgControlStatus } from '@angular/forms';
import { DreamteamService } from '../dreamteam.service';
import { Speler } from 'src/app/models/speler.model';
import { AuthenticateService } from 'src/app/security/authenticate.service';
import { Dreamteam } from 'src/app/models/dreamteam.model';
import { Router } from '@angular/router';
import { FormArray } from '@angular/forms';

@Component({
  selector: 'app-dreamteamedit',
  templateUrl: './dreamteamedit.component.html',
  styleUrls: ['./dreamteamedit.component.scss']
})
export class DreamteameditComponent implements OnInit {

  constructor(private fb: FormBuilder, private dreamteamService: DreamteamService, private _authenticateService: AuthenticateService, private router: Router) {

  }

  ngOnInit() {
    this.soccerForm = this.fb.group({
      teamNaam: [''],
      doelman: [''],
      verdediger1: [''],
      verdediger2: [''],
      verdediger3: [''],
      verdediger4: [''],
      middenvelder1: [''],
      middenvelder2: [''],
      middenvelder3: [''],
      aanvaller1: [''],
      aanvaller2: [''],
      aanvaller3: ['']
    })
    this._authenticateService.isLoggedin.subscribe(e => {
      if (localStorage.getItem('member') != null) {
        this.memberId = Number(localStorage.getItem('id'));
        this.dreamteamService.getDreamTeamWithSpelers(this.memberId).subscribe((res) => {
          this.dreamteam = res.dreamTeam;
          this.SelectedSpelers = res.spelers;
          let teller = 0;
          for (const field in this.soccerForm.controls) { 
            const control = this.soccerForm.get(field); 
            teller++;
            if (teller > 1) {
              control.setValue(this.SelectedSpelers[teller-2].id)
            }
          }
        })
        this.dreamteamService.getFavorieteSpelersByUserId(this.memberId).subscribe((result) => {
          this.Spelers = result;
          console.log(this.Spelers)
          this.Spelers.forEach(speler => {
            if (speler.positie == "Goalkeeper") {
              this.Doelmannen.push(speler)
            } else if (speler.positie.toLowerCase().includes("back") || speler.positie.includes("Defender")) {
              this.Verdedigers.push(speler)
            } else if (speler.positie.toLowerCase().includes("midfield")) {
              this.Middenverlders.push(speler)
            } else if (speler.positie == "Forward" || speler.positie == "Winger" || speler.positie.toLowerCase().includes("wing")) {
              this.Aanvallers.push(speler)
            }
          });
        })
      }
    })
  }

  dreamteam: Dreamteam;
  memberId: number;
  Spelers: Speler[];
  SelectedSpelers: Speler[];
  Doelmannen: Speler[] = [];
  Verdedigers: Speler[] = [];
  Middenverlders: Speler[] = [];
  Aanvallers: Speler[] = [];
  soccerForm: FormGroup;


  onSubmit() {
    if (this.soccerForm.get("teamNaam").value == '') {
      this.soccerForm.get("teamNaam").setValue(this.dreamteam.naam);
    }
    let playerids = [];
    playerids.push(this.soccerForm.get("doelman").value)
    playerids.push(this.soccerForm.get("verdediger1").value)
    playerids.push(this.soccerForm.get("verdediger2").value)
    playerids.push(this.soccerForm.get("verdediger3").value)
    playerids.push(this.soccerForm.get("verdediger4").value)
    playerids.push(this.soccerForm.get("middenvelder1").value)
    playerids.push(this.soccerForm.get("middenvelder2").value)
    playerids.push(this.soccerForm.get("middenvelder3").value)
    playerids.push(this.soccerForm.get("aanvaller1").value)
    playerids.push(this.soccerForm.get("aanvaller2").value)
    playerids.push(this.soccerForm.get("aanvaller3").value)
    
    let updated = new Dreamteam(this.soccerForm.get('teamNaam').value, this.dreamteam.userId, this.dreamteam.id, playerids)
    this.dreamteamService.updateDreamteam(this.dreamteam.id, updated).subscribe(() => {
      this.router.navigate(["dreamteam"]);
    });
  }
}
