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

    private HealthProfessionalsDAO healthProfessionalsDAO = null;
    private RegisteredEmployeeDAO registeredEmployeeDAO = null;
    private SpecializationDAO specializationDAO = null;
    private ProfessionsDAO professionalsDAO = null;

    private RegisteredEmployee registeredEmployee = null;
    private HealthProfessionals healthprof = null;

    int idHealthProfessional;

    public TelaAlterar_HealthProfessional() {
        initComponents();

        this.registeredEmployeeDAO = new RegisteredEmployeeDAO(ConnectionSetup.connection);
        this.healthProfessionalsDAO = new HealthProfessionalsDAO(ConnectionSetup.connection);
        this.specializationDAO = new SpecializationDAO(ConnectionSetup.connection);
        this.professionalsDAO = new ProfessionsDAO(ConnectionSetup.connection);
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
        profissaoProfSaude1 = new javax.swing.JComboBox();
        labelEspec1 = new javax.swing.JLabel();
        especialProfSaude1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmployees = new javax.swing.JList();
        txtNomePesquisado = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelEspec2 = new javax.swing.JLabel();
        lblError = new java.awt.Label();

        labelProfissao.setText("Profissão");

        labelEspec.setText("Especialidade");

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelNome.setText("Nome");
        add(labelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 12, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("CPF");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 43, -1, -1));
        add(nomeProfSaude, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 11, 191, -1));
        add(cpfField, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 42, 191, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("Registro profissional");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 81, -1, -1));
        add(registroField, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 80, 191, -1));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 100, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 100, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setText("Login");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 253, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setText("Senha");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 291, -1, -1));
        add(loginFIeld, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 252, 191, -1));
        add(senhaField, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 290, 191, -1));

        btnAlteraDisp.setText("Alterar disponibilidade");
        btnAlteraDisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraDispActionPerformed(evt);
            }
        });
        add(btnAlteraDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 198, -1, -1));

        labelProfissao1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelProfissao1.setText("Profissão");
        add(labelProfissao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 126, -1, -1));

        profissaoProfSaude1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profissaoProfSaude1MouseClicked(evt);
            }
        });
        profissaoProfSaude1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profissaoProfSaude1ActionPerformed(evt);
            }
        });
        add(profissaoProfSaude1, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 118, 191, -1));

        labelEspec1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelEspec1.setText("Especialidade");
        add(labelEspec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 160, -1, -1));

        add(especialProfSaude1, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 160, 191, -1));

        lstEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstEmployees);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 200, 280));
        add(txtNomePesquisado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 165, -1));

        btnPesquisar.setText("...");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 33, -1));

        jLabel1.setText("Selecionar Profissional:");
        jLabel1.setToolTipText("");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 165, 22));

        labelEspec2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        labelEspec2.setText("Disponibilidade");
        add(labelEspec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 200, -1, -1));

        lblError.setAlignment(java.awt.Label.CENTER);
        lblError.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 330, 320, 30));
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

    private void profissaoProfSaude1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profissaoProfSaude1ActionPerformed
        loadSpecialization();
    }//GEN-LAST:event_profissaoProfSaude1ActionPerformed

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

    private void profissaoProfSaude1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profissaoProfSaude1MouseClicked
        loadSpecialization();
    }//GEN-LAST:event_profissaoProfSaude1MouseClicked

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
            this.professionalsDAO.getProfession(sp.getIdProfessions());

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
            this.especialProfSaude1.removeAllItems();
            int professionsID = ((Professions) this.profissaoProfSaude1.getSelectedItem()).getId();

            for (Specialization specialization : this.specializationDAO.SelectSpecializations(professionsID)) {
                this.especialProfSaude1.addItem(specialization);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_HealthProfessional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadProfessionals() throws Exception {
        for (Professions profession : this.professionalsDAO.SelectAllProfessions()) {
            this.profissaoProfSaude1.addItem(profession);
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
    private javax.swing.JComboBox especialProfSaude;
    private javax.swing.JComboBox especialProfSaude1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JComboBox profissaoProfSaude1;
    private javax.swing.JTextField registroField;
    private javax.swing.JTextField senhaField;
    private javax.swing.JTextField txtNomePesquisado;
    // End of variables declaration//GEN-END:variables
}
