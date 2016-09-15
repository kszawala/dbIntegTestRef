package pl.gft.kszawala.service;

import lombok.extern.java.Log;
import pl.gft.kszawala.model.Car;

@Log
public class GarageServiceMock implements GarageService {

	@Override
	public boolean contains(final Car c) {

		log.info("checking that " + c.getModel() + " is in garage...");
		return false;
	}
}
