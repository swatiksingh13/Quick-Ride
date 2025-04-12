package in.example.quick_ride.repositories;

import in.example.quick_ride.models.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RideRepository extends JpaRepository<Ride, Long> {
    @Override
    Optional<Ride> findById(Long rideId);

    @Override
    Ride save(Ride ride);
    //upsert => update + insert
}
