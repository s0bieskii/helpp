package pl.uberek.ubereats.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Client extends Guest{

    private String firstName;
    private String lastName;
    private String cardNumber;
    private Boolean isPremium = Boolean.FALSE;
    private Double walletBalance = 0.0;

}
