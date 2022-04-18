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
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PEDRINCHI
 */
@RestController
@ControllerAdvice
@RequestMapping("/")
public class DevOpsRestController {

    //@PostMapping("/DevOps")    
    @RequestMapping(value = "/DevOps", method = RequestMethod.POST, produces = "application/json")
    public Respuesta devOps(@RequestBody Mensaje msj) throws HttpRequestMethodNotSupportedException {
        return new Respuesta(Utils.retornaMensaje(msj));
    }

    @ExceptionHandler
    public ResponseEntity<Respuesta> handleException(HttpRequestMethodNotSupportedException ex) {
        return new ResponseEntity<>(new Respuesta(Utils.retornarMensajeExepcion()), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
