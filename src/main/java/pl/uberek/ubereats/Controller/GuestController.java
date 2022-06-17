package pl.uberek.ubereats.Controller;


import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uberek.ubereats.Entity.GuestCreateDto;
import pl.uberek.ubereats.Entity.GuestDto;
import pl.uberek.ubereats.Repository.GuestRepository;
import pl.uberek.ubereats.Entity.Guest;

import java.util.List;
import java.util.NoSuchElementException;
import pl.uberek.ubereats.Service.GuestService;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    GuestRepository guestRepository;
    @Autowired
    GuestService guestService;

    @PostMapping("")
    public List<Guest> saveGuests(@RequestBody List<Guest> guests){
        return guestRepository.saveAll(guests);
    }

    @PostMapping("/ok")
    public ResponseEntity saveGuests(@RequestBody GuestCreateDto guests){
        Guest guest = guestService.save(guests);
        return ResponseEntity.created(URI.create("http://localhost:8080/guests/" + guest.getId())).build();
    }

    @GetMapping("/ok/{id}")
    public ResponseEntity<GuestDto> getOkGuest(@PathVariable Long id){
        return ResponseEntity.ok(guestService.findById(id));
    }

    @GetMapping("")
    public List<Guest> getGuests(){
        return guestRepository.findAll();
    }


    //To spoko warto dodać global @ControllerAdvice
    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable Long id){
        return guestRepository.findById(id)
                        .orElseThrow(() -> new NoSuchElementException("guest with id: " + id + " not found"));
    }

}
