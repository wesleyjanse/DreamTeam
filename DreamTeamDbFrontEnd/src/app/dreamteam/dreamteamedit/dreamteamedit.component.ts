import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { DreamteamService } from '../dreamteam.service';

@Component({
  selector: 'app-dreamteamedit',
  templateUrl: './dreamteamedit.component.html',
  styleUrls: ['./dreamteamedit.component.scss']
})
export class DreamteameditComponent implements OnInit {

  constructor(private fb: FormBuilder, private dreamteamService: DreamteamService) { 
    this.dreamteamService.getFavorieteSpelersByUserId(1).subscribe((result) => {
      console.log(result);
    })
  }

  ngOnInit() {
  }

  Doelmannen: any = ['Vermeer', 'Casillas']

  soccerForm = this.fb.group({
    teamNaam: [''],
    doelman: ['']
  })

  onSubmit(){
    console.log(this.soccerForm.get("doelman").value)
  }
}
