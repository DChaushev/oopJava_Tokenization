package com.fmi.oopjava.serverProxy;

import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.enums.ServerName;
import com.fmi.oopjava.interfaces.RemoteServer;
import com.fmi.oopjava.interfaces.Storable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * As mentioned somewhere else, we are using the Proxy Pattern.
 * So this class plays the role of the Proxy for connecting the actual server.
 * Both this class and the server are implementing the RemoteServer interface.
 * 
 * The class has three properties:
 *      - It holds an instance of the Server;
 *      - An instance of the registry where the server is binded.
 *      - And a boolean variable that says if the server is running or not.
 * 
 * It implements all the methods from the RemoteServer interface:
 *      - It just forwards them to the actual server.
 * Plus one more method:
 *      - connect(), which is establishing the connection with the server.
 * 
 * @author Dimitar
 */
public final class ServerProxy implements RemoteServer {

    private RemoteServer server;
    private Registry registry;
    private boolean isRunning;

    public ServerProxy() {
        connectToServer();
    }

    @Override
    public void connectToServer() {
        try {
            System.out.println("connecting...");
            registry = LocateRegistry.getRegistry();
            server = (RemoteServer) registry.lookup(ServerName.NAME.toString());
            System.out.println("connection successfull");
        } catch (RemoteException | NotBoundException ex) {
            //Logger.getLogger(ServerProxy.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connection failed");
        }
    }

    @Override
    public boolean validateCredentials(String username, char[] password) throws RemoteException, NullPointerException {
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
