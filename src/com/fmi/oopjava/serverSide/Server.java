package com.fmi.oopjava.serverSide;

import com.fmi.oopjava.bankCard.BankCard;
import com.fmi.oopjava.tokenGenerator.TokenGenerator;
import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.interfaces.RemoteServer;
import com.fmi.oopjava.interfaces.Storable;
import com.fmi.oopjava.txtOutputWriter.TxtOutputWriter;
import com.fmi.oopjava.xmlSerializor.Storer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * The Server class.
 * It implements all the methods from the RemoteServer interface.
 * In the interface I've described what each method is for.
 * 
 * Plus it has a couple more package private methods, used from the admin panel.
 * 
 * @author Dimitar
 */
public class Server<T>
        extends UnicastRemoteObject implements RemoteServer {

    private static Server server;
    private final Storer storer;
    private final Map<String, String> tokenMap;
    private final Set<String> allTokens;

    private Server() throws RemoteException {
        storer = new Storer();
        allTokens = new HashSet<>();
        tokenMap = new TreeMap<>();

        collectCardNumbers();
    }

    public static Server getInstance() throws RemoteException {
        if (server == null) {
            synchronized (Server.class) {
                if (server == null) {
                    server = new Server();
                }
            }
        }
        return server;
    }

    @Override
    public boolean validateCredentials(String username, char[] password) {

        if (storer.objectExists(username, Client.class)) {
            Client client = (Client) storer.readObject(username, Client.class);
            if (client != null && client.checkPassword(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String generateToken(String cardNumber) {
        String token;
        boolean tokenAlreadyExists = false;
        do {
            token = TokenGenerator.generateToken(cardNumber);
            if (!allTokens.contains(token)) {
                tokenAlreadyExists = true;
            }
        } while (!tokenAlreadyExists);
        allTokens.add(token);

        tokenMap.put(token, cardNumber);

        return token;
    }

    @Override
    public String getCardNumber(String token, Client client) {
        System.out.println(tokenMap);
        if (tokenMap.containsKey(token)) {
            String cardNumber = tokenMap.get(token);
            if (client.hasCard(cardNumber)) {
                return tokenMap.get(token);
            }
        }
        return null;
    }

    @Override
    public boolean isUp() throws RemoteException {
        return true;
    }

    @Override
    public void serializeObject(Storable obj) throws RemoteException {
        storer.writeObject(obj, obj.getClass());
    }

    @Override
    public T deserializeObject(String fileName, Class objectType) throws RemoteException {
        return (T) storer.readObject(fileName, objectType);
    }

    @Override
    public boolean cardExists(String cardNumber) throws RemoteException {
        return storer.objectExists(cardNumber, BankCard.class);
    }

    boolean userExists(String username) {
        return storer.objectExists(username, Client.class);
    }

    boolean generateOutput() {

        Set<BankCard> allCards = storer.getAllCards();
        if (allCards.isEmpty()) {
            return false;
        }
        TxtOutputWriter.writeOutput(allCards);
        return true;
    }

    private void collectCardNumbers() {
        Set<BankCard> cards = storer.getAllCards();
        for (BankCard card : cards) {
            Set<String> tokens = card.getTokens();
            for (String token : tokens) {
                tokenMap.put(token, card.getCardNumber());
                allTokens.add(token);
            }
        }
    }
}
