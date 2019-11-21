import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DreamteamComponent } from './dreamteam.component';

describe('DreamteamComponent', () => {
  let component: DreamteamComponent;
  let fixture: ComponentFixture<DreamteamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DreamteamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DreamteamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
