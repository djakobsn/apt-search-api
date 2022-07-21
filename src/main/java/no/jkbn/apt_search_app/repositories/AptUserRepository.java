package no.jkbn.apt_search_app.repositories;

import no.jkbn.apt_search_app.entities.AptUser;
import org.springframework.data.repository.CrudRepository;


public interface AptUserRepository extends CrudRepository<AptUser, Long> {
    AptUser findByUsername(String username);

}
