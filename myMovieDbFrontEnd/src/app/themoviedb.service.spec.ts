import { TestBed } from '@angular/core/testing';

import { ThemoviedbService } from './themoviedb.service';

describe('ThemoviedbService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ThemoviedbService = TestBed.get(ThemoviedbService);
    expect(service).toBeTruthy();
  });
});
