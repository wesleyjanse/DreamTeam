import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DreamteameditComponent } from './dreamteamedit.component';

describe('DreamteameditComponent', () => {
  let component: DreamteameditComponent;
  let fixture: ComponentFixture<DreamteameditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DreamteameditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DreamteameditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
