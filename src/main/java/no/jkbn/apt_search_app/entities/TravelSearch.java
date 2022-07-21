package no.jkbn.apt_search_app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.jkbn.apt_search_app.entities.shared.Location;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TravelSearch {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private Location location;

    @ElementCollection(targetClass=Time.class)
    @CollectionTable(name = "travel_at", joinColumns = @JoinColumn(name = "place_search_id"))
    @Column(name = "time")
    private Set<Date> travelAt = new HashSet<>();

    private Integer expectedDuration;
}
