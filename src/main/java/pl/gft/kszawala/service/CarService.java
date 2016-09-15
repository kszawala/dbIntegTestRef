package pl.gft.kszawala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.gft.kszawala.model.Car;

@Service
public class CarService {

	@Autowired private GarageService garage;

	public boolean isBeingAttended(final Car c) {

		return this.garage.contains(c);
	}
}
