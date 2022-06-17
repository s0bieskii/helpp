package pl.uberek.ubereats.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.uberek.ubereats.Enums.AccountType;

@NoArgsConstructor
@Getter
@Setter
public class GuestCreateDto {

    private String email;
    private Address address;
    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.GUEST;
    private String password;
    private String phoneNumber;
}
