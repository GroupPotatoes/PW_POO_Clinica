package View;

import Module.Conexao;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;
import Module.Controle;

/**
 * Classe que realiza o cadastro dos funcionários.
 * @author Maiara Rodrigues
 */
public class TelaCadastro extends javax.swing.JFrame {
    
    private Conexao conexao;
    private Connection connection;
    private String login, senha;
    
    /**
     * Construtor da classe.
     */
    public TelaCadastro() {
        initComponents();
        //Criando objeto responsável por conexões
        this.conexao=new Conexao("FS5", 1433, "bdci17", "bdci17", "ert985");
        //setando form para o centro  da tela
        this.setLocationRelativeTo(null);  
        //selecionando todo o texto do nome
        this.txtNome.requestFocus();
        //Desabilitando JTextFields de login e senha
        this.txtLogin.disable();
        this.txtSenha.disable();
        this.abreConexao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastro = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblResultados = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblCadastro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCadastro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadastro.setText(":: Cadastro ::");

        lblNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNome.setText("Seu nome");

        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
        });

        lblResultados.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblResultados.setForeground(new java.awt.Color(102, 102, 102));
        lblResultados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResultados.setText("_Resultados do Cadastro");

        btnCadastrar.setText("DESEJO ME CADASTRAR!");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblLogin.setText("Login gerado");

        txtLogin.setText("Nenhum login gerado");
        txtLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLoginFocusGained(evt);
            }
        });

        lblSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSenha.setText("Senha gerada");

        txtSenha.setText("Nenhuma senha gerada");
        txtSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSenhaFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSenha)
                                    .addComponent(lblLogin))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCadastro)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblResultados)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if(txtNome.getText().equals("")||txtNome.getText()==null){
            lblCadastro.setText("Digite seu nome :(");
            lblCadastro.setForeground(Color.red);
        }
        else{
//            try {    
//                PreparedStatement ps = connection.prepareStatement("insert into [bdci17].[bdci17].[employee_registrer] values "
//                               + "('"+this.txtNome.getText()+"', '"+this.txtSenha2.getText()+"', '"+this.txtLogin.getText()+"')");
//                ps.execute();
//            lblCadastro.setText("Cadastro efetuado com sucesso!");
//            lblCadastro.setForeground(Color.red);
//            } catch (SQLException ex) {
//                // Se ocorrem erros de conexão
//                System.err.println("Problema ao conectar com o Banco de Dados: ");
//                System.err.print("SQLException: " + ex.getMessage());
//                System.err.println("SQLState: " + ex.getSQLState());
//                System.err.println("VendorError: " + ex.getErrorCode());
//            }catch(Exception e){
//                System.err.println("Erro: "+e.getMessage());
//            }

        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLoginFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginFocusGained

    private void txtSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSenhaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaFocusGained

    /**
     * Método que fecha a conexão ao fechar o formulário.
     * @param evt evento ao fechar o formulário.
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.fechaConexao();
    }//GEN-LAST:event_formWindowClosing

     /**
     * Método que abre a conexão com o Banco de Dados e atualiza meu connection.     * 
     */
    private void abreConexao(){
        this.conexao.abreConexao();
        this.connection=conexao.getConnection();
    }
    
     /**
     * Método que fecha a conexão com o Banco de Dados, através da chamada do FechaConexao.
     */
    private void fechaConexao(){
        this.conexao.fechaConexao();
    }
        
    private void geradaLoginSenha() throws SQLException, Exception{        
        char l[] = null, s[] = null;
        
        Random random = new Random();  
        
        for(int i=0;i<Controle.NUM_CARACTERES_LOGIN.getValor();i++){ //me baseando no valor do Enum para a parada do laço
            //atribuo a cada posição desse vetor um número aleatório - que vai até o 9
            l[i]=(char)random.nextInt(9);
        }
        for(int i=0;i<Controle.NUM_CARACTERES_SENHA.getValor();i++){ //me baseando no valor do Enum para a parada do laço
            //atribuo a cada posição desse vetor um número aleatório - que vai até o 9
            s[i]=(char)random.nextInt(9);
        }
                
        //copyValueOf() transforma um vetor de chars em uma String :)
        String login=String.copyValueOf(l);
        String senha=String.copyValueOf(s);
        
        if(validaLoginSenha(login, senha)){
            this.login=login;
            this.senha=senha;
        }else{
            throw new Exception("Erro ao realizar cadastro");
           // TODO Melhorar essa exceção OU mudar lógica            
        }
    }
    
    /**
     * Método que valida login e a senha gerados.
     * @param login login a ser validado.
     * @param senha senha a ser validada. 
     * @return se o login é exclusivo (true) ou se já existe outro no banco (false)
     * @throws SQLException excessão gerada ao ocorrer um erro no acesso ao Banco de Dados.
     */
    private boolean validaLoginSenha(String login, String senha) throws SQLException{
        String comandoSQL;        
        Statement statement  = connection.createStatement();
        comandoSQL="SELECT login, password FROM [bdci17].[bdci17].[employee_registrer]";
        ResultSet resultSet = statement.executeQuery(comandoSQL);
        while(resultSet.next()){
            //se o login e a senha gerados forem iguais a algum já existente no banco
            if(resultSet.getString("login").equals(login)||
               resultSet.getString("password").equals(senha)){
                return false;
            }                
        }
        return true;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JLabel lblCadastro;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
