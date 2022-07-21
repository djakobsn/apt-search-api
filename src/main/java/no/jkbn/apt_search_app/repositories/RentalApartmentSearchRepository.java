package no.jkbn.apt_search_app.repositories;

import no.jkbn.apt_search_app.entities.RentalApartmentSearch;
import org.springframework.data.repository.CrudRepository;

public interface RentalApartmentSearchRepository extends CrudRepository<RentalApartmentSearch, Long> {

    public RentalApartmentSearch findFirstOneByOwnerId(Integer ownerId);
}
