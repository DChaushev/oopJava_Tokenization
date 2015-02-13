/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.xmlSerializor;

import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.serverSide.Server;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dimitar
 */
public class ClientsStorer {

    public final static String CLIENTS_FOLDER = "./XML";

    public synchronized static void writeClient(Client client) {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);

        String fileName = String.format(CLIENTS_FOLDER + "/%s.xml", client.getUsername());

        try (ObjectOutputStream oos = xstream.createObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(client);

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Client readClient(String userName) {

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        Client client = null;

        try (ObjectInputStream ois = xstream.createObjectInputStream(new FileInputStream(CLIENTS_FOLDER + "/" + userName + ".xml"))) {

            client = (Client) ois.readObject();

        } catch (com.thoughtworks.xstream.mapper.CannotResolveClassException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        return client;

    }

    public static boolean clientExists(String username) {
        File file = new File(CLIENTS_FOLDER + "/" + username + ".xml");
        return file.exists();
    }

}
