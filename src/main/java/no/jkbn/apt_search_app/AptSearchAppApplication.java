package no.jkbn.apt_search_app;

import no.jkbn.apt_search_app.repositories.RentalApartmentSearchRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AptSearchAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AptSearchAppApplication.class, args);
    }

    @Bean
    ApplicationRunner init(RentalApartmentSearchRepository repository) {
        return null;
    }

}
