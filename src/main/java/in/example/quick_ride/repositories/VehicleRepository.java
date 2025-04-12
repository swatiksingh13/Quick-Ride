package in.example.quick_ride.repositories;

import in.example.quick_ride.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Override
    Optional<Vehicle> findById(Long vehicleId);
}
