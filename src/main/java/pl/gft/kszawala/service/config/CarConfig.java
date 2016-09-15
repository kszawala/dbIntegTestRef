package pl.gft.kszawala.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import pl.gft.kszawala.service.GarageService;
import pl.gft.kszawala.service.GarageServiceImpl;
import pl.gft.kszawala.service.GarageServiceMock;

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
