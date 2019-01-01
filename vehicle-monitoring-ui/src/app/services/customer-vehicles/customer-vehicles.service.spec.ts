import { TestBed } from '@angular/core/testing';

import { CustomerVehiclesService } from './customer-vehicles.service';

describe('CustomerVehiclesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerVehiclesService = TestBed.get(CustomerVehiclesService);
    expect(service).toBeTruthy();
  });
});
