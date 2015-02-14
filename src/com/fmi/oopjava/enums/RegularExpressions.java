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
public enum RegularExpressions {
    
    VALIDATE_USERNAME("[a-z0-9_]{3,16}"),
    VALIDATE_PASSWORD("((?=.*\\d)(?=.*[a-z]).{6,20})");
    
    private final String regex;

    private RegularExpressions(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
    
}
