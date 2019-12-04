import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FavorieteSpelersComponent } from './favoriete-spelers.component';

describe('FavorieteSpelersComponent', () => {
  let component: FavorieteSpelersComponent;
  let fixture: ComponentFixture<FavorieteSpelersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FavorieteSpelersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FavorieteSpelersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
