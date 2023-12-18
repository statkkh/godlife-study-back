package com.godlife_study.back.filter;

import java.io.IOException;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;


import lombok.RequiredArgsConstructor;


import com.godlife_study.back.provider.JwtProvider;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String token = parseBearerToken(request);
            System.out.println(token);
            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }

            String userEmail = jwtProvider.validate(token);
            if (userEmail == null) {
                filterChain.doFilter(request, response);
                return;
            }

            AbstractAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(userEmail, null, AuthorityUtils.NO_AUTHORITIES);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            
            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            securityContext.setAuthentication(authenticationToken);                        
            SecurityContextHolder.setContext(securityContext);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    private String parseBearerToken(HttpServletRequest request) {

        String authorization = request.getHeader("Authorization");

        System.out.println(authorization);

        boolean hasAuthorization = StringUtils.hasText(authorization);
        if (!hasAuthorization) return null;

        boolean isBearer = authorization.startsWith("Bearer ");
        if (!isBearer) return null;

        String token = authorization.substring(7);
        return token;
    }
}   

