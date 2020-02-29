import { TestBed } from '@angular/core/testing';

import { SubmitClaimServiceService } from './submit-claim-service.service';

describe('SubmitClaimServiceService', () => {
  let service: SubmitClaimServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubmitClaimServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
