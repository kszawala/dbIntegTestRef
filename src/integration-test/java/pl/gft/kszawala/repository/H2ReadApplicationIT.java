package pl.gft.kszawala.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import pl.gft.kszawala.base.AbstractTest;
import pl.gft.kszawala.model.Car;

@RunWith(SpringRunner.class)
public class H2ReadApplicationIT extends AbstractTest {

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
