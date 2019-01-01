import { Component, OnInit } from '@angular/core';
import { CUSTOMERS } from '../mock/mock-customer-vehicles';
import { Customer } from '../beans/Customer';
import { Vehicle } from '../beans/Vehicle';
import { CustomerVehiclesService } from '../services/customer-vehicles/customer-vehicles.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  customers: Customer[] = [];

  searchCustomer: Customer = new Customer();
  searchVehicle: Vehicle = new Vehicle();

  vehicleStatus = ['All', 'CONNECTED', 'DISCONNECTED'];

  constructor(private customerService: CustomerVehiclesService) {
    // this.getCustomers();
  }

  ngOnInit() {
    this.getCustomers();
    this.searchCustomer.name = '';
    this.searchVehicle.status = 'All';
  }

  getCustomers(): void {
    this.customerService
      .getCustomers()
      .subscribe(customers => (this.customers = customers));
  }
}
