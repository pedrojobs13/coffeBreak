package com.pedrolg.coffeebreak.config;

import com.pedrolg.coffeebreak.gateway.ValidateTokenGateway;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private final ValidateTokenGateway validateTokenGateway;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recoverToken(request);
        if (token != null) {
            final Login login;
            login = validateTokenGateway.execute(token);
            if (login != null) {
                UserDetails user = this.getUser(login);
                var authentication = new UsernamePasswordAuthenticationToken(login, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

    private UserDetails getUser(final Login login) {
        final var authorities = getGrantedAuthorities(login);
        return new UserDetailsImpl(login.getEmail(), null, authorities);
    }

    private List<SimpleGrantedAuthority> getGrantedAuthorities(final Login login) {
        return login.getRoles().stream()
                .map(Role::getType)
                .map(role -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

    }
}
