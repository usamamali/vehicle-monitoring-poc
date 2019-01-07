/**
 * 
 */

package com.alten.vehicle.monitoring.service;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.alten.vehicle.monitoring.client.CustomerVehicleClient;
import com.alten.vehicle.monitoring.model.Customer;
import com.alten.vehicle.monitoring.model.Status;
import com.alten.vehicle.monitoring.model.Vehicle;

/**
 * @author usama
 *
 */

@RunWith(SpringRunner.class)
public class VehicleStatusManagementServiceTest {

	@InjectMocks
	private VehicleStatusManagementService vehicleOwnerService;
	@Mock
	private CustomerVehicleClient customerVehicleClient;

	@Test
	public void shouldReturnEmptyIfNoCustomers() {

		when(customerVehicleClient.findAll()).thenReturn(emptyList());

		assertThat(vehicleOwnerService.findAll()).isEmpty();

		verify(customerVehicleClient, times(1)).findAll();
	}

	@Test
	public void shouldReturnEmptyIfNoCustomerWithThisIdExist() {

		when(customerVehicleClient.find("1")).thenReturn(Optional.empty());

		assertThat(customerVehicleClient.find("1")).isEmpty();

		verify(customerVehicleClient, times(1)).find("1");
	}

	@Test
	public void shouldReturnFullListOfCustomers() {

		List<Customer> customers = buildCustomers();

		when(customerVehicleClient.findAll()).thenReturn(customers);

		assertThat(vehicleOwnerService.findAll()).isEqualTo(customers);

		verify(customerVehicleClient, times(1)).findAll();
	}

	@Test
	public void shouldReturnCustomerIfCustomerExists() {

		Customer customer = Customer.builder().name("Kalles Grustransporter AB")
				.address("Cementvägen 8,").id(1L).build();

		when(customerVehicleClient.find("1")).thenReturn(Optional.of(customer));

		assertThat(customerVehicleClient.find("1"))
				.isEqualTo(Optional.of(customer));

		verify(customerVehicleClient, times(1)).find("1");
	}

	private List<Customer> buildCustomers() {

		Vehicle.builder().id("YS2R4X20005387949").registrationNumber("MNO345")
				.status(Status.DISCONNECTED).build();
		return asList(
				Customer.builder().name("Kalles Grustransporter AB")
						.address("Cementvägen 8,").vehicles(asList(

								Vehicle.builder().id("VLUR4X20009093588")
										.registrationNumber("DEF456")
										.status(Status.DISCONNECTED).build(),
								Vehicle.builder().id("VLUR4X20009048066")
										.registrationNumber("GHI789")
										.status(Status.CONNECTED).build()))
						.build(),

				Customer.builder().name("Johans Bulk AB")
						.address("Balkvägen 12, 222")
						.vehicles(asList(
								Vehicle.builder().id("YS2R4X20005388011")
										.registrationNumber("JKL012")
										.status(Status.CONNECTED).build(),
								Vehicle.builder().id("YS2R4X20005387949")
										.registrationNumber("MNO345")
										.status(Status.DISCONNECTED).build()))
						.build());
	}

}
