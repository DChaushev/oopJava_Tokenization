package com.fmi.oopjava.clientSide;

import com.fmi.oopjava.enums.ClientNotifications;
import com.fmi.oopjava.serverProxy.ServerProxy;
import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.interfaces.RemoteServer;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dimitar
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form ClientPanel
     */
    public LoginPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblNotification = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

        lblNotification.setForeground(new java.awt.Color(255, 0, 0));
        lblNotification.setText(" ");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblNotification)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(26, 26, 26)
                .addComponent(btnLogin)
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        try {
            new Thread(() -> {
                connectToServer();
            }).start();
            if (server != null) {
                attemptLogin();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(LoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private final String usernameMatcher = "[a-z0-9_]{3,16}";
    private final String passwordMatcher = "((?=.*\\d)(?=.*[a-z]).{6,20})";
    private final String emptyString = "";
    private RemoteServer server = new ServerProxy();
    private MainFrame frame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblNotification;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void attemptLogin() throws RemoteException {

        if (!server.isUp()) {
            lblNotification.setText(ClientNotifications.NO_CONNECTION_TO_SERVER.getMessage());
            return;
        }

        String username = txtUsername.getText();
        char[] password = txtPassword.getPassword();

        if (!username.matches(usernameMatcher)) {
            lblNotification.setText(ClientNotifications.INVALID_USERNAME_FORMAT.getMessage());
            return;
        }
        String pswd = new String(password);
        if (!pswd.matches(passwordMatcher)) {
            lblNotification.setText(ClientNotifications.INVALID_PASSWORD_FORMAT.getMessage());
            return;
        }

        Client c = server.validateCredentials(username, password);
        if (c != null) {

            if (server.isLogged(c)) {
                lblNotification.setText(ClientNotifications.ALREADY_LOGGED.getMessage());
                return;
            }
            server.login(c);
            TokenizationPanel tp = new TokenizationPanel();
            tp.setClient(c);
            frame.changePanel(this, tp);
        } else {
            lblNotification.setText(ClientNotifications.INVALID_CREDENTIALS.getMessage());
            txtUsername.setText(emptyString);
            txtPassword.setText(emptyString);
        }
    }

    private void connectToServer() {
        frame = (MainFrame) SwingUtilities.getWindowAncestor(this);
        server = frame.getServer();
    }
}
