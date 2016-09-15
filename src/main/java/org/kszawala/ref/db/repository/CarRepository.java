package org.kszawala.ref.db.repository;

import java.util.List;

import org.kszawala.ref.db.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
