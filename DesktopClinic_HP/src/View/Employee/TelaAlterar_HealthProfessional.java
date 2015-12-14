package View.Employee;

import Module.DBO.ConnectionSetup;
import Module.DBO.Specialization;
import Module.DBO.HealthProfessionals;
import Module.DBO.Professions;
import Module.DBO.RegisteredEmployee;
import Module.DAO.SpecializationDAO;
import Module.DAO.RegisteredEmployeeDAO;
import Module.DAO.ProfessionsDAO;
import Module.DAO.HealthProfessionalsDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaAlterar_HealthProfessional extends javax.swing.JPanel {

    private HealthProfessionalsDAO healthProfessionalsDAO = new HealthProfessionalsDAO(ConnectionSetup.connection);
    private RegisteredEmployeeDAO registeredEmployeeDAO = new RegisteredEmployeeDAO(ConnectionSetup.connection);
    private SpecializationDAO specializationDAO = new SpecializationDAO(ConnectionSetup.connection);
    private ProfessionsDAO professionalsDAO = new ProfessionsDAO(ConnectionSetup.connection);

    private RegisteredEmployee registeredEmployee = null;
    private HealthProfessionals healthprof = null;

    int idHealthProfessional;

    public TelaAlterar_HealthProfessional() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelProfissao = new javax.swing.JLabel();
        profissaoProfSaude = new javax.swing.JComboBox();
        labelEspec = new javax.swing.JLabel();
        especialProfSaude = new javax.swing.JComboBox();
        labelNome = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeProfSaude = new javax.swing.JTextField();
        cpfField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        registroField = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        loginFIeld = new javax.swing.JTextField();
        senhaField = new javax.swing.JTextField();
        btnAlteraDisp = new javax.swing.JButton();
        labelProfissao1 = new javax.swing.JLabel();
        escolheProfissao = new javax.swing.JComboBox();
        labelEspec1 = new javax.swing.JLabel();
        escolheEspecialidade = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmployees = new javax.swing.JList();
        txtNomePesquisado = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelEspec2 = new javax.swing.JLabel();
        lblError = new java.awt.Label();
        jLabel6 = new javax.swing.JLabel();

        labelProfissao.setText("Profissão");

        labelEspec.setText("Especialidade");

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelNome.setText("Nome");
        add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("CPF");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, 20));
        add(nomeProfSaude, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 191, 20));
        add(cpfField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 191, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Registro profissional");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, 20));
        add(registroField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 191, 20));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, 100, 20));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 100, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Login");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Senha");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, 20));
        add(loginFIeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 191, 20));
        add(senhaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 191, 20));

        btnAlteraDisp.setText("Alterar disponibilidade");
        btnAlteraDisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraDispActionPerformed(evt);
            }
        });
        add(btnAlteraDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, -1, 20));

        labelProfissao1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelProfissao1.setText("Profissão");
        add(labelProfissao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, 20));

        escolheProfissao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                escolheProfissaoMouseClicked(evt);
            }
        });
        escolheProfissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escolheProfissaoActionPerformed(evt);
            }
        });
        add(escolheProfissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 191, 20));

        labelEspec1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelEspec1.setText("Especialidade");
        add(labelEspec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, 20));

        add(escolheEspecialidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 191, 20));

        lstEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstEmployees);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 240, 280));
        add(txtNomePesquisado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 170, 20));

        btnPesquisar.setText("Filtrar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 60, 20));

        jLabel1.setText("Selecionar Profissional:");
        jLabel1.setToolTipText("");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 170, 20));

        labelEspec2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelEspec2.setText("Disponibilidade");
        add(labelEspec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, -1, 20));

        lblError.setAlignment(java.awt.Label.CENTER);
        lblError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 320, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText(":: Alterar cadastro de profissional de saúde ::");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            this.lblError.setText("");
            if (!hasError()) {
                //int id, String name, String password, String login
                this.registeredEmployee = new RegisteredEmployee(idHealthProfessional, this.nomeProfSaude.getText(), this.senhaField.getText(), this.loginFIeld.getText());
                this.healthprof = new HealthProfessionals(idHealthProfessional, this.cpfField.getText(), this.registroField.getText());
                if (this.healthProfessionalsDAO.UpdateHealthProfessionals(registeredEmployee, healthprof)) {
                    JOptionPane.showMessageDialog(null, "Cadastro foi alterado com sucesso!");
                    loadHealthProfessionals();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possivel alterar o cadastro do profissional.");
                }
            } else {
                this.lblError.setText("Campos inválidos ou vazios.");
            }

        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_HealthProfessional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlteraDispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteraDispActionPerformed
        try {
            Specialization specialization = this.specializationDAO.getSpecialization(idHealthProfessional);
            if (specialization == null) {
                JOptionPane.showMessageDialog(this, "O médico não tem uma especialização. Para configurar horários de disponibilidade, preencha este campo.", "Opção indisponível", JOptionPane.ERROR_MESSAGE);
            } else {
                TelaDisponibilidades alteradisp = new TelaDisponibilidades(idHealthProfessional, specialization.getId());
                alteradisp.setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_HealthProfessional.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAlteraDispActionPerformed

    private void escolheProfissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escolheProfissaoActionPerformed
        loadSpecialization();
    }//GEN-LAST:event_escolheProfissaoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        try {
            List<RegisteredEmployee> registeredEmployees = this.healthProfessionalsDAO.SearchHealthProfessionalsByName(this.txtNomePesquisado.getText());
            this.lstEmployees.setListData(registeredEmployees.toArray());
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_HealthProfessional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void lstEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstEmployeesMouseClicked
        try {
            loadHealthProfessionalsData();
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_HealthProfessional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lstEmployeesMouseClicked

    private void escolheProfissaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_escolheProfissaoMouseClicked
        loadSpecialization();
    }//GEN-LAST:event_escolheProfissaoMouseClicked

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        try {
            loadHealthProfessionals();
            loadProfessionals();
            loadSpecialization();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCadastro_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TelaCadastro_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentAdded

    private void loadHealthProfessionalsData() throws Exception {

        if (lstEmployees.getSelectedValue() != null) {
            idHealthProfessional = ((RegisteredEmployee) lstEmployees.getSelectedValue()).getId();
            RegisteredEmployee re = this.registeredEmployeeDAO.getInfoRegisteredEmployee(idHealthProfessional);
            HealthProfessionals hp = this.healthProfessionalsDAO.getInfoHealthProfessional(idHealthProfessional);
            Specialization sp = this.specializationDAO.getSpecialization(idHealthProfessional);
            Professions pf = this.professionalsDAO.getProfession(sp.getIdProfessions());
            this.escolheEspecialidade.setSelectedItem(sp);
            this.escolheProfissao.setSelectedItem(pf);
            this.cpfField.setText(hp.getCPF());
            this.nomeProfSaude.setText(re.getName());
            this.registroField.setText(hp.getIDClass());

            this.loginFIeld.setText(re.getLogin());
            this.senhaField.setText(re.getPassword());
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um profissional.");
        }
    }

    private void loadHealthProfessionals() throws Exception {
        List<RegisteredEmployee> registeredEmployees = this.healthProfessionalsDAO.SelectAllHealthProfessionals();
        this.lstEmployees.setListData(registeredEmployees.toArray());
    }

    private void loadSpecialization() {
        try {
            this.escolheEspecialidade.removeAllItems();
            int professionsID = ((Professions) this.escolheProfissao.getSelectedItem()).getId();

            for (Specialization specialization : this.specializationDAO.SelectSpecializations(professionsID)) {
                this.escolheEspecialidade.addItem(specialization);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_HealthProfessional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadProfessionals() throws Exception {
        for (Professions profession : this.professionalsDAO.SelectAllProfessions()) {
            this.escolheProfissao.addItem(profession);
        }
    }

    private boolean hasError() {

        return this.nomeProfSaude.getText() == null || this.nomeProfSaude.getText().isEmpty()
                || this.cpfField.getText() == null || this.cpfField.getText().isEmpty()
                || this.registroField.getText() == null || this.registroField.getText().isEmpty()
                || this.loginFIeld.getText() == null || this.loginFIeld.getText().isEmpty()
                || this.senhaField.getText() == null || this.senhaField.getText().isEmpty();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlteraDisp;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField cpfField;
    private javax.swing.JComboBox escolheEspecialidade;
    private javax.swing.JComboBox escolheProfissao;
    private javax.swing.JComboBox especialProfSaude;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelEspec;
    private javax.swing.JLabel labelEspec1;
    private javax.swing.JLabel labelEspec2;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelProfissao;
    private javax.swing.JLabel labelProfissao1;
    private java.awt.Label lblError;
    private javax.swing.JTextField loginFIeld;
    private javax.swing.JList lstEmployees;
    private javax.swing.JTextField nomeProfSaude;
    private javax.swing.JComboBox profissaoProfSaude;
    private javax.swing.JTextField registroField;
    private javax.swing.JTextField senhaField;
    private javax.swing.JTextField txtNomePesquisado;
    // End of variables declaration//GEN-END:variables
}
