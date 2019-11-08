import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowtextComponent } from './showtext.component';

describe('ShowtextComponent', () => {
  let component: ShowtextComponent;
  let fixture: ComponentFixture<ShowtextComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowtextComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowtextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
