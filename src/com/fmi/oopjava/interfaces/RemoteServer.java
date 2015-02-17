package com.fmi.oopjava.interfaces;

import com.fmi.oopjava.client.Client;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Because I am using the Proxy Pattern for remote access, the actual server
 * and the proxy server should implement this interface.
 * 
 * Each client holds an instance of the ProxyServer class, who has the same behavior
 * as the actual server, because of the interface.
 * 
 * Thus the client is sending his requests to the proxy server, which is forwarding
 * them to the actual server using RMI.
 * 
 * All methods throw RemoteException because the data is send over the network to remote
 * JVM and for known or unknown reasons the connection might be lost, server down and so on.
 * 
 * @author Dimitar
 */
public interface RemoteServer<T> extends Remote{
    
    /**
     * This method is called when the client is trying to login.
     * He is sending his username and password.
     * 
     * @param username The client's username.
     * @param password The client's password.
     * @return True if such user exists and the password is correct.
     *         False if no such user or wrong password.
     * @throws RemoteException
     */
    public boolean validateCredentials(String username, char[] password) throws RemoteException;
    
    /**
     * This is the main functionality of the server - to generate tokens by given
     * card number.
     * 
     * @param cardNumber The method receives a card number.
     * @return And returns a newly generated token.
     * @throws RemoteException 
     */
    public String generateToken(String cardNumber) throws RemoteException;
    
    /**
     * The client can see which token which card is representing by entering the
     * token number;
     * 
     * @param token The client enters the token.
     * @param client And the methods beneath send also the actual client, because
     *               we want to check if this token and cards are his. We are being cautious and we don't
     *               want clients to have access to other client's information.
     * @return The card number if this token and card belong to the client.
     * @throws RemoteException 
     */
    public String getCardNumber(String token, Client client) throws RemoteException;
    
    /**
     * This methods takes card number as an argument and tells us
     * if this card is existing.
     * 
     * @param cardNumber
     * @return
     * @throws RemoteException 
     */
    public boolean cardExists(String cardNumber) throws RemoteException;
    
    /**
     * This method is telling us if the server isUp and running.
     * When implemented on the actual server, it is always returning True.
     * 
     * @return
     * @throws RemoteException 
     */
    public boolean isUp() throws RemoteException;
    
    /**
     * We are using this method to serialize object as XML files.
     * The objects must implement the Storable interface.
     * 
     * @param object
     * @throws RemoteException
     */
    public void serializeObject(Storable object) throws RemoteException;
    
    /**
     * This method deserializes objects.
     * It takes the fileName:
     *          - username for Client
     *          - card number for BankCard
     * And the type of the object, to it knows how to convert it.
     * 
     * 
     * @param fileName
     * @param objectType
     * @return the deserialized object.
     * @throws RemoteException 
     */
    public T deserializeObject(String fileName, Class objectType) throws RemoteException;
    
}
