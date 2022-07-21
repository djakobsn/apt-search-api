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
    private int shortestDuration;

    @OneToOne
    private SearchResult searchResult;

    @Embedded
    private DetailedLocation detailedLocation;
}
