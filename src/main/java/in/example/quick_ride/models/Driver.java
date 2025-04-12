package in.example.quick_ride.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Driver extends User{

    @OneToMany(mappedBy = "driver")
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "driver")
    private List<Ride> rides;

}

/*
  1         M
DRIVER   VEHICLE   => 1:M
  1         1

     1          M
  DRIVER      RIDE => 1:M
     1          1

 */