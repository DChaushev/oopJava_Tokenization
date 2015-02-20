/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.client;

import com.fmi.oopjava.bankCard.BankCard;
import com.fmi.oopjava.cardValidator.CardNumberValidator;
import com.fmi.oopjava.enums.ClientNotifications;
import com.fmi.oopjava.enums.RegularExpressions;
import com.fmi.oopjava.interfaces.RemoteServer;
import com.fmi.oopjava.serverProxy.ServerProxy;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Dimitar
 */
public class ClientMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form ClientMainFrame
     */
    public ClientMainFrame() {
        initComponents();
        TokenizationPanel.setVisible(false);
        server = new ServerProxy();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        LoginPanel = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblLoginNotifications = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TokenizationPanel = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        lblTokenNotifications = new javax.swing.JLabel();
        txtEnterCard = new javax.swing.JTextField();
        txtGetToken = new javax.swing.JTextField();
        btnGenerateToken = new javax.swing.JButton();
        txtEnterToken = new javax.swing.JTextField();
        btnGetCard = new javax.swing.JButton();
        txtGetCard = new javax.swing.JTextField();
        lblGreetings = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tokenization");
        setResizable(false);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblLoginNotifications.setText(" ");

        jLabel5.setText("Username:");

        jLabel6.setText("Password:");

        jLabel7.setText("The username contains only lowercase letters and digits. (3 - 16)");

        jLabel8.setText("The password contains only lowercase letters and digits. (6 - 20)");

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnLogin)
                        .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblLoginNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblLoginNotifications)
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(7, 7, 7)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(5, 5, 5)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblTokenNotifications.setText(" ");

        btnGenerateToken.setText("Generate Token ->");
        btnGenerateToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateTokenActionPerformed(evt);
            }
        });

        btnGetCard.setText("Get card number ->");
        btnGetCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetCardActionPerformed(evt);
            }
        });

        lblGreetings.setText(" ");

        jLabel1.setText("Enter card number:");

        jLabel2.setText("Generated token:");

        jLabel3.setText("Enter token:");

        jLabel4.setText("Card number:");

        javax.swing.GroupLayout TokenizationPanelLayout = new javax.swing.GroupLayout(TokenizationPanel);
        TokenizationPanel.setLayout(TokenizationPanelLayout);
        TokenizationPanelLayout.setHorizontalGroup(
            TokenizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TokenizationPanelLayout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(lblTokenNotifications, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
            .addGroup(TokenizationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TokenizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TokenizationPanelLayout.createSequentialGroup()
                        .addComponent(lblGreetings, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addGroup(TokenizationPanelLayout.createSequentialGroup()
                        .addGroup(TokenizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtEnterToken, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(txtEnterCard, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(TokenizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TokenizationPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnGenerateToken)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGetToken, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(TokenizationPanelLayout.createSequentialGroup()
                                .addComponent(btnGetCard)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGetCard, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(TokenizationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(TokenizationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );
        TokenizationPanelLayout.setVerticalGroup(
            TokenizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TokenizationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TokenizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout)
                    .addComponent(lblGreetings))
                .addGap(17, 17, 17)
                .addComponent(lblTokenNotifications)
                .addGap(12, 12, 12)
                .addGroup(TokenizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TokenizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnterCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGetToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerateToken))
                .addGap(21, 21, 21)
                .addGroup(TokenizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TokenizationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEnterToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetCard)
                    .addComponent(txtGetCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TokenizationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(TokenizationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jLayeredPane1.setLayer(LoginPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(TokenizationPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            
            attemptConnection();
            
            if (loginSuccessfully()) {
                lblLoginNotifications.setText(" ");
                changePanels(TokenizationPanel, LoginPanel);
                lblGreetings.setText(String.format("Hello, %s", client.getName()));
                lblTokenNotifications.setText(" ");
            }
            
        } catch (RemoteException ex) {
            lblLoginNotifications.setText(ClientNotifications.NO_CONNECTION_TO_SERVER.toString());
            //Logger.getLogger(ClientMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        try {
            server.serializeObject(client);
        } catch (RemoteException ex) {
            lblTokenNotifications.setText(ClientNotifications.CONNECTION_LOST.toString());
            //Logger.getLogger(ClientMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            clearFields();
            client = null;
            changePanels(LoginPanel, TokenizationPanel);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnGenerateTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateTokenActionPerformed
        String cardNumber = txtEnterCard.getText();
        BankCard card = null;
        
        if (CardNumberValidator.isValid(cardNumber)) {
            try {
                if (server.cardExists(cardNumber)) {
                    if (!client.hasCard(cardNumber)) {
                        lblTokenNotifications.setText(ClientNotifications.FOREIGN_CARD.toString());
                        clearFields();
                        return;
                    } else {
                        card = (BankCard) server.deserializeObject(cardNumber, BankCard.class);
                    }
                } else {
                    card = new BankCard(cardNumber);
                    System.out.println(cardNumber);
                    client.addCard(cardNumber);
                    server.serializeObject(client);
                }
                
                String token = server.generateToken(cardNumber);
                txtGetToken.setText(token);
                lblTokenNotifications.setText(ClientNotifications.TOKENIZATION_SUCCESSFULL.toString());
                card.addToken(token);
                server.serializeObject(card);
            } catch (RemoteException ex) {
                lblTokenNotifications.setText(ClientNotifications.CONNECTION_LOST.toString());
                //Logger.getLogger(ClientMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            lblTokenNotifications.setText(ClientNotifications.INVALID_CARD_NUMBER.toString());
            return;
        }
    }//GEN-LAST:event_btnGenerateTokenActionPerformed

    private void btnGetCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetCardActionPerformed
        String token = txtEnterToken.getText();
        if (token.matches(RegularExpressions.VALIDATE_TOKEN.toString())) {
            try {
                String cardNumber = server.getCardNumber(token, client);
                
                if (cardNumber != null) {
                    lblTokenNotifications.setText(ClientNotifications.CARD_FOUND.toString());
                    txtGetCard.setText(cardNumber);
                } else {
                    lblTokenNotifications.setText(ClientNotifications.NO_TOKEN.toString());
                }
                
            } catch (RemoteException ex) {
                lblTokenNotifications.setText(ClientNotifications.CONNECTION_LOST.toString());
                //Logger.getLogger(ClientMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            lblTokenNotifications.setText(ClientNotifications.INVALID_TOKEN_FORMAT.toString());
        }

    }//GEN-LAST:event_btnGetCardActionPerformed

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
            java.util.logging.Logger.getLogger(ClientMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ClientMainFrame().setVisible(true);
        });
    }
    
    private Client client = null;
    private RemoteServer server = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel TokenizationPanel;
    private javax.swing.JButton btnGenerateToken;
    private javax.swing.JButton btnGetCard;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lblGreetings;
    private javax.swing.JLabel lblLoginNotifications;
    private javax.swing.JLabel lblTokenNotifications;
    private javax.swing.JTextField txtEnterCard;
    private javax.swing.JTextField txtEnterToken;
    private javax.swing.JTextField txtGetCard;
    private javax.swing.JTextField txtGetToken;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void changePanels(JPanel show, JPanel hide) {
        hide.setVisible(false);
        show.setVisible(true);
    }
    
    private boolean loginSuccessfully() throws RemoteException {
        
        String username = txtUsername.getText();
        char[] password = txtPassword.getPassword();
        
        try {
            
            if (!username.matches(RegularExpressions.VALIDATE_USERNAME.toString())) {
                lblLoginNotifications.setText(ClientNotifications.INVALID_USERNAME_FORMAT.toString());
                return false;
            }
            if (!(new String(password).matches(RegularExpressions.VALIDATE_PASSWORD.toString()))) {
                lblLoginNotifications.setText(ClientNotifications.INVALID_PASSWORD_FORMAT.toString());
                return false;
            }
            
            if (server.validateCredentials(username, password)) {
                setClient(username);
            } else {
                lblLoginNotifications.setText(ClientNotifications.INVALID_CREDENTIALS.toString());
                return false;
            }
        } catch (RemoteException ex) {
            throw ex;
        }
        return true;
    }
    
    private void setClient(String username) throws RemoteException {
        client = (Client) server.deserializeObject(username, Client.class);
    }
    
    private void attemptConnection() {
        new Thread(() -> {
            try {
                server.connectToServer();
            } catch (RemoteException ex) {
                lblLoginNotifications.setText(ClientNotifications.NO_CONNECTION_TO_SERVER.toString());
                //Logger.getLogger(ClientMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
    
    private void clearFields() {
        txtEnterCard.setText("");
        txtEnterToken.setText("");
        txtGetCard.setText("");
        txtGetToken.setText("");
        txtPassword.setText("");
        txtUsername.setText("");
    }
}