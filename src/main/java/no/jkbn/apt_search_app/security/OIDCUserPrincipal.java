package no.jkbn.apt_search_app.security;

import no.jkbn.apt_search_app.entities.OIDCUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class OIDCUserPrincipal implements UserDetails {
    private OIDCUser OIDCUser;

    public OIDCUserPrincipal(OIDCUser OIDCUser) {
        this.OIDCUser = OIDCUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public String getUsername() {
        return OIDCUser.getUsername();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }


}
