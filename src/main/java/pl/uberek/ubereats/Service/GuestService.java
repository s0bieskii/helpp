package pl.uberek.ubereats.Service;

import java.util.NoSuchElementException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.uberek.ubereats.Entity.Guest;
import pl.uberek.ubereats.Entity.GuestCreateDto;
import pl.uberek.ubereats.Entity.GuestDto;
import pl.uberek.ubereats.Repository.GuestRepository;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GuestService {

    @Autowired
    GuestRepository guestRepository;

    @Bean
    public GuestService getGuestService(){
        return new GuestService();
    }

    public List<? extends Guest> saveAsGuestsWhileAddingOtherAccountTypes(List<? extends Guest> guests) {
        for (Guest guest : guests) {
            Guest newGuest = Guest.builder()
                    .id(guest.getId())
                    .email(guest.getEmail())
                    .address(guest.getAddress())
                    .accountType(guest.getAccountType())
                    .password(guest.getPassword())
                    .phoneNumber(guest.getPhoneNumber())
                    .build();
            guestRepository.save(newGuest);
        }
        return guests;
    }


    public Guest save(GuestCreateDto guestCreateDto) {
        Guest guest = new Guest();

        guest.setEmail(guestCreateDto.getEmail());
        guest.setAddress(guestCreateDto.getAddress());
        guest.setAccountType(guestCreateDto.getAccountType());
        guest.setPhoneNumber(guestCreateDto.getPhoneNumber());
        return guestRepository.save(guest);
    }

    public GuestDto findById(Long id) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("guest with id: " + id + " not found"));
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guest.getId());
        guestDto.setAddress(guest.getAddress());
        guestDto.setAccountType(guest.getAccountType());
        guestDto.setEmail(guest.getEmail());
        return guestDto;
    }
}
