/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.remoteInterface;

import com.fmi.oopjava.client.Client;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dimitar
 */
public interface RemoteServer extends Remote{
    
    public Client validateCredentials(String username, char[] password) throws RemoteException;
    public String generateToken(String cardNumber) throws RemoteException;
    public String getCardNumber(String token) throws RemoteException;
    public String getAllTokens(String cardNumber) throws RemoteException;
    public boolean isUp() throws RemoteException;
}
