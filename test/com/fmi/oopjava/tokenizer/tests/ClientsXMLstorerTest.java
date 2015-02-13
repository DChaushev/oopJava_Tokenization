/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.tokenizer.tests;

import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.serverSide.BankCard;
import com.fmi.oopjava.xmlSerializor.ClientsStorer;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dimitar
 */
public class ClientsXMLstorerTest {

    private static Client client;
    private static BankCard card;
    private static BankCard card2;

    public ClientsXMLstorerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        client = new Client("Dimitar", "mitko", new char[]{'1', '2', '3', '4', 'a', 'a'});
        card = new BankCard("4563960122019991");
        card2 = new BankCard("4563960122019992");
        client.addCard(card);
        client.addCard(card2);
        card.addToken("1234243434269991");
        card.addToken("1234243434269992");
        card2.addToken("1234243434269991");
        card2.addToken("1234243434269992");
    }

    @Test
    public void testWriting() {
        ClientsStorer.writeClient(client);
    }

    @Test
    public void testReading() {
        Client c = ClientsStorer.readClient("mitko");
        
        assertEquals(client.getName(), c.getName());
        assertEquals(client.getUsername(), c.getUsername());
    }

}
