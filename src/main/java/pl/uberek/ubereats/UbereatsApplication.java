package pl.uberek.ubereats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class UbereatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbereatsApplication.class, args);
	}

}
