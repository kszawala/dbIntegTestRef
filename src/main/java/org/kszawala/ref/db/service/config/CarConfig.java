package org.kszawala.ref.db.service.config;

import org.kszawala.ref.db.service.GarageService;
import org.kszawala.ref.db.service.GarageServiceImpl;
import org.kszawala.ref.db.service.GarageServiceMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class CarConfig {

	@Bean
	public GarageService createGarageService() {

		return new GarageServiceImpl();
	}

	@Bean
	@Profile("mock")
	@Primary
	public GarageService createGarageServiceMock() {

		return new GarageServiceMock();
	}
}
