package org.kszawala.ref.db.repository;
import org.kszawala.ref.db.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarJpaRepository extends JpaRepository<Car, Long> {

}
