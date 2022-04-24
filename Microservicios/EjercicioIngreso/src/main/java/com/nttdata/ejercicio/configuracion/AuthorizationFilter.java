/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttdata.ejercicio.configuracion;

import com.nttdata.ejercicio.Utils.VariablesProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author PEDRINCHI
 */
public class AuthorizationFilter extends OncePerRequestFilter {

    private VariablesProperties varProp = new VariablesProperties();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("-if 0-");
        try {
            if (existeToken(request)) {
                Claims claim = validarToken(request);
                if (claim.get(varProp.getClaimName()) != null) {
                    System.out.println("-if 1-");
                    setUpSpringAuthentication(claim);
                } else {
                    System.out.println("-if 2-");
                    SecurityContextHolder.clearContext();
                }
            } else {
                System.out.println("-if 3-");
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            System.out.println("-exception-");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
            return;
        }
    }

    private Claims validarToken(HttpServletRequest request) {
        String token = request.getHeader(varProp.getValorHeader2());
        return Jwts.parser().setSigningKey(varProp.getClaveSecreta().getBytes()).parseClaimsJws(token).getBody();
    }

    private void setUpSpringAuthentication(Claims claims) {
        @SuppressWarnings("unchecked")
        List<String> authorities = (List) claims.get(varProp.getClaimName());

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));

        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private boolean existeToken(HttpServletRequest request) {
        System.out.println("existeToken");

        String authenticationHeader1 = request.getHeader(varProp.getValorHeader1());
        String authenticationHeader2 = request.getHeader(varProp.getValorHeader2());

        boolean validacion = !((authenticationHeader1 == null || authenticationHeader1.isEmpty())
                && (authenticationHeader2 == null || authenticationHeader2.isEmpty()));
        
        return validacion && evaluarPrimerToken(authenticationHeader1);
    }

    private boolean evaluarPrimerToken(String token) {
        if (token == null) {
            return false;
        }
        return token.equals(varProp.getTokenEvaluar());
    }
}
