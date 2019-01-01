/**
 * 
 */
package com.alten.vehicle.monitoring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.vehicle.monitoring.client.CustomerClient;
import com.alten.vehicle.monitoring.client.VehicleClient;
import com.alten.vehicle.monitoring.model.Customer;
import com.alten.vehicle.monitoring.repo.CustomerVehicleRepository;

/**
 * @author usama
 *
 */
@Service
public class CustomerVehicleService {

	@Autowired
	private CustomerVehicleRepository customerVehicleRepository;

	@Autowired
	private CustomerClient customerClient;

	@Autowired
	private VehicleClient vehicleClient;

	public List<Customer> findAll() {

		List<Customer> customers = customerVehicleRepository.findAll();

		// get customers
		customers.stream().forEach(
				customer -> customerClient.find(customer.getId()).map(cust -> {
					customer.setName(cust.getName());
					customer.setAddress(cust.getAddress());
					return customer;
				}).orElse(null));

		// get vehicles
		customers.stream().flatMap(customer -> customer.getVehicles().stream())
				.forEach(vehicle -> vehicleClient.find(vehicle.getId())
						.map(veh -> {
							vehicle.setStatus(veh.getStatus());
							vehicle.setLastPulseTime(veh.getLastPulseTime());
							vehicle.setRegistrationNumber(
									veh.getRegistrationNumber());
							return vehicle;
						}).orElse(null));

		return customers;
	}

	public Optional<Customer> find(Long customerId) {
		if (null == customerId) {
			throw new IllegalArgumentException("customerId is missing");
		}

		Optional<Customer> customer = customerVehicleRepository
				.findById(customerId);

		if (customer.isPresent()) {
			// get customer
			customerClient.find(customer.get().getId()).map(cust -> {
				customer.get().setName(cust.getName());
				customer.get().setAddress(cust.getAddress());
				return cust;
			}).orElse(null);

			// get vehicles
			customer.get().getVehicles().stream().forEach(
					vehicle -> vehicleClient.find(vehicle.getId()).map(veh -> {
						vehicle.setStatus(veh.getStatus());
						vehicle.setLastPulseTime(veh.getLastPulseTime());
						vehicle.setRegistrationNumber(
								veh.getRegistrationNumber());
						return vehicle;
					}).orElse(null));
		}

		return customer;
	}

	public Customer addCustomer(Customer customer) {
		if (null == customer) {
			throw new IllegalArgumentException("customer is missing");
		}

		return customerVehicleRepository.save(customer);

	}

}
