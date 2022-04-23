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
public class SeguridadTemp {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SeguridadTemp(String token) {
        this.token = token;
    }

}
