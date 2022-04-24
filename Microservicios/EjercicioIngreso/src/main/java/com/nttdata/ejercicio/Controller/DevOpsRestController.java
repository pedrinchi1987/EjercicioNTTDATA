/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.nttdata.ejercicio.Controller;

import com.nttdata.ejercicio.Entities.Mensaje;
import com.nttdata.ejercicio.Entities.Respuesta;
import com.nttdata.ejercicio.Utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PEDRINCHI
 */
@RestController
@ControllerAdvice
@RequestMapping("/")
public class DevOpsRestController {

    @PostMapping("/DevOps")
    public Respuesta devOps(@RequestBody Mensaje msj) throws HttpRequestMethodNotSupportedException, AuthorizationServiceException, Exception {
        return new Respuesta(Utils.retornaMensaje(msj));
    }

    @ExceptionHandler
    public ResponseEntity<Respuesta> handleException(HttpRequestMethodNotSupportedException ex) {
        return new ResponseEntity<>(new Respuesta(Utils.retornarMensajeExcepcion()), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler
    public ResponseEntity<Respuesta> handleException(Exception ex) {
        return new ResponseEntity<>(new Respuesta(Utils.retornarMensajeExcepcion()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<Respuesta> handleException(AuthorizationServiceException ex) {
        return new ResponseEntity<>(new Respuesta(Utils.retornarMensajeExcepcionSecurity(ex.getMessage())), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }
}
