package pl.uberek.ubereats.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.uberek.ubereats.Entity.Guest;


@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {


}
