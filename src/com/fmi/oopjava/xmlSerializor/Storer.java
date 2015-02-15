/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.xmlSerializor;

import com.fmi.oopjava.bankCard.BankCard;
import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.interfaces.Storable;
import com.fmi.oopjava.serverSide.Server;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dimitar
 */
public class Storer<T> {

    public final static String CLIENTS_FOLDER = "./XML_users";
    public final static String CARDS_FOLDER = "./XML_cards";

    public synchronized void writeObject(Storable obj, Class<T> objType) {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);

        String fileName = String.format("%s/%s.xml", getFolder(objType), obj.getFileName());

        try (ObjectOutputStream oos = xstream.createObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(obj);

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public T readObject(String fileName, Class<T> objType) {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        T result = null;
        String file;
        if (fileName.endsWith(".xml")) {
            file = getFolder(objType) + "/" + fileName;
        } else {
            file = getFolder(objType) + "/" + fileName + ".xml";
        }

        try (ObjectInputStream ois = xstream.createObjectInputStream(new FileInputStream(file))) {

            result = (T) ois.readObject();

        } catch (com.thoughtworks.xstream.mapper.CannotResolveClassException | FileNotFoundException ex) {
            return null;
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }

    private String getFolder(Class<T> objType) {
        String folder;
        if (objType == Client.class) {
            folder = CLIENTS_FOLDER;
        } else {
            folder = CARDS_FOLDER;
        }
        return folder;
    }

    public static boolean clientExists(String username) {
        File file = new File(CLIENTS_FOLDER + "/" + username + ".xml");
        return file.exists();
    }

    public boolean cardExists(String cardNumber) {
        File file = new File(CARDS_FOLDER + "/" + cardNumber + ".xml");
        return file.exists();
    }

    public Set<BankCard> getAllCards() {
        Set<BankCard> cards = new TreeSet<>();

        File folder = new File(CARDS_FOLDER);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            String name = file.getName();
            BankCard card = (BankCard) readObject(name, (Class<T>) BankCard.class);
            System.out.println(card.getCardNumber());
            boolean add = cards.add(card);
            System.out.println(add);
        }
        return cards;
    }
}
