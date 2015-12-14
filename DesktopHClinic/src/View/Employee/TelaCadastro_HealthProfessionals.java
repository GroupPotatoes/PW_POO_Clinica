package View.Employee;

import Module.DBO.ConnectionSetup;
import Module.DBO.Specialization;
import Module.DBO.HealthProfessionals;
import Module.DBO.Professions;
import Module.DBO.RegisteredEmployee;
import Module.DBO.HealthProfessionalsHaveSpecialization;
import Module.DAO.SpecializationDAO;
import Module.DAO.RegisteredEmployeeDAO;
import Module.DAO.ProfessionsDAO;
import Module.DAO.HealthProfessionalsDAO;
import Module.Conexao.Controle;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaCadastro_HealthProfessionals extends javax.swing.JPanel {

    private RegisteredEmployee registeredEmployee = null;
    private HealthProfessionals healthprof = null;
    private HealthProfessionalsHaveSpecialization healthprofHasSpecialization = null;
    private RegisteredEmployeeDAO employeeDAO = null;
    private HealthProfessionalsDAO hpDAO = null;
    private ProfessionsDAO p = null;
    private SpecializationDAO specializationDAO = null;
    private String login = null;
    private String senha = null;
    private String nome = null;
    private String cpf = null;
    private String registro = null;

    public TelaCadastro_HealthProfessionals() {
        initComponents();

        this.employeeDAO = new RegisteredEmployeeDAO(ConnectionSetup.connection);
        this.hpDAO = new HealthProfessionalsDAO(ConnectionSetup.connection);
        this.p = new ProfessionsDAO(ConnectionSetup.connection);
        this.specializationDAO = new SpecializationDAO(ConnectionSetup.connection);

        //disables specialty field while profession is not chosen
        this.especialProfSaude.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastroProfSaude = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        labelProfissao = new javax.swing.JLabel();
        labelEspec = new javax.swing.JLabel();
        profissaoProfSaude = new javax.swing.JComboBox();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        especialProfSaude = new javax.swing.JComboBox();
        lblResultados = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cpfField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        registroField = new javax.swing.JTextField();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lblCadastroProfSaude.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCadastroProfSaude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadastroProfSaude.setText(":: Cadastro de Profissional de Saúde ::");

        labelNome.setText("Nome Completo");

        labelProfissao.setText("Profissão");

        labelEspec.setText("Especialidade");

        profissaoProfSaude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profissaoProfSaudeActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblResultados.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblResultados.setForeground(new java.awt.Color(102, 102, 102));
        lblResultados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResultados.setText("_Resultados do Cadastro");

        lblLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblLogin.setText("Login gerado");

        txtLogin.setText("Nenhum login gerado");

        txtSenha.setText("Nenhuma senha gerada");

        lblSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSenha.setText("Senha gerada");

        jLabel1.setText("CPF");

        jLabel2.setText("Registro profissional");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel3.setText("(exemplos: CRO, CRM, CREFITO)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCadastroProfSaude, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(labelNome)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(labelProfissao)
                            .addComponent(labelEspec))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(registroField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(profissaoProfSaude, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(especialProfSaude, javax.swing.GroupLayout.Alignment.LEADING, 0, 202, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar)))
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResultados, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLogin)
                                    .addComponent(lblSenha))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(81, 81, 81)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblCadastroProfSaude)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cpfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(labelProfissao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(profissaoProfSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(especialProfSaude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEspec))))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(lblResultados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (this.txtNome.getText().isEmpty() || this.txtNome.getText() == null) {
            this.txtNome.setText("Este campo é obrigatório!");
            this.txtNome.setForeground(Color.red);
        }
        if (this.profissaoProfSaude.getSelectedIndex() == -1) {
            this.profissaoProfSaude.setForeground(Color.red);
        }
        if (this.especialProfSaude.getSelectedIndex() == -1) {
            this.especialProfSaude.setForeground(Color.red);
        }
        if (this.cpfField.getText().isEmpty() || this.cpfField.getText() == null) {
            this.cpfField.setText("Este campo é obrigatório!");
            this.cpfField.setForeground(Color.red);
        }
        if (this.registroField.getText().isEmpty() || this.registroField.getText() == null) {
            this.registroField.setText("Este campo é obrigatório!");
            this.registroField.setForeground(Color.red);
        } else {
            try {

                this.geraLoginSenha();
                this.txtLogin.setText(this.login);
                this.txtSenha.setText(this.senha);
                this.nome = txtNome.getText();
                this.cpf = cpfField.getText();
                this.registro = registroField.getText();

                //Criar novo RegisteredEmployee
                this.registeredEmployee = new RegisteredEmployee(nome, senha, login);
                int indexProf = ((Professions) this.profissaoProfSaude.getSelectedItem()).getId();
                int indexSpec = ((Specialization) this.especialProfSaude.getSelectedItem()).getId();

                //Criar um health professional
                this.healthprof = new HealthProfessionals(this.cpf, this.registro);

                //this.healthprofHasSpecialization = new HealthProfessionalsHaveSpecialization(indexSpec);
                if (this.hpDAO.InsertHealthProfessionals(registeredEmployee, healthprof, indexSpec)) {
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
                    this.setVisible(false);
                    TelaDisponibilidades disp = new TelaDisponibilidades(healthprof.getidRegisteredEmployee(), indexSpec);
                    disp.setLocationRelativeTo(null);
                    disp.setVisible(true);
                    disp.setAlwaysOnTop(true);
                } else {
                    this.txtLogin.setText(null);
                    this.txtSenha.setText(null);
                    this.lblCadastroProfSaude.setText("Houve um erro no cadastro do profissional!");
                    this.lblCadastroProfSaude.setForeground(Color.red);

                }
            } catch (Exception ex) {
                Logger.getLogger(TelaCadastro_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void geraLoginSenha() throws SQLException, Exception {

        //criando os vetores de login e senha de acordo com o tamanho dos caracteres
        char login[] = new char[Controle.NUM_CARACTERES_LOGIN.getValor()],
                senha[] = new char[Controle.NUM_CARACTERES_SENHA.getValor()];

        Random random = new Random();

        do {
            //:::::::::::::::::::::::::::::: LOGIN ::::::::::::::::::::::::::::::

            //adicionando os valores iniciais e finais [com base na tabela ASCII] aos inteiros
            int valorMinimo = Controle.ASCII_VALOR_MIN.getValor(),
                    valorMaximo = Controle.ASCII_VALOR_MAX.getValor();

            //atrelando os dois caracteres iniciais com o nome da pessoa
            login[0] = txtNome.getText().charAt(0);
            if (txtNome.getText().length() > 1) {
                login[1] = txtNome.getText().charAt(1);
            } else {
                login[1] = txtNome.getText().charAt(0);
            }

            //me baseando no valor do Enum para a parada do laço
            for (int i = 2; i < Controle.NUM_CARACTERES_LOGIN.getValor(); i++) {
                //atribuindo a cada posição do vetor um char, que será gerado randomicamente
                //entre os valores mínimos e máximos
                login[i] = (char) (valorMinimo + random.nextInt(valorMaximo - valorMinimo));
            }

            //:::::::::::::::::::::::::::::: SENHA ::::::::::::::::::::::::::::::
            //me baseando no valor do Enum para a parada do laço
            for (int i = 0; i < Controle.NUM_CARACTERES_SENHA.getValor(); i++) {
                //atribuindo a cada posição desse vetor um número aleatório (que vai até o 9), na base 10
                senha[i] = Character.forDigit(random.nextInt(9), 10);
            }

            //:::::::::::::::::::::::::::::: ATRIBUINDO VALORES ::::::::::::::::::::::::::::::
            //copyValueOf() transforma um vetor de chars em uma String :)
            this.login = String.copyValueOf(login);
            this.senha = String.copyValueOf(senha);

            //Log para controle
            //System.out.println("Login gerado: "+this.login+" Senha gerada: "+this.senha);
        } //execução da lógica enquanto o login e a senha não forem exclusivos
        while (!this.employeeDAO.IsUniqueLogin(this.login, this.senha));
    }

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            for (Professions profession : p.SelectAllProfessions()) {
                this.profissaoProfSaude.addItem(profession);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastro_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formComponentShown

    private void profissaoProfSaudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profissaoProfSaudeActionPerformed
        try {
            this.especialProfSaude.removeAllItems();
            int professionsID = ((Professions) this.profissaoProfSaude.getSelectedItem()).getId();

            for (Specialization specialization : this.specializationDAO.SelectSpecializations(professionsID)) {
                this.especialProfSaude.addItem(specialization);
            }
            this.especialProfSaude.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_HealthProfessional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_profissaoProfSaudeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField cpfField;
    private javax.swing.JComboBox especialProfSaude;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelEspec;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelProfissao;
    private javax.swing.JLabel lblCadastroProfSaude;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblResultados;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JComboBox profissaoProfSaude;
    private javax.swing.JTextField registroField;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}