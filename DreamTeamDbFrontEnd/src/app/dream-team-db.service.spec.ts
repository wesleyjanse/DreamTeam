import { TestBed } from '@angular/core/testing';

import { DreamTeamDbService } from './dream-team-db.service';

describe('DreamTeamDbService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DreamTeamDbService = TestBed.get(DreamTeamDbService);
    expect(service).toBeTruthy();
  });
});
