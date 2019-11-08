import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-showtext',
  templateUrl: './showtext.component.html',
  styleUrls: ['./showtext.component.css']
})
export class ShowtextComponent implements OnInit {
  hellotext = 'Hallow';

  constructor() { }

  ngOnInit() {
  }

}
