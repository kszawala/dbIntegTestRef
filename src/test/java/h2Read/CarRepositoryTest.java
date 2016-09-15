package h2Read;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.gft.kszawala.model.Car;
import pl.gft.kszawala.repository.CarJpaRepository;
import pl.gft.kszawala.repository.CarRepository;

@RunWith(MockitoJUnitRunner.class)
public class CarRepositoryTest {

	@Mock private CarJpaRepository privRepo;

	@InjectMocks private CarRepository publicRepo;

	@Test
	public void add_car_entity_passed_to_repository() {

		final Car car = mock(Car.class);
		publicRepo.add(car);
		verify(privRepo).save(eq(car));
		assertThat(car.getId() == null);
	}

}
