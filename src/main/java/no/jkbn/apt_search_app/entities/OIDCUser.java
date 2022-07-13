package no.jkbn.apt_search_app.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class OIDCUser {

    public OIDCUser(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String username;

    @OneToMany(cascade=CascadeType.ALL)
    private List<Place> places;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OIDCUser OIDCUser = (OIDCUser) o;
        return id != null && Objects.equals(id, OIDCUser.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
