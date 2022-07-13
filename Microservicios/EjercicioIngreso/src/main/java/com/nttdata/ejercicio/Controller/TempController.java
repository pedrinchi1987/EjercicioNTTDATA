/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.nttdata.ejercicio.Controller;

import com.nttdata.ejercicio.Entities.Respuesta;
import com.nttdata.ejercicio.Entities.SeguridadTemp;
import com.nttdata.ejercicio.Utils.Utils;
import com.nttdata.ejercicio.Utils.VariablesProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PEDRINCHI
 */
@RestController
@ControllerAdvice
@RequestMapping("/")
public class TempController {

    private VariablesProperties varProp = new VariablesProperties();

    @PostMapping("/Token2")
    //@RequestMapping(value = "/Temp", method = RequestMethod.POST, produces = "application/json")
    public SeguridadTemp generador() throws HttpRequestMethodNotSupportedException, Exception {
        return new SeguridadTemp(generarToken());
    }

    private String generarToken() {        
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        
       return Jwts.builder().setId("softtekJWT").setSubject("DevOPS")
                .claim(varProp.getClaimName(), grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + varProp.getExpiracionToken()))
                .signWith(SignatureAlgorithm.HS512, varProp.getClaveSecreta().getBytes()).compact();
    }

    @ExceptionHandler
    public ResponseEntity<Respuesta> handleException(HttpRequestMethodNotSupportedException ex) {
        return new ResponseEntity<>(new Respuesta(Utils.retornarMensajeExcepcion()), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler
    public ResponseEntity<Respuesta> handleException(Exception ex) {     
        return new ResponseEntity<>(new Respuesta(ex.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
