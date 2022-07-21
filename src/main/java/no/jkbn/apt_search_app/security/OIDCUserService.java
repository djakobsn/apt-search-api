package no.jkbn.apt_search_app.security;

import lombok.RequiredArgsConstructor;
import no.jkbn.apt_search_app.entities.OIDCUser;
import no.jkbn.apt_search_app.repositories.OIDCUserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OIDCUserService {

    private final OIDCUserRepository userRepository;

    public OIDCUser loadUserByUsername(String username) {
        OIDCUser user = userRepository.findByUsername(username);

        // Automatically create user if a new, unrecognized username has been authenticated
        if (user == null) {
            OIDCUser newUser = new OIDCUser(username);
            userRepository.save(newUser);
            return newUser;
        }
        return user;
    }
}