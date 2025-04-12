package in.example.quick_ride.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicle extends BaseModel {
    private String name;
    private String number;

    @Enumerated(EnumType.ORDINAL)
    private VehicleType vehicleType;
    private int seatCount;
    @ManyToOne
    private Driver driver;
}
