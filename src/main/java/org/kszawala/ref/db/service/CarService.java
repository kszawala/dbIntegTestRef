package org.kszawala.ref.db.service;

import org.kszawala.ref.db.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

	@Autowired private GarageService garage;

	public boolean isBeingAttended(final Car c) {

		return this.garage.contains(c);
	}
}
