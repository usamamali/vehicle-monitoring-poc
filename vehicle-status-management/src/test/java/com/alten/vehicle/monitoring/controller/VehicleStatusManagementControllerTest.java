/**
 * 
 */
package com.alten.vehicle.monitoring.controller;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//import  org.springframework.test.web.servlet.*;

import com.alten.vehicle.monitoring.model.Customer;
import com.alten.vehicle.monitoring.model.Status;
import com.alten.vehicle.monitoring.model.Vehicle;
import com.alten.vehicle.monitoring.service.VehicleStatusManagementService;
/**
 * @author usama
 *
 */
@RunWith(SpringRunner.class)
public class VehicleStatusManagementControllerTest {

	@InjectMocks
	private VehicleStatusManagementController vehicleStatusManagementController;

	private MockMvc mvc;

	@Mock
	private VehicleStatusManagementService vehicleStatusManagementService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		mvc = MockMvcBuilders.standaloneSetup(vehicleStatusManagementController)
				.build();

	}

	@Test
	public void shouldReturn204IfNoRecordReturned() throws Exception {

		when(vehicleStatusManagementService.findAll()).thenReturn(emptyList());

		mvc.perform(
				get("/api/customer").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isNoContent());

		verify(vehicleStatusManagementService, times(1)).findAll();
	}

	@Test
	public void shouldReturn200AndCustomersWithThierVehicles()
			throws Exception {

		List<Customer> customers = buildCustomers();

		when(vehicleStatusManagementService.findAll()).thenReturn(customers);

		mvc.perform(
				get("/api/customer").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(
						jsonPath("$.[0].name", is("Kalles Grustransporter AB")))
				.andExpect(jsonPath("$.[1].address", is("Balkvägen 12, 222")));

		verify(vehicleStatusManagementService, times(1)).findAll();
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
