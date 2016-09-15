package org.kszawala.ref.db.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kszawala.ref.db.base.AbstractTest;
import org.kszawala.ref.db.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CarRepositoryIT extends AbstractTest {

	@Autowired private CarRepository repository;

	@Test
	public void contextLoads() {

		assertNotNull("Missing repository!", repository);
		final List<Car> names = repository.getCars();
		assertNotNull("No data received from repository!", names);

		assertThat(names.size()).isEqualTo(1);
	}

	@Test
	public void shouldCleanUpDBByDeletingAll() {

		assertFalse(repository.getCars().isEmpty());

		repository.clean();

		assertTrue(repository.getCars().isEmpty());
	}

	@Test
	public void shouldGenerateIdAutomatically() {

		final Car car = new Car();
		car.setMake("fiat");
		car.setModel("punto");

		assertNull(car.getId());
		repository.add(car);
		assertNotNull(car.getId());
	}
}
