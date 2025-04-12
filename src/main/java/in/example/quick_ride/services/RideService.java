package in.example.quick_ride.services;

import in.example.quick_ride.models.*;
import in.example.quick_ride.repositories.DriverRepository;
import in.example.quick_ride.repositories.RideRepository;
import in.example.quick_ride.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RideService {
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;
    private  RideRepository rideRepository;

    public RideService(RideRepository rideRepository, DriverRepository driverRepository, VehicleRepository vehicleRepository) {
        this.rideRepository = rideRepository;
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Ride proposeRide(String source, String destination,
                            Long driverId, Long vehicleId, int availableSeatCount) {
        Ride ride = new Ride();
        ride.setSource(source);
        ride.setDestination(destination);
        ride.setAvailableSeatCount(availableSeatCount);
        ride.setAmount(2500/availableSeatCount);

        Optional<Driver> optionalDriver = driverRepository.findById(driverId) ;
        Driver savedDriver = null;
        if(optionalDriver.isEmpty()) {
            Driver newDriver = new Driver();
            newDriver.setName("ABC");
            newDriver.setGender("Male");
            newDriver.setUserType(UserType.DRIVER);
            savedDriver = driverRepository.save(newDriver);
        } else{
            savedDriver = optionalDriver.get();
        }

        ride.setDriver(savedDriver);

        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
        Vehicle savedVehicle = null;
        if(optionalVehicle.isEmpty()) {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setName("SEDAN");
            newVehicle.setDriver(savedDriver);
            newVehicle.setVehicleType(VehicleType.SEDAN);
            newVehicle.setSeatCount(availableSeatCount+1);
            savedVehicle = vehicleRepository.save(newVehicle);
        }  else{
            savedVehicle = optionalVehicle.get();
        }
        ride.setVehicle(savedVehicle);

        return rideRepository.save(ride);
    }
}
