import { TestBed } from '@angular/core/testing';

import { SpelersZoekenService } from './spelers-zoeken.service';

describe('SpelersZoekenService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SpelersZoekenService = TestBed.get(SpelersZoekenService);
    expect(service).toBeTruthy();
  });
});
