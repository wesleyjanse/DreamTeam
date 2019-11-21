import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../security/authenticate.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {
  spelers: any;

  constructor(private _authenticateService: AuthenticateService) {
    this._authenticateService.getTest().subscribe(result => {
      //console.log(result);
      this.spelers = result;
      console.log(this.spelers);
    }, error =>  {
      alert(error);
    });
   }

  ngOnInit() {
  }

}
