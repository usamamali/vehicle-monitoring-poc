/**
 * 
 */
package com.alten.vehicle.monitoring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alten.vehicle.monitoring.model.Vehicle;

/**
 * @author usama
 *
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
