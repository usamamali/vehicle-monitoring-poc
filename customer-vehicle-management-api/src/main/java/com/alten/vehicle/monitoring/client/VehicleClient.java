/**
 * 
 */
package com.alten.vehicle.monitoring.client;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.alten.vehicle.monitoring.model.Vehicle;

/**
 * @author usama
 *
 */
@FeignClient("vehicle-api")
public interface VehicleClient {

	@GetMapping("/api/vehicle")
	List<Vehicle> findAll();

	@GetMapping("/api/vehicle/{vehicleId}")
	Optional<Vehicle> find(@PathVariable("vehicleId") String vehicleId);

}
