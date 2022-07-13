package no.jkbn.apt_search_app.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The {@code KeycloakConfigResolver} bean is not defined in a configuration class that extends
 * {@code KeycloakWebSecurityConfigurerAdapter} to avoid the {@code Circular References} problem in Spring Boot from version 2.6.0.
 *
 * @see <a href="https://github.com/keycloak/keycloak/issues/8857">Application don't start because of Circular Reference due to dependency injection</a>
 */
@Configuration
public class KeycloakConfig {

    @Bean
    public KeycloakConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}