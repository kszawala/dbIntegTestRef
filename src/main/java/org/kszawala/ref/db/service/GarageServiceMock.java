package org.kszawala.ref.db.service;

import org.kszawala.ref.db.model.Car;

import lombok.extern.java.Log;

@Log
public class GarageServiceMock implements GarageService {

	@Override
	public boolean contains(final Car c) {

		log.info("checking that " + c.getModel() + " is in garage...");
		return false;
	}
}
