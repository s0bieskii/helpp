package pl.uberek.ubereats.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uberek.ubereats.Entity.Client;
import pl.uberek.ubereats.Service.ClientService;
import pl.uberek.ubereats.Service.GuestService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;
    @Autowired
    GuestService guestService;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    //Zwracać response entity
    @GetMapping("/ok/{id}")
    public Client getByIdOk(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @GetMapping("")
    public List<Client> getClients() {
        return clientService.findAll();
    }

    @PostMapping("/ok")
    public Client saveClients(Client clients) {
        return clientService.saveClient(clients);
    }

    @PostMapping("")
    public List<Client> saveClients(@RequestBody List<Client> clients) {
        return clientService.saveAll(clients);
    }

}
