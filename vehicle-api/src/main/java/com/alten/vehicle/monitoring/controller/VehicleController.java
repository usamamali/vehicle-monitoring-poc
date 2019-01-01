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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alten.vehicle.monitoring.model.Vehicle;
import com.alten.vehicle.monitoring.service.VehicleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author usama
 *
 */
@Api(value = "Vehicle API")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	@ApiOperation(value = "Get all vehicles")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public ResponseEntity<List<Vehicle>> findAll() {
		List<Vehicle> vehicles = vehicleService.findAll();
		if (vehicles.isEmpty()) {
			return noContent().build();
		}
		return ok(vehicles);
	}

	@ApiOperation(value = "Get vehicle by vehicle Id")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{vehicleId}")
	public ResponseEntity<Vehicle> find(
			@PathVariable("vehicleId") String vehicleId) {
		return vehicleService.find(vehicleId).map(ResponseEntity::ok)
				.orElse(notFound().build());
	}

	@ApiOperation(value = "Vehcile pings montitoring system")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/{vehicleId}")
	public ResponseEntity<Vehicle> pulse(
			@PathVariable("vehicleId") String vehicleId) {
		return vehicleService.pulse(vehicleId).map(ResponseEntity::ok)
				.orElse(notFound().build());
	}

}
