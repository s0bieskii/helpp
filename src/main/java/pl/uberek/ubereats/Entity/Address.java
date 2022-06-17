package pl.uberek.ubereats.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    String zip_code;
    String city;
    String street;
    String country;

}
