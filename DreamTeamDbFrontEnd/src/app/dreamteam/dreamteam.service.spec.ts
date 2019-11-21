import { TestBed } from '@angular/core/testing';

import { DreamteamService } from './dreamteam.service';

describe('DreamteamService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DreamteamService = TestBed.get(DreamteamService);
    expect(service).toBeTruthy();
  });
});
