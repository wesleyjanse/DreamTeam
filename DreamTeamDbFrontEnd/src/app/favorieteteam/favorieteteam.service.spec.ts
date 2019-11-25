import { TestBed } from '@angular/core/testing';

import { FavorieteteamService } from './favorieteteam.service';

describe('FavorieteteamService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FavorieteteamService = TestBed.get(FavorieteteamService);
    expect(service).toBeTruthy();
  });
});
