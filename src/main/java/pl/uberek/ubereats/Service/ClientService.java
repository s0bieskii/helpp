package pl.uberek.ubereats.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import pl.uberek.ubereats.Entity.Client;
import pl.uberek.ubereats.Repository.ClientRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    //Obsługa wyjątku
    public Client findById(@PathVariable Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("guest with id: " + id + " not found"));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public List<Client> saveAll(List<Client> clients) {
        return clientRepository.saveAll(clients);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
