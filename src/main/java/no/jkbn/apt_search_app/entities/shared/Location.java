package no.jkbn.apt_search_app.entities.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Location {
    private String name;
    private Long latitude;
    private Long longitude;
}
