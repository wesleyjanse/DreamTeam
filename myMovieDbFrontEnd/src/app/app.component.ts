import { Component } from '@angular/core';
import {ThemoviedbService} from "./themoviedb.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'myMovieDbFrontEnd';
  movie = undefined;
  constructor(private theMovieDbService: ThemoviedbService) {
    this.theMovieDbService.find('tt0110912')
      .subscribe(res => {this.movie = res;});
  }
}
