/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttdata.ejercicio.Utils;

import com.nttdata.ejercicio.Entities.Mensaje;

/**
 *
 * @author PEDRINCHI
 */
public class Utils {

    public static String retornaMensaje(Mensaje msj) {
        return String.format("Hello %s your message will be send", msj.getTo());
    }

    public static String retornarMensajeExepcion() {
        String msj = (new MensajesFijos()).getMensajeExepcion();
        System.out.println(msj);
        msj = (msj == null || msj.isEmpty() ? "ERROR" : msj);

        return msj;
    }
}
