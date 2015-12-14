package View.TelasPrincipais;

import Module.DBO.ConnectionSetup;
import Module.DAO.DoctorAppointmentDAO;
import java.awt.Color;
import java.sql.SQLException;

import Module.DAO.RegisteredEmployeeDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaLogin extends javax.swing.JFrame {
    
    private RegisteredEmployeeDAO registeredEmployeeDAO;
    private String login, senha;
    private ConnectionSetup connectionSetup;
    
    public TelaLogin() {
        try {
            connectionSetup = new ConnectionSetup();
            
            initComponents();
            
            this.setLocationRelativeTo(null);
            this.txtLogin.selectAll();
            
            //Faz o campo txtSenha (onde user insere senha) usar o evento de logar ao pressionar ENTER
            this.txtSenha.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        TelaLogin.this.login();
                    } catch (Exception ex) {
                        Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTexto = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnLogar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTexto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTexto.setText(":: Bem vindo! ::");

        lblLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblLogin.setText("Login");

        lblSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSenha.setText("Senha");

        txtLogin.setText("Digite seu login...");

        btnLogar.setText("LOGAR");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogin)
                            .addComponent(lblSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(txtSenha)))
                    .addComponent(btnLogar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogin, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        try {
            this.login();
        } catch (Exception ex) {
            Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLogarActionPerformed
    
    public void login() throws Exception {
        try {
                registeredEmployeeDAO = new RegisteredEmployeeDAO(ConnectionSetup.connection);
                this.senha=txtSenha.getText();
                this.login=txtLogin.getText();
                
                if(!registeredEmployeeDAO.ExistLogin(login, senha)){
                    this.lblTexto.setText("Login ou Senha Incorreto :(");
                    this.lblTexto.setForeground(Color.red);
                    this.txtSenha.setText("");
                }
                else{
                    if(ConnectionSetup.role == 1) { //ADMIN
                        new TelaPrincipal_Admin().setVisible(true);
                    } else if(ConnectionSetup.role == 2 || ConnectionSetup.role == 3) { //RECEPTIONIST & SECRETARY
                        new TelaPrincipal_RecepSecret().setVisible(true);
                    } else { // HEALTH PROFESSIONAL
                        new TelaPrincipal_HealthProf().setVisible(true);
                    }
                   dispose();                     
                }
        } 
        catch (SQLException ex) {
            System.err.print("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
