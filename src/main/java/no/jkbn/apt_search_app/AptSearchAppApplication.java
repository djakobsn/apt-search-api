package no.jkbn.apt_search_app;

import no.jkbn.apt_search_app.repositories.PlaceRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class AptSearchAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AptSearchAppApplication.class, args);
    }

    @Bean
    ApplicationRunner init(PlaceRepository repository) {
        return null;
    }

}
