import { TestBed } from '@angular/core/testing';

import { FavorieteSpelersService } from './favoriete-spelers.service';

describe('FavorieteSpelersService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FavorieteSpelersService = TestBed.get(FavorieteSpelersService);
    expect(service).toBeTruthy();
  });
});
