package no.jkbn.apt_search_app.security;

import lombok.RequiredArgsConstructor;
import no.jkbn.apt_search_app.entities.OIDCUser;
import no.jkbn.apt_search_app.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OIDCUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        OIDCUser user = userRepository.findByUsername(username);

        // Automatically create user if a new, unrecognized username has been authenticated
        if (user == null) {
            OIDCUser newUser = new OIDCUser(username);
            userRepository.save(newUser);
            return new OIDCUserPrincipal(newUser);
        }
        return new OIDCUserPrincipal(user);
    }
}