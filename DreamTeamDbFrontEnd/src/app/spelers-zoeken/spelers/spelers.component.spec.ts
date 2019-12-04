import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpelersComponent } from './spelers.component';

describe('SpelersComponent', () => {
  let component: SpelersComponent;
  let fixture: ComponentFixture<SpelersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpelersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpelersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
