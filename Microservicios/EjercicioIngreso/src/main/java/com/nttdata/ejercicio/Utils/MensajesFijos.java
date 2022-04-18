/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttdata.ejercicio.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author PEDRINCHI
 */
@Component
public class MensajesFijos {
    @Value("${respuesta.excepcion.mensaje}")
    private String mensajeExepcion;

    public String getMensajeExepcion() {
        return mensajeExepcion;
    }
}
