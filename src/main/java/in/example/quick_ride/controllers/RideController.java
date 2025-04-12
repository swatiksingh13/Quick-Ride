package in.example.quick_ride.controllers;

import in.example.quick_ride.dtos.ProposeRideRequestDto;
import in.example.quick_ride.dtos.ProposeRideResponseDto;
import in.example.quick_ride.dtos.ResponseStatus;
import in.example.quick_ride.models.Ride;
import in.example.quick_ride.services.RideService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {
    private RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping("/create")
    public ProposeRideResponseDto proposeRide(@RequestBody ProposeRideRequestDto proposeRideRequestDto) {
        ProposeRideResponseDto proposeRideResponseDto = new ProposeRideResponseDto();

        try {
            Ride ride = rideService.proposeRide(
                    proposeRideRequestDto.getSource(),
                    proposeRideRequestDto.getDestination(),
                    proposeRideRequestDto.getDriverId(),
                    proposeRideRequestDto.getVehicleId(),
                    proposeRideRequestDto.getAvailableSeatCount()
            );
            proposeRideResponseDto.setRide(ride);
            proposeRideResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            System.out.println("Ride not found: reason  " + e.getMessage());
            proposeRideResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return proposeRideResponseDto;
    }
}
