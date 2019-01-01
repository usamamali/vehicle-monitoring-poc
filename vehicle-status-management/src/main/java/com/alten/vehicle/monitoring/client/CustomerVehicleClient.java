/**
 * 
 */
package com.alten.vehicle.monitoring.client;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.alten.vehicle.monitoring.model.Customer;

/**
 * @author usama
 *
 */
@FeignClient("customer-vehicle-management-api")
public interface CustomerVehicleClient {

	@GetMapping("/api/customer")
	List<Customer> findAll();

	@GetMapping("/api/customer/{customerId}")
	Optional<Customer> find(@PathVariable("customerId") String customerId);

}
