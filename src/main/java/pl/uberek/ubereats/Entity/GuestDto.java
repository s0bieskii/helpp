package pl.uberek.ubereats.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uberek.ubereats.Enums.AccountType;

@Setter
@Getter
@NoArgsConstructor
public class GuestDto {

    private Long id;
    private String email;
    private Address address;
    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.GUEST;
}
