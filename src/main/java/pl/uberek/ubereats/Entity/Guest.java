package pl.uberek.ubereats.Entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;
import pl.uberek.ubereats.Enums.AccountType;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @OneToOne
    private Address address;
    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.GUEST;
    @Nullable private String password;
    private String phoneNumber;

}
