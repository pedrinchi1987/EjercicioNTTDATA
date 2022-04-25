/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttdata.ejercicio.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @author PEDRINCHI
 */
@Component
@Configuration
@PropertySource("classpath:application.properties")
public class VariablesProperties {

    @Value("${security.header.header1}")
    private String valorHeader1;

    @Value("${security.header.header2}")
    private String valorHeader2;

    @Value("${security.token.clave.secreta}")
    private String claveSecreta;

    @Value("${security.token.value}")
    private String tokenEvaluar;

    @Value("${security.claim.name}")
    private String claimName;

    @Value("${security.duration.token}")
    private int expiracionToken;

    public String getValorHeader1() {
        valorHeader1 = (valorHeader1 == null ? Constantes.ID_HEADER_1 : valorHeader1);
        return valorHeader1;
    }

    public String getValorHeader2() {
        valorHeader2 = (valorHeader2 == null ? Constantes.ID_HEADER_2 : valorHeader2);
        return valorHeader2;
    }

    public String getClaveSecreta() {
        claveSecreta = (claveSecreta == null ? Constantes.CLAVE_SECRETA : claveSecreta);
        return claveSecreta;
    }

    public String getTokenEvaluar() {
        tokenEvaluar = (tokenEvaluar == null ? Constantes.TOKEN_VERIFICADOR : tokenEvaluar);
        return tokenEvaluar;
    }

    public String getClaimName() {
        claimName = (claimName == null ? Constantes.NOMBRE_CLAIM : claimName);
        return claimName;
    }

    public int getExpiracionToken() {
        expiracionToken = (expiracionToken == 0 ? Constantes.EXPIRACION_TOKEN : expiracionToken);
        return expiracionToken;
    }

}
