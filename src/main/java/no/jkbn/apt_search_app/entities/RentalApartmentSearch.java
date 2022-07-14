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
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private OIDCUser owner;

    @OneToMany
    private Set<PlaceSearch> place_searches;

}
