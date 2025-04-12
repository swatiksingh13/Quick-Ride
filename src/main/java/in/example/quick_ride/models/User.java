package in.example.quick_ride.models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    private String gender;
    private double rating;

    @Enumerated(EnumType.ORDINAL)
    private UserType userType;

}

