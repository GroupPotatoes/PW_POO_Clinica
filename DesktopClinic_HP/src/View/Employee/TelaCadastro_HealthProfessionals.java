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
    private RegisteredEmployeeDAO employeeDAO = new RegisteredEmployeeDAO(ConnectionSetup.connection);
    private HealthProfessionalsDAO hpDAO = new HealthProfessionalsDAO(ConnectionSetup.connection);
    private ProfessionsDAO p = new ProfessionsDAO(ConnectionSetup.connection);
    private SpecializationDAO specializationDAO  = new SpecializationDAO(ConnectionSetup.connection);
    private String login = null;
    private String senha = null;
    private String nome = null;
    private String cpf = null;
    private String registro = null;

    public TelaCadastro_HealthProfessionals() {
        initComponents();

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

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCadastroProfSaude.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCadastroProfSaude.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCadastroProfSaude.setText(":: Cadastro de Profissional de Saúde ::");
        add(lblCadastroProfSaude, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 728, -1));

        labelNome.setText("Nome Completo");
        add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));
        add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 250, -1));

        labelProfissao.setText("Profissão");
        add(labelProfissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        labelEspec.setText("Especialidade");
        add(labelEspec, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, -1, -1));

        profissaoProfSaude.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profissaoProfSaudeActionPerformed(evt);
            }
        });
        add(profissaoProfSaude, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 250, -1));

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, -1, -1));

        add(especialProfSaude, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 250, -1));

        lblResultados.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblResultados.setForeground(new java.awt.Color(102, 102, 102));
        lblResultados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResultados.setText("_Resultados do Cadastro");
        add(lblResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 730, -1));

        lblLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblLogin.setText("Login gerado");
        add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, -1, -1));

        txtLogin.setText("Nenhum login gerado");
        add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, 202, -1));

        txtSenha.setText("Nenhuma senha gerada");
        add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 202, -1));

        lblSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSenha.setText("Senha gerada");
        add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, -1, -1));

        jLabel1.setText("CPF");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));
        add(cpfField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 250, -1));

        jLabel2.setText("Registro profissional");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel3.setText("(exemplos: CRO, CRM, CREFITO)");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));
        add(registroField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 250, -1));
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

    private void profissaoProfSaudeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profissaoProfSaudeActionPerformed
        try {
            this.especialProfSaude.removeAllItems();
            int professionsID = ((Professions) this.profissaoProfSaude.getSelectedItem()).getId();

            for (Specialization specialization : this.specializationDAO.SelectSpecializations(professionsID)) {
                this.especialProfSaude.addItem(specialization);
            }
            this.especialProfSaude.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastro_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_profissaoProfSaudeActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here
        try {
            for (Professions profession : p.SelectAllProfessions()) {
                this.profissaoProfSaude.addItem(profession);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastro_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentAdded


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
