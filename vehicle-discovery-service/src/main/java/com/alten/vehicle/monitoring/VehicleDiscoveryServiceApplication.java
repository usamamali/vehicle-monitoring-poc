package com.alten.vehicle.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class VehicleDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleDiscoveryServiceApplication.class, args);
	}
}
