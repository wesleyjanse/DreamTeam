import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-dreamteam',
  templateUrl: './dreamteam.component.html',
  styleUrls: ['./dreamteam.component.scss']
})
export class DreamteamComponent implements OnInit {

  constructor(private fb: FormBuilder) { }

  ngOnInit() {

  }

  titleForm = this.fb.group({
    title: ['', [Validators.required, Validators.minLength(2)]]
  });

  submitted: Boolean = false;
  started: Boolean = false;


  onSubmit(){
    this.submitted = true;
  }

  onBegin() {
    this.started = true;
  }

}
