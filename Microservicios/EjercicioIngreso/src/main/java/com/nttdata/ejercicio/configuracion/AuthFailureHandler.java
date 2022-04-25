/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttdata.ejercicio.configuracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.ejercicio.Entities.Respuesta;
import com.nttdata.ejercicio.Utils.Utils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 *
 * @author PEDRINCHI
 */
public class AuthFailureHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ObjectMapper objectMapper = new ObjectMapper();
        String objetoJson = objectMapper.writeValueAsString(new Respuesta(Utils.retornarMensajeExcepcionSecurity(authException.getMessage())));
        response.getOutputStream().println(objetoJson);
    }
}
