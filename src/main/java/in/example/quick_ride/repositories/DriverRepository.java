package in.example.quick_ride.repositories;

import in.example.quick_ride.models.Driver;
import in.example.quick_ride.models.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Override
    Optional<Driver> findById(Long driverId);

}
