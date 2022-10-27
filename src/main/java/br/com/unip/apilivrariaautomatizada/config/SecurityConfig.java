package br.com.unip.apilivrariaautomatizada.config;

import br.com.unip.apilivrariaautomatizada.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsProperties corsProperties;
    private final TokenService tokenService;

    @Override //Para configurar autorização
    protected void configure(HttpSecurity http) throws Exception {
        if (corsProperties.isEnabled()) {
            http.cors().and().authorizeRequests(r -> r.requestMatchers(CorsUtils::isPreFlightRequest).permitAll());
        }

        http
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .addFilterAfter(getJWTAuthorizationFilter(), CorsFilter.class)
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    @ConditionalOnProperty(value = "cors.enabled", havingValue = "true", matchIfMissing = false)
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedMethods(Arrays.asList(corsProperties.getAllowedMethods()));
        config.setAllowedHeaders(Arrays.asList(corsProperties.getAllowedHeaders()));
        config.setExposedHeaders(Arrays.asList(corsProperties.getExposedHeaders()));
        config.setAllowedOrigins(Arrays.asList(corsProperties.getAllowedOrigins()));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    private JWTAuthorizationFilter getJWTAuthorizationFilter() throws Exception {
        return new JWTAuthorizationFilter(authenticationManager(), tokenService);
    }
}




