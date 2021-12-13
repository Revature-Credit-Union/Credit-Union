import { TestBed } from '@angular/core/testing';

import { TransactonSummaryService } from './transaction-summary.service';

describe('TransactonSummaryService', () => {
  let service: TransactonSummaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransactonSummaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
