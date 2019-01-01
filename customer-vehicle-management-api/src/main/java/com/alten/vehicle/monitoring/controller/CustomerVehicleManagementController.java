/**
 * 
 */
package com.alten.vehicle.monitoring.controller;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alten.vehicle.monitoring.model.Customer;
import com.alten.vehicle.monitoring.service.CustomerVehicleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author usama
 *
 */
@Api(value = "Customer API")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/customer")
public class CustomerVehicleManagementController {
	@Autowired
	private CustomerVehicleService customerVehicleService;

	@ApiOperation(value = "Get all customers")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> customers = customerVehicleService.findAll();
		if (customers.isEmpty()) {
			return noContent().build();
		}
		return ok(customers);
	}

	@ApiOperation(value = "Get customer by customer Id")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> find(
			@PathVariable("customerId") Long customerId) {
		return customerVehicleService.find(customerId).map(ResponseEntity::ok)
				.orElse(notFound().build());
	}

}
