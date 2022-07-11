package no.jkbn.apt_search_app.repositories;

import no.jkbn.apt_search_app.entities.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface PlaceRepository extends CrudRepository<Place, Integer> {

}