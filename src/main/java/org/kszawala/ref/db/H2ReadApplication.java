package org.kszawala.ref.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableAutoConfiguration
// @EnableJpaRepositories(basePackageClasses = { CarJpaRepository.class })
public class H2ReadApplication {

	public static void main(final String[] args) {

		SpringApplication.run(H2ReadApplication.class, args);
	}
}
