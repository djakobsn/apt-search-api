package no.jkbn.apt_search_app.security;

import lombok.RequiredArgsConstructor;
import no.jkbn.apt_search_app.entities.AptUser;
import no.jkbn.apt_search_app.repositories.AptUserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AptUserService {

    private final AptUserRepository userRepository;

    public AptUser loadUserByUsername(String username) {
        AptUser user = userRepository.findByUsername(username);

        // Automatically create user if a new, unrecognized username has been authenticated
        if (user == null) {
            AptUser newUser = new AptUser(username);
            userRepository.save(newUser);
            return newUser;
        }
        return user;
    }
}