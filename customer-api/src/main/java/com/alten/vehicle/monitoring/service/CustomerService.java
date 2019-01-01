/**
 * 
 */
package com.alten.vehicle.monitoring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alten.vehicle.monitoring.model.Customer;
import com.alten.vehicle.monitoring.repo.CustomerRepository;

/**
 * @author usama
 *
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Optional<Customer> find(Long customerId) {

		if (null == customerId) {
			throw new IllegalArgumentException("customerId is missing");
		}

		return customerRepository.findById(customerId);
	}

}
