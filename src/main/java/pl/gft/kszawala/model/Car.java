package pl.gft.kszawala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cars")
public class Car {

	@Getter @Id @GeneratedValue private Long id;

	@Setter @Getter private String make;
	@Setter @Getter private String model;
	@Setter @Getter private boolean isInGarage;
}
