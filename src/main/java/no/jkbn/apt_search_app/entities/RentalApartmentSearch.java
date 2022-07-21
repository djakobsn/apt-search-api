package no.jkbn.apt_search_app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RentalApartmentSearch {

    public RentalApartmentSearch(OIDCUser owner, Set<PlaceSearch> place_searches) {
        this.owner = owner;
        this.place_searches = place_searches;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private OIDCUser owner;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<PlaceSearch> place_searches;

}
