package br.com.unip.apilivrariaautomatizada.config;

import br.com.unip.apilivrariaautomatizada.service.TokenService;
import br.com.unip.apilivrariaautomatizada.model.dto.UserDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public final static String TOKEN_PREFIX = "Bearer";
    public final static String TOKEN_HEADER = "Authorization";
    private final TokenService jwtAuthService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, TokenService jwtAuthService) {
        super(authenticationManager);
        this.jwtAuthService = jwtAuthService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(TOKEN_HEADER);
        if (StringUtils.isEmpty(header) || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(getAuthentication(header));
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String header) {
        UserDTO userDTO;
        userDTO = jwtAuthService.parseGoogleBearerToken(header.replace(TOKEN_PREFIX + " ", ""));

        return new UsernamePasswordAuthenticationToken(userDTO, "", Collections.emptyList());
    }

}