/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.enums;

/**
 *
 * @author Dimitar
 */
public enum ServerName {
    
    NAME("tokenizationServer");

    private final String message;

    private ServerName(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
    
}
