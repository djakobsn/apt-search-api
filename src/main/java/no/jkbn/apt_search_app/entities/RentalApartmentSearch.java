package no.jkbn.apt_search_app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import no.jkbn.apt_search_app.entities.shared.EnrichedListing;
import no.jkbn.apt_search_app.entities.shared.SearchResult;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RentalApartmentSearch {

    public RentalApartmentSearch(AptUser owner, Set<TravelSearch> travelSearches) {
        this.owner = owner;
        this.travelSearches = travelSearches;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private AptUser owner;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<TravelSearch> travelSearches;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<SearchResult> searchResults;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<EnrichedListing> enrichedResults;

}
