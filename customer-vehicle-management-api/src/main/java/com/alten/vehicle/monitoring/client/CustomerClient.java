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
@FeignClient("customer-api")
public interface CustomerClient {

	@GetMapping("/api/customer")
	List<Customer> findAll();

	@GetMapping("/api/customer/{customerId}")
	Optional<Customer> find(@PathVariable("customerId") Long customerId);

}
