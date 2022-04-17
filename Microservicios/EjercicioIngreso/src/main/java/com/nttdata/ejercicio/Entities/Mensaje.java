/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nttdata.ejercicio.Entities;

/**
 *
 * @author PEDRINCHI
 */
public class Mensaje {

    private String message;
    private String to;
    private String from;
    private Integer timeToLifeSec;

    public String getMessage() {
        return message;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public Integer getTimeToLifeSec() {
        return timeToLifeSec;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTimeToLifeSec(Integer timeToLifeSec) {
        this.timeToLifeSec = timeToLifeSec;
    }

    public Mensaje(String message, String to, String from, Integer timeToLifeSec) {
        this.message = message;
        this.to = to;
        this.from = from;
        this.timeToLifeSec = timeToLifeSec;
    }

    public Mensaje() {
    }
}
