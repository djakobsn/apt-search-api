package no.jkbn.apt_search_app.entities.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class DetailedLocation {
    private String road;
    private Integer roadNumber;
    private String zipCode;

    @ElementCollection(targetClass = HashSet.class)
    private Set<String> units = new HashSet<>();
    private String municipality;

    @Embedded
    private Location location;

}
