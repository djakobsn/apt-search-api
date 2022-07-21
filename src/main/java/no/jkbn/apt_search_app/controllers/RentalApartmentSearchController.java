package no.jkbn.apt_search_app.controllers;

import lombok.RequiredArgsConstructor;
import no.jkbn.apt_search_app.entities.AptUser;
import no.jkbn.apt_search_app.entities.TravelSearch;
import no.jkbn.apt_search_app.entities.RentalApartmentSearch;
import no.jkbn.apt_search_app.repositories.RentalApartmentSearchRepository;
import no.jkbn.apt_search_app.security.AptUserService;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class RentalApartmentSearchController {
    private final RentalApartmentSearchRepository repository;
    private final AptUserService users;

    @GetMapping("/configure")
        RentalApartmentSearch getSearch(KeycloakAuthenticationToken keycloakAuthenticationToken) {
        AptUser owner = users.loadUserByUsername(keycloakAuthenticationToken.getName());
        return repository.findFirstOneByOwnerId(owner.getId());
    }

    @PostMapping("/configure")
    String saveSearch(KeycloakAuthenticationToken keycloakAuthenticationToken, @RequestBody Set<TravelSearch> placeSearches) {
        AptUser owner = users.loadUserByUsername(keycloakAuthenticationToken.getName());
        RentalApartmentSearch search = new RentalApartmentSearch(owner, placeSearches);
        repository.save(search);
        return "Success";
    }
}
