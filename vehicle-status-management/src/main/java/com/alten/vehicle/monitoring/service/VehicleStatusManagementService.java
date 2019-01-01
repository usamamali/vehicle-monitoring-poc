/**
 * 
 */
package com.alten.vehicle.monitoring.service;

import static java.time.LocalDateTime.now;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alten.vehicle.monitoring.client.CustomerVehicleClient;
import com.alten.vehicle.monitoring.model.Customer;
import com.alten.vehicle.monitoring.model.Status;

/**
 * @author usama
 *
 */
@Service
public class VehicleStatusManagementService {

	@Autowired
	private CustomerVehicleClient customerVehicleClient;

	public List<Customer> findAll() {
		List<Customer> customers = customerVehicleClient.findAll();

		if (!CollectionUtils.isEmpty(customers)) {
			customers.stream()
					.flatMap(customer -> customer.getVehicles().stream())
					.forEach(vehicle -> {
						if (vehicle.getLastPulseTime() != null
								&& vehicle.getLastPulseTime()
										.isAfter(now().minusMinutes(1)))
							vehicle.setStatus(Status.Connected);
						else
							vehicle.setStatus(Status.Disconnected);
					});
		}

		return customers;
	}

}
