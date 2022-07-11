package no.jkbn.apt_search_app;


import no.jkbn.apt_search_app.entities.Place;
import no.jkbn.apt_search_app.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.rmi.ServerException;


public class AptController {
    PlaceRepository repository;

    @Autowired
    public void AppController(PlaceRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<String> addNewPlace (@RequestBody Place newPlace) throws ServerException {
        repository.save(newPlace);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
}
