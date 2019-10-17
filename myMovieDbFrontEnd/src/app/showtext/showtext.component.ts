import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-showtext',
  templateUrl: './showtext.component.html',
  styleUrls: ['./showtext.component.css']
})
export class ShowtextComponent implements OnInit {

  constructor() {
    var helloText = 'hallo ik ben "blij" hier te zijn';
  }

  ngOnInit() {
  }

}
