package View;

import Module.Conexao.Controle;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Random;
import Module.DAO.RegisteredEmployee;
import Module.DAO.Employee;
import Module.DAO.RegisteredEmployeeDAO;
import Module.DAO.Role;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaCadastro extends javax.swing.JFrame {

    private String login, senha, nome;
    private RegisteredEmployee registeredEmployee;
    private Employee employee;
    private RegisteredEmployeeDAO employeeDAO;
    
    
    public TelaCadastro() {
        initComponents();
        
        this.setLocationRelativeTo(null);  
        
        //selecionando todo o texto do nome
        this.txtNome.requestFocus();
        
        //Desabilitando JTextFields de login e senha
        this.txtLogin.disable();
        this.txtSenha.disable();  
        
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
        lblNome1 = new javax.swing.JLabel();
        cbbTipo = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
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

        lblResultados.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblResultados.setForeground(new java.awt.Color(102, 102, 102));
        lblResultados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResultados.setText("_Resultados do Cadastro");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        lblLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblLogin.setText("Login gerado");

        txtLogin.setText("Nenhum login gerado");

        lblSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSenha.setText("Senha gerada");

        txtSenha.setText("Nenhuma senha gerada");

        lblNome1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNome1.setText("Tipo");

        cbbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTipoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
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
                    .addComponent(lblResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(lblNome1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLogin)
                                    .addComponent(lblSenha))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCadastro)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(18, 18, 18)
                        .addComponent(lblNome1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        
        if(txtNome.getText().isEmpty()||txtNome.getText()==null){
            lblCadastro.setText("Digite seu nome :(");
            lblCadastro.setForeground(Color.red);
        }
        else{
            try {
                
                //criando meu manipulador do BD                
                this.employeeDAO = new RegisteredEmployeeDAO();
                
                //vou gerar logins enquanto forem exclusivos
                this.geraLoginSenha();
                this.txtLogin.setText(this.login);
                this.txtSenha.setText(this.senha);         
                this.nome=txtNome.getText();
                
                //Criando um Funcionário
                this.registeredEmployee = new RegisteredEmployee(nome, senha, login); 
                int index = this.cbbTipo.getSelectedIndex();
                this.employee = new Employee(((Role)this.cbbTipo.getItemAt(index)).getId());
                
                //Inserindo no BD
                if(this.employeeDAO.InsertEmployee(registeredEmployee, employee))
                {
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                    this.setVisible(false);
                    //Confirmando o cadastro
                }
                else
                {
                    lblCadastro.setText("Nao foi possivel criar cadastro.");
                    lblCadastro.setForeground(Color.red);
                }
                
                
                
            } catch (SQLException ex) {
                System.err.print("SQLException: " + ex.getMessage());
                System.err.println("SQLState: " + ex.getSQLState());
                System.err.println("VendorError: " + ex.getErrorCode());
            }catch(Exception e){
                System.err.println("Erro desconhecido: "+e.getMessage());
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO usar método fecha conexão
        new TelaLogin(login).setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void cbbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTipoActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            // TODO add your handling code here:
            
            RegisteredEmployeeDAO registeredEmployeeDAO = new RegisteredEmployeeDAO();
            
            for(Role role : registeredEmployeeDAO.SelectAllRole())
                 this.cbbTipo.addItem(role);
                
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_formComponentShown

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed
 
    /**
     * Gera o login e a senha
     * @throws SQLException
     *              Exceção ao acessar o Banco de Dados.
     * @throws Exception 
     */
    private void geraLoginSenha() throws SQLException, Exception{ 
        
        //criando os vetores de login e senha de acordo com o tamanho dos caracteres
        char    login[] = new char[Controle.NUM_CARACTERES_LOGIN.getValor()],
                senha[] = new char[Controle.NUM_CARACTERES_SENHA.getValor()];     
        
        Random random = new Random();    
        
        do{
            //:::::::::::::::::::::::::::::: LOGIN ::::::::::::::::::::::::::::::
            
            //adicionando os valores iniciais e finais [com base na tabela ASCII] aos inteiros
            int valorMinimo=Controle.ASCII_VALOR_MIN.getValor(),
                valorMaximo=Controle.ASCII_VALOR_MAX.getValor();
            
            //atrelando os dois caracteres iniciais com o nome da pessoa
            login[0]=txtNome.getText().charAt(0);
            login[1]=txtNome.getText().charAt(1);
            
            //me baseando no valor do Enum para a parada do laço
            for(int i=2;i<Controle.NUM_CARACTERES_LOGIN.getValor();i++){ 
                //atribuindo a cada posição do vetor um char, que será gerado randomicamente
                //entre os valores mínimos e máximos
                login[i] = (char)(valorMinimo+random.nextInt(valorMaximo-valorMinimo));
            }
            
            //:::::::::::::::::::::::::::::: SENHA ::::::::::::::::::::::::::::::

            //me baseando no valor do Enum para a parada do laço
            for(int i=0;i<Controle.NUM_CARACTERES_SENHA.getValor();i++){                 
                //atribuindo a cada posição desse vetor um número aleatório (que vai até o 9), na base 10
                senha[i] = Character.forDigit(random.nextInt(9), 10);                
            }
            
            //:::::::::::::::::::::::::::::: ATRIBUINDO VALORES ::::::::::::::::::::::::::::::
            
            //copyValueOf() transforma um vetor de chars em uma String :)
            this.login=String.copyValueOf(login);
            this.senha=String.copyValueOf(senha);
            
            //Log para controle
            //System.out.println("Login gerado: "+this.login+" Senha gerada: "+this.senha);
        
        }
        //execução da lógica enquanto o login e a senha não forem exclusivos
        while(!this.employeeDAO.IsUniqueLogin(this.login, this.senha));
    }
    
    /**
     * Valida login e a senha gerados, verificando se são únicos no Banco.
     * @param login login a ser validado.
     * @param senha senha a ser validada. 
     * @return se o login é exclusivo (true) ou se já existe outro no banco (false)
     * @throws SQLException excessão gerada ao ocorrer um erro no acesso ao Banco de Dados.
    
    private boolean exclusivoLoginSenha(String login, String senha) throws SQLException{
        if(employeeDAO.existLogin(login, senha))
            return false;
        return true;
    }
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cbbTipo;
    private javax.swing.JLabel lblCadastro;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
