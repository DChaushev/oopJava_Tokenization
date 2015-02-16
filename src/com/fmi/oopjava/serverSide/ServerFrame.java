/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.serverSide;

import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.enums.RegularExpressions;
import com.fmi.oopjava.enums.ServerName;
import com.fmi.oopjava.enums.ServerNotifications;
import java.awt.event.ItemEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dimitar
 */
public class ServerFrame extends javax.swing.JFrame {

    /**
     * Creates new form ServerFrame
     */
    public ServerFrame() {
        initComponents();
        disableButtons();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabAddUser = new javax.swing.JTabbedPane();
        panelAddUser = new javax.swing.JPanel();
        txtPassword = new javax.swing.JPasswordField();
        btnAddUser = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelGenerateOutput = new javax.swing.JPanel();
        btnGenerateOutput = new javax.swing.JButton();
        lblNotifications = new javax.swing.JLabel();
        toggleServer = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tokenization Server");

        btnAddUser.setText("Add User");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        javax.swing.GroupLayout panelAddUserLayout = new javax.swing.GroupLayout(panelAddUser);
        panelAddUser.setLayout(panelAddUserLayout);
        panelAddUserLayout.setHorizontalGroup(
            panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAddUserLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddUser)
                    .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelAddUserLayout.setVerticalGroup(
            panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panelAddUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnAddUser)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        tabAddUser.addTab("Add User", panelAddUser);

        btnGenerateOutput.setText("Generate Output");
        btnGenerateOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGenerateOutputLayout = new javax.swing.GroupLayout(panelGenerateOutput);
        panelGenerateOutput.setLayout(panelGenerateOutputLayout);
        panelGenerateOutputLayout.setHorizontalGroup(
            panelGenerateOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGenerateOutputLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(btnGenerateOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        panelGenerateOutputLayout.setVerticalGroup(
            panelGenerateOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGenerateOutputLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(btnGenerateOutput)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        tabAddUser.addTab("Generate Output", panelGenerateOutput);

        lblNotifications.setText(" ");

        toggleServer.setText("Start Server");
        toggleServer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toggleServerItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabAddUser))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(toggleServer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNotifications)
                    .addComponent(toggleServer))
                .addGap(11, 11, 11)
                .addComponent(tabAddUser)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        String name = txtName.getText();
        String userName = txtUsername.getText();
        char[] password = txtPassword.getPassword();

        if (userName.matches(RegularExpressions.VALIDATE_USERNAME.toString()) && new String(password).matches(RegularExpressions.VALIDATE_PASSWORD.toString())) {

            if (!server.userExists(userName)) {

                try {
                    Client client = new Client(name, userName, password);
                    lblNotifications.setText(ServerNotifications.USER_ADDED.toString());
                    clearUserFields();
                    server.serializeObject(client);
                } catch (RemoteException ex) {
                    Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                lblNotifications.setText(ServerNotifications.USER_ALREADY_EXISTS.toString());
            }

        } else {
            lblNotifications.setText(ServerNotifications.INVALID_CREDENTIALS.toString());
        }

    }//GEN-LAST:event_btnAddUserActionPerformed

    private void toggleServerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toggleServerItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            startServer();
        } else {
            stopServer();
        }
    }//GEN-LAST:event_toggleServerItemStateChanged

    private void btnGenerateOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateOutputActionPerformed
        if(!server.generateOutput()){
            lblNotifications.setText(ServerNotifications.NO_CARDS.toString());
        }
    }//GEN-LAST:event_btnGenerateOutputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ServerFrame().setVisible(true);
        });
    }

    private Registry reg;
    private Server server = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnGenerateOutput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblNotifications;
    private javax.swing.JPanel panelAddUser;
    private javax.swing.JPanel panelGenerateOutput;
    private javax.swing.JTabbedPane tabAddUser;
    private javax.swing.JToggleButton toggleServer;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void startServer() {
        try {
            reg = LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
            server = new Server();
            Naming.rebind("//localhost/" + ServerName.NAME.toString(), server);
            System.out.println(registry);
            System.out.println(reg);
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
        enableButtons();
        System.out.println("Sever started!");
    }

    private void stopServer() {
        try {
            Naming.unbind("//localhost/" + ServerName.NAME.toString());
            server = null;
            if (reg != null) {
                UnicastRemoteObject.unexportObject(reg, false);
            }
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        disableButtons();
        System.out.println("Sever stopped!");
    }

    private void clearUserFields() {
        txtName.setText("");
        txtPassword.setText("");
        txtUsername.setText("");
    }

    private void disableButtons() {
        btnAddUser.setEnabled(false);
        btnGenerateOutput.setEnabled(false);
    }

    private void enableButtons() {
        btnAddUser.setEnabled(true);
        btnGenerateOutput.setEnabled(true);
    }
}
