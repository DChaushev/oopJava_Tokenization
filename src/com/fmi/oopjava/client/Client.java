/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.client;

import java.io.Serializable;

/**
 *
 * @author Dimitar
 */
public class Client implements Serializable {

    private String name;
    
    private String username;
    private char[] password;

    public Client() {
    }

    public Client(String name, String username, char[] password) {
        setName(name);
        setUsername(username);
        setPassword(password);
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(char[] password) {
        this.password = new char[password.length];
        System.arraycopy(password, 0, this.password, 0, password.length);
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(char[] password) {
        if (password.length != this.password.length) {
            return false;
        }
        for (int i = 0; i < password.length; i++) {
            if (password[i] != this.password[i]) {
                return false;
            }
        }
        return true;
    }
}
