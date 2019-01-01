/**
 * 
 */
package com.alten.vehicle.monitoring.service;

import static java.time.LocalDateTime.now;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.vehicle.monitoring.model.Status;
import com.alten.vehicle.monitoring.model.Vehicle;
import com.alten.vehicle.monitoring.repo.VehicleRepository;

/**
 * @author usama
 *
 */
@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	public Optional<Vehicle> find(String vehicleId) {

		if (StringUtils.isBlank(vehicleId)) {
			throw new IllegalArgumentException("vehicleId is missing");
		}

		return vehicleRepository.findById(vehicleId);
	}

	/**
	 * connected vehicle sends pulse periodically
	 * 
	 * @param vehicleId
	 * @return
	 */
	public Optional<Vehicle> pulse(String vehicleId) {
		if (StringUtils.isBlank(vehicleId)) {
			throw new IllegalArgumentException("vehicleId is missing");
		}

		return ofNullable(vehicleRepository.findById(vehicleId).map(vehicle -> {
			vehicle.setStatus(Status.Connected);
			vehicle.setLastPulseTime(now());
			vehicleRepository.save(vehicle);
			return vehicle;
		}).orElse(null));
	}

}
