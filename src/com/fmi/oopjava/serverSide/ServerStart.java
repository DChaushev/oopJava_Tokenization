/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.serverSide;

import com.fmi.oopjava.remoteInterface.RemoteServer;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Dimitar
 */
public class ServerStart {
    
    public static void main(String[] args) {
        
        RemoteServer server = null;
        
        try {
        
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
            server = new Server();
            Naming.rebind("//localhost/remoteServer", server);
            
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
        
    }
    
}
