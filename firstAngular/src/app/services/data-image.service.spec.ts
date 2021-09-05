import { TestBed } from '@angular/core/testing';

import { DataImageService } from './data-image.service';

describe('DataImageService', () => {
  let service: DataImageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DataImageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
