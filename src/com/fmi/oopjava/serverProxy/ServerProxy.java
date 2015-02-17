/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.serverProxy;

import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.enums.ServerName;
import com.fmi.oopjava.interfaces.RemoteServer;
import com.fmi.oopjava.interfaces.Storable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Dimitar
 */
public class ServerProxy implements RemoteServer {

    private RemoteServer server;
    private Registry registry;
    private boolean isRunning;

    public ServerProxy() {
        connect();
    }

    public void connect() {
        try {
            registry = LocateRegistry.getRegistry();
            server = (RemoteServer) registry.lookup(ServerName.NAME.toString());
            isRunning = true;
        } catch (RemoteException | NotBoundException ex) {
            isRunning = false;
            ex.printStackTrace();
        }
    }

    @Override
    public boolean isUp() {
        connect();
        return isRunning;
    }

    @Override
    public boolean validateCredentials(String username, char[] password) throws RemoteException {
        return server.validateCredentials(username, password);
    }

    @Override
    public String generateToken(String cardNumber) throws RemoteException {
        return server.generateToken(cardNumber);
    }

    @Override
    public String getCardNumber(String token, Client client) throws RemoteException {
        return server.getCardNumber(token, client);
    }

    @Override
    public void serializeObject(Storable obj) throws RemoteException {
        server.serializeObject(obj);
    }

    @Override
    public Object deserializeObject(String fileName, Class objectType) throws RemoteException {
        return server.deserializeObject(fileName, objectType);
    }

    @Override
    public boolean cardExists(String cardNumber) throws RemoteException {
        return server.cardExists(cardNumber);
    }

}
