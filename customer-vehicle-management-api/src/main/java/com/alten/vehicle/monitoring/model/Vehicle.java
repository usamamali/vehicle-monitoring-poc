/**
 * 
 */
package com.alten.vehicle.monitoring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Transient
	private String registrationNumber;
	@Transient
	private Status status;
	@Transient
	private LocalDateTime lastPulseTime;
	@JsonIgnore
	@Column(name = "customer_id")
	private Long customerId;

}
