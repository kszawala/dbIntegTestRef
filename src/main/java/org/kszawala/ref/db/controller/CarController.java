package org.kszawala.ref.db.controller;

import org.kszawala.ref.db.model.Car;
import org.kszawala.ref.db.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired private CarService service;

	@RequestMapping("/cars")
	@ResponseBody
	public Car getCar() {

		final Car c = new Car();
		c.setMake("Honda");
		c.setModel("Jazz");
		final boolean isAttended = service.isBeingAttended(c);
		c.setInGarage(isAttended);

		return c;
	}
}
