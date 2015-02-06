/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.serverSide;

import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.remoteInterface.RemoteServer;
import com.fmi.oopjava.tokenGenerator.TokenGenerator;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Dimitar
 */
public class Server
        extends UnicastRemoteObject implements RemoteServer {

    private final Map<String, String> tokenMap;
    private final Map<String, Client> clientMap;
    private final Map<String, List<String>> cardToTokensMap;

    public Server() throws RemoteException {
        tokenMap = new TreeMap<>();
        clientMap = new TreeMap<>();
        cardToTokensMap = new TreeMap<>();
        clientMap.put("mitko", new Client("Dimitar", "mitko", new char[]{'1', '2', '3', '4'}));
        clientMap.put("ivan", new Client("Ivan", "ivan", new char[]{'1', '2', '3', '4'}));
    }

    @Override
    public Client validateCredentials(String username, char[] password) {
        if (clientMap.containsKey(username)) {
            if (clientMap.get(username).checkPassword(password)) {
                return clientMap.get(username);
            }
        }
        return null;
    }

    @Override
    public String generateToken(String cardNumber) {
        String token = TokenGenerator.generateToken(cardNumber);
        tokenMap.put(token, cardNumber);
        if(!cardToTokensMap.containsKey(cardNumber)){
            cardToTokensMap.put(cardNumber, new ArrayList<>());
        }
        cardToTokensMap.get(cardNumber).add(token);
        return token;
    }

    @Override
    public String getCardNumber(String token) {
        if (tokenMap.containsKey(token)) {
            return tokenMap.get(token);
        }
        return null;
    }

    @Override
    public String getAllTokens(String cardNumber) throws RemoteException {
        StringBuilder result;
        if(cardToTokensMap.containsKey(cardNumber)){
            result = new StringBuilder();
            List tokens = cardToTokensMap.get(cardNumber);
            for (Object token : tokens) {
                result.append(String.format("%s\n", token));
            }
            return result.toString();
        }
        return null;
    }

}
