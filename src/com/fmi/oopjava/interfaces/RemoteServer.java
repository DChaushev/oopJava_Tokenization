/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.interfaces;

import com.fmi.oopjava.client.Client;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dimitar
 */
public interface RemoteServer<T> extends Remote{
    
    public boolean validateCredentials(String username, char[] password) throws RemoteException;
    
    public String generateToken(String cardNumber) throws RemoteException;
    
    public String getCardNumber(String token) throws RemoteException;
    
    public boolean cardExists(String cardNumber) throws RemoteException;
    
    public boolean isUp() throws RemoteException;
    
    public void logout(Client client) throws RemoteException;
    
    public void login(Client client) throws RemoteException;
    
    public boolean isLogged(Client client) throws RemoteException;
    
    public void serializeObject(Storable client) throws RemoteException;
    
    public T deserializeObject(String fileName, Class objectType) throws RemoteException;
    
}
