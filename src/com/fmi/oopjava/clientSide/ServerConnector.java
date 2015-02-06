/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.clientSide;

import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.remoteInterface.RemoteServer;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Dimitar
 */
public class ServerConnector implements RemoteServer {

    private RemoteServer server = null;

    public ServerConnector() {
        connect();
    }

    private void connect() {
        try {
            Registry registry = LocateRegistry.getRegistry();
            server = (RemoteServer) registry.lookup("remoteServer");

        } catch (RemoteException | NotBoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Client validateCredentials(String username, char[] password) throws RemoteException {
        return server.validateCredentials(username, password);
    }

    @Override
    public String generateToken(String cardNumber) throws RemoteException {
        return server.generateToken(cardNumber);
    }

    @Override
    public String getCardNumber(String token) throws RemoteException {
        return server.getCardNumber(token);
    }

    @Override
    public String getAllTokens(String cardNumber) throws RemoteException {
        return server.getAllTokens(cardNumber);
    }

}
