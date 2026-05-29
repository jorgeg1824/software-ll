package com.parking.infrastructure.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class FirebaseTokenFilter extends OncePerRequestFilter {

    private static final Logger log =
            LoggerFactory.getLogger(FirebaseTokenFilter.class);

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                     final HttpServletResponse response,
                                     final FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                FirebaseToken decoded = FirebaseAuth.getInstance()
                        .verifyIdToken(token);

                String role = (String) decoded.getClaims()
                        .getOrDefault("role", "OPERATOR");

                String springRole = "ROLE_" + role.toUpperCase();

                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(
                                decoded.getUid(),
                                null,
                                List.of(new SimpleGrantedAuthority(springRole))
                        );

                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception e) {
                log.warn("Token Firebase inválido: {}", e.getMessage());
                SecurityContextHolder.clearContext();
            }
        }

        filterChain.doFilter(request, response);
    }
}