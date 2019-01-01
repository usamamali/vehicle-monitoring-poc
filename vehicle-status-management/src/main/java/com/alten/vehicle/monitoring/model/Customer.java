/**
 * 
 */
package com.alten.vehicle.monitoring.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author usama
 *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

	private Long id;
	private String name;
	private String address;
	private List<Vehicle> vehicles;

}
