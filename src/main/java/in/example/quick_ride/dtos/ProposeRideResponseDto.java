package in.example.quick_ride.dtos;

import in.example.quick_ride.models.Ride;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProposeRideResponseDto {
    private Ride ride;
    private ResponseStatus responseStatus;
}
