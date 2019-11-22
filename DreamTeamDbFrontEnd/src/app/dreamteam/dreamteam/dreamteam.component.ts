import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { DreamteamService } from '../dreamteam.service';
import { Dreamteam } from 'src/app/models/dreamteam.model';

@Component({
  selector: 'app-dreamteam',
  templateUrl: './dreamteam.component.html',
  styleUrls: ['./dreamteam.component.scss']
})
export class DreamteamComponent implements OnInit {

  constructor(private fb: FormBuilder, private dts: DreamteamService) { }

  ngOnInit() {

  }

  titleForm = this.fb.group({
    title: ['', [Validators.required, Validators.minLength(2)]]
  });

  submitted: Boolean = false;
  started: Boolean = false;


  onSubmit(){
    this.submitted = true;
    let newDreamteam = new Dreamteam(0, this.titleForm.get('title').value, 1)
    this.dts.addDreamTeam(newDreamteam).subscribe();
  }

  onBegin() {
    this.started = true;
  }

}
