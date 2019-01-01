/**
 * 
 */
package com.alten.vehicle.monitoring.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
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
public class Customer {

	@Id
	private Long id;
	@Transient
	private String name;
	@Transient
	private String address;
	@OneToMany()
	@JoinColumn(name = "customer_id")
	@Singular
	private List<Vehicle> vehicles;

}
