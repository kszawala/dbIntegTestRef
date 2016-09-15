package pl.gft.kszawala.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.gft.kszawala.model.Car;

@Repository
public class CarRepository {

	@Autowired private CarJpaRepository repository;

	public List<Car> getCars() {

		return repository.findAll();
	}

	public void add(final Car c) {

		repository.save(c);
	}

	public void clean() {

		repository.deleteAll();
	}
}
