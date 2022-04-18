/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttdata.ejercicio.Entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author PEDRINCHI
 */
@Data
@RequiredArgsConstructor
public class Respuesta {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Respuesta(String message) {
        this.message = message;
    }

}
