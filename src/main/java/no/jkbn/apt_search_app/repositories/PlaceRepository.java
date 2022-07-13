package no.jkbn.apt_search_app.repositories;

import no.jkbn.apt_search_app.entities.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PostAuthorize;

// https://docs.spring.io/spring-security/reference/servlet/integrations/data.html
//public interface MessageRepository extends PagingAndSortingRepository<Message,Long> {
//@Repository
//    @Query("select m from Message m where m.to.id = ?#{ principal?.id }")
//    Page<Message> findInbox(Pageable pageable);
//}
@PostAuthorize("principal.id == returnObject.owner_id")
@RepositoryRestResource()
public interface PlaceRepository extends CrudRepository<Place, Integer> {

}