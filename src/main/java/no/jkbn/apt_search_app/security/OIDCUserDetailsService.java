package no.jkbn.apt_search_app.security;

import no.jkbn.apt_search_app.entities.OIDCUser;
import no.jkbn.apt_search_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class OIDCUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        OIDCUser user = userRepository.findByUsername(username);

        // Automatically create user if an unrecognized username has been authenticated
        if (user == null) {
            OIDCUser newUser = new OIDCUser(username);
            userRepository.save(newUser);
            return new OIDCUserPrincipal(newUser);
        }
        return new OIDCUserPrincipal(user);
    }
}