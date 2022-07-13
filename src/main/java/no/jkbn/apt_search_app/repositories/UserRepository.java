package no.jkbn.apt_search_app.repositories;

import no.jkbn.apt_search_app.entities.OIDCUser;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<OIDCUser, Long> {
    OIDCUser findByUsername(String username);

}
