package no.jkbn.apt_search_app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PlaceSearch {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OIDCUser owner;

    private String name;
    private double latitude;
    private double longitude;

    @ElementCollection(targetClass=Time.class)
    @CollectionTable(name = "travel_at", joinColumns = @JoinColumn(name = "place_search_id"))
    @Column(name = "time")
    private Set<Time> travelAt = new HashSet<>();
}
