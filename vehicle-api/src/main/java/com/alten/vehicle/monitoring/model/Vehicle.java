/**
 * 
 */
package com.alten.vehicle.monitoring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author usama
 *
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Vehicle {
	@Id
	private String id;
	@Column(name = "REG_NUM")
	private String registrationNumber;
	private Status status;
	private LocalDateTime lastPulseTime;

	public Vehicle(String id, String registrationNumber) {
		super();
		this.id = id;
		this.registrationNumber = registrationNumber;
	}

}
