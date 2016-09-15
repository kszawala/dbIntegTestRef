package pl.gft.kszawala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.gft.kszawala.model.Car;
import pl.gft.kszawala.service.CarService;

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
