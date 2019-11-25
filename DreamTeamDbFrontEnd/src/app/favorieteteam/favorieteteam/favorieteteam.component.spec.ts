import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FavorieteteamComponent } from './favorieteteam.component';

describe('FavorieteteamComponent', () => {
  let component: FavorieteteamComponent;
  let fixture: ComponentFixture<FavorieteteamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FavorieteteamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FavorieteteamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
