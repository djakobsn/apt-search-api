package no.jkbn.apt_search_app.entities.shared;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EnrichedListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // We need this to be a Set<Location, Long> (wanted location, travel duration)
    private int shortestDuration;

    @OneToOne
    private SearchResult searchResult;

    @Embedded
    private DetailedLocation detailedLocation;

    private Boolean ignored;
    private Boolean starred;
}
