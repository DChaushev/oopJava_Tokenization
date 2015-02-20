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
    VALIDATE_PASSWORD("((?=.*\\d)(?=.*[a-z]).{6,20})"),
    VALIDATE_CARD_NUMBER("[3,4,5,6]{1}[0-9]{15}"),
    VALIDATE_TOKEN("[0,1,2,7,8,9]{1}[0-9]{15}");
    
    private final String regex;

    private RegularExpressions(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return regex;
    }
    
}
