/**
 * 
 */
package com.alten.vehicle.monitoring.client;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alten.vehicle.monitoring.model.Vehicle;

/**
 * @author usama
 *
 */
@FeignClient("vehicle-api")
public interface VehicleClient {

	@GetMapping("/api/vehicle")
	List<Vehicle> findAll();

	@PostMapping("/api/vehicle/{vehicleId}")
	Optional<Vehicle> pulse(@RequestParam String vehicleId);

}
