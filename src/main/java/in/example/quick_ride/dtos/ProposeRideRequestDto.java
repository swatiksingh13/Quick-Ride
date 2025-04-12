package in.example.quick_ride.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProposeRideRequestDto {
    private String source;
    private String destination;
    private Long driverId;
    private Long vehicleId;
    private int availableSeatCount;
}
