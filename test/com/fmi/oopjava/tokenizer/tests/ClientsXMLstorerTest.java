/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.tokenizer.tests;

import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.bankCard.BankCard;
import com.fmi.oopjava.xmlSerializor.Storer;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dimitar
 */
public class ClientsXMLstorerTest {

    private static Storer storer;
    private static Client client;
    private static BankCard card;
    private static BankCard card2;

    public ClientsXMLstorerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        storer = new Storer();
        client = new Client("Dimitar", "mitko", new char[]{'1', '2', '3', '4', 'a', 'a'});
        card = new BankCard("4563960122019991");
        card2 = new BankCard("4563960122019992");
        client.addCard(card.getCardNumber());
        client.addCard(card2.getCardNumber());
        card.addToken("1234243434269991");
        card.addToken("1234243434269992");
        card2.addToken("1234243434269991");
        card2.addToken("1234243434269992");
    }

    @Test
    public void testClientIO() {
        storer.writeObject(client, Client.class);
        
        Client c = (Client) storer.readObject("mitko", Client.class);

        assertEquals(client.getName(), c.getName());
        assertEquals(client.getUsername(), c.getUsername());
    }

    public void testReadingClient() {

    }

    @Test
    public void testCardIO() {
        storer.writeObject(card, BankCard.class);
        
        BankCard c = (BankCard) storer.readObject(card.getFileName(), BankCard.class);
        assertEquals(card.getCardNumber(), c.getCardNumber());
    }

}
