package pl.gft.kszawala.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.gft.kszawala.model.Car;

@Repository
public interface CarJpaRepository extends JpaRepository<Car, Long> {

}
