
package View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Module.Conexao.Conexao;
import java.awt.Color;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Classe que realiza o cadastro de Funcionários - através de Login e Senha dado pelo mesmo.
 * @author Maiara Rodrigues
 */
public class TelaCadastro_Item_4_1 extends javax.swing.JFrame {

    private Connection connection;
    private Conexao conexao;
    protected boolean senha, login;
    
    /**
     * Construtor da classe.
     */
    public TelaCadastro_Item_4_1() {
        initComponents();
        //Criando objeto responsável por conexões
        this.conexao=new Conexao("FS5", 1433, "bdci17", "bdci17", "ert985");
        //setando form para o centro  da tela
        this.setLocationRelativeTo(null);  
        //selecionando todo o texto do login
        this.txtLogin.requestFocus();     
        this.senha=false;
        this.login=false;
        this.btnCadastrar.disable();        
        this.btnCadastrar.setEnabled(senha&&login);
        this.abreConexao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha1 = new javax.swing.JLabel();
        txtSenha1 = new javax.swing.JPasswordField();
        txtSenha2 = new javax.swing.JPasswordField();
        btnCadastrar = new javax.swing.JButton();
        lblTexto = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblImageLogin = new javax.swing.JLabel();
        lblImagePassword = new javax.swing.JLabel();
        lblSenha2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblLogin.setText("Login");

        lblSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSenha.setText("Senha");

        lblSenha1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSenha1.setText("Digite novamente sua senha");

        txtSenha1.setEchoChar('\u2022');
        txtSenha1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenha1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSenha1FocusLost(evt);
            }
        });

        txtSenha2.setEchoChar('\u2022');

        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblTexto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTexto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTexto.setText(":: Cadastro ::");

        lblDescricao.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lblDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescricao.setText("Vamos lá! :)");

        lblSenha2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSenha2.setText("Seu nome");

        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogin)
                            .addComponent(lblSenha)
                            .addComponent(lblSenha1)
                            .addComponent(lblSenha2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNome)
                            .addComponent(txtSenha2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(txtLogin, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSenha1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImageLogin)
                            .addComponent(lblImagePassword)))
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImageLogin)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLogin)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSenha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblImagePassword))
                    .addComponent(lblSenha1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botão que cadastra o funcionário.
     * @param evt evento do botão.
     */
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(senha&&login){         
            try {    
                PreparedStatement ps = connection.prepareStatement("insert into [bdci17].[bdci17].[employee_registrer] values "
                               + "('"+this.txtNome.getText()+"', '"+this.txtSenha2.getText()+"', '"+this.txtLogin.getText()+"')");
                ps.execute();
                JOptionPane.showMessageDialog(null, "<html>Ok...<br>"
                        + "<font color='#1273a3'>CADASTRO EFETUADO :)</font></html>", "Parabéns :)", JOptionPane.INFORMATION_MESSAGE);  
                fechaConexao();
                new TelaLogin().setVisible(true);            
                this.dispose();
            } catch (SQLException ex) {
                // Se ocorrem erros de conexão
                System.err.println("Problema ao conectar com o Banco de Dados: ");
                System.err.print("SQLException: " + ex.getMessage());
                System.err.println("SQLState: " + ex.getSQLState());
                System.err.println("VendorError: " + ex.getErrorCode());
            }catch(Exception e){
                System.err.println("Erro: "+e.getMessage());
            }
        }     
    }//GEN-LAST:event_btnCadastrarActionPerformed

    /**
     * JTextField que valida a senha.
     * @param evt evento deste JTextField.
     */
    private void txtSenha1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenha1FocusGained
       try {
            ImageIcon icon;
            if(loginInedito(txtLogin.getText())){
                icon = new ImageIcon(getClass().getResource("/View/Images/ok.png"));       
                lblDescricao.setText("Que login bacana!");
                lblDescricao.setForeground(Color.black);
                this.login=true;
            }else{
                icon = new ImageIcon(getClass().getResource("/View/Images/nok.png"));
                lblDescricao.setText("Esse login já existe :( Tente outro!");
                lblDescricao.setForeground(Color.red);
                this.login=false;
            }
            lblImageLogin.setIcon(icon);
        } catch (SQLException ex) {
            System.err.println("Erro na conexão com o Banco: "+ex.getMessage());;
        }
    }//GEN-LAST:event_txtSenha1FocusGained

    /**
     * Método que fecha a conexão ao fechar o formulário.
     * @param evt evento ao fechar o formulário.
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.fechaConexao();
    }//GEN-LAST:event_formWindowClosing

    /**
     * JTextField que valida a senha.
     * @param evt evento deste JTextField.
     */
    private void txtSenha1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenha1FocusLost
        if(!(txtSenha1.getText().equals(""))&&(null!=txtSenha1.getText()))
            btnCadastrar.setEnabled(true);
    }//GEN-LAST:event_txtSenha1FocusLost

    /**
     * JTextField que valkida o nome do Funcionário.
     * @param evt evento deste JTextField.
     */
    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        try {
            ImageIcon icon;
            if(login){
                lblDescricao.setText("Corrija antes o seu login!");
                lblDescricao.setForeground(Color.red);
            }
            if((login)&&(txtSenha1.getText().equals(txtSenha2.getText()))){
                icon = new ImageIcon(getClass().getResource("/View/Images/ok.png"));       
                lblDescricao.setText("Pronto! Só mais uma pergunta...");
                lblDescricao.setForeground(Color.black);
                this.senha=true;
            }else{
                icon = new ImageIcon(getClass().getResource("/View/Images/nok.png"));
                lblDescricao.setText("As senhas não batem :(");
                lblDescricao.setForeground(Color.red);
                this.senha=false;
            }
            lblImagePassword.setIcon(icon);
        } catch (Exception ex) {
            System.err.println("Erro na conexão com o Banco: "+ex.getMessage());;
        }
    }//GEN-LAST:event_txtNomeFocusGained

    /**
     * Método que abre a conexão com o Banco de Dados e atualiza meu connection.     * 
     */
    public void abreConexao(){
        this.conexao.abreConexao();
        this.connection=conexao.getConnection();
    }
    
    /**
     * Método que fecha a conexão com o Banco de Dados, através da chamada do FechaConexao.
     */
    public void fechaConexao(){
        this.conexao.fechaConexao();
    }
    
    /**
     * Método que verifica se o login já existe no banco.
     * @param login login que será validado.
     */
    public boolean loginInedito(String login) throws SQLException{        
        boolean loginUnico;
        Statement st = this.connection.createStatement();
        ResultSet rs = st.executeQuery("select * from [bdci17].[bdci17].[employee_registrer] where [login]='"+login+"'");
        //se não retornar ninguém
        if(!rs.next()){
            loginUnico=true;
        }else{
            loginUnico=false;
        }        
        return loginUnico;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblImageLogin;
    private javax.swing.JLabel lblImagePassword;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSenha1;
    private javax.swing.JLabel lblSenha2;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha1;
    private javax.swing.JPasswordField txtSenha2;
    // End of variables declaration//GEN-END:variables
}
