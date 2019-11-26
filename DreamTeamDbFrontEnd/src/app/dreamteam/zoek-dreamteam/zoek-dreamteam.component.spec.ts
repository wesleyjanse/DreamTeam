import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZoekDreamteamComponent } from './zoek-dreamteam.component';

describe('ZoekDreamteamComponent', () => {
  let component: ZoekDreamteamComponent;
  let fixture: ComponentFixture<ZoekDreamteamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZoekDreamteamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZoekDreamteamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
