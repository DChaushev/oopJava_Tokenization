/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.clientSide;

import com.fmi.oopjava.client.Client;
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
    public boolean isUp(){
        return server != null;
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

    @Override
    public void serializeObject(Storable client) throws RemoteException {
        server.serializeObject(client);
    }

    @Override
    public void logout(Client client) throws RemoteException {
        server.logout(client);
    }

    @Override
    public boolean isLogged(Client client) throws RemoteException {
        return server.isLogged(client);
    }

    @Override
    public void login(Client client) throws RemoteException {
        server.login(client);
    }

}
