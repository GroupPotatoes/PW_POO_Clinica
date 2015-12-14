package View.Employee;

import Module.DBO.ConnectionSetup;
import Module.DBO.Employee;
import Module.DAO.EmployeeDAO;
import Module.DBO.RegisteredEmployee;
import Module.DAO.RegisteredEmployeeDAO;
import Module.DBO.Role;
import Module.DAO.RoleDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaAlterar_EmployeeF extends javax.swing.JFrame {

    private EmployeeDAO employeeDAO = null;
    private RoleDAO roleDAO = null;
    private RegisteredEmployeeDAO registeredEmployeeDAO = null;

    public TelaAlterar_EmployeeF() {

        this.employeeDAO = new EmployeeDAO(ConnectionSetup.connection);
        this.roleDAO = new RoleDAO(ConnectionSetup.connection);
        this.registeredEmployeeDAO = new RegisteredEmployeeDAO(ConnectionSetup.connection);

        initComponents();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        btnAlterar = new javax.swing.JButton();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblError = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        cbbTipo = new javax.swing.JComboBox();
        lblNome1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmployees = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        txtNomePesquisado = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        btnAlterar.setText("Alterar dados");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(380, 260, 100, 31);

        lblLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblLogin.setText("Login:");
        getContentPane().add(lblLogin);
        lblLogin.setBounds(270, 130, 34, 15);
        lblLogin.getAccessibleContext().setAccessibleName("Login");

        getContentPane().add(txtLogin);
        txtLogin.setBounds(330, 130, 152, 20);

        lblSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(270, 160, 39, 15);

        lblNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNome.setText("Nome:");
        getContentPane().add(lblNome);
        lblNome.setBounds(270, 100, 37, 15);
        getContentPane().add(txtNome);
        txtNome.setBounds(330, 100, 152, 20);

        lblError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblError);
        lblError.setBounds(680, 290, 209, 34);
        lblError.getAccessibleContext().setAccessibleName("lblError");

        btnVoltar.setText("Fechar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(270, 260, 102, 31);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(330, 160, 152, 20);

        getContentPane().add(cbbTipo);
        cbbTipo.setBounds(330, 190, 148, 20);

        lblNome1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNome1.setText("Tipo");
        getContentPane().add(lblNome1);
        lblNome1.setBounds(270, 190, 39, 22);

        jScrollPane1.setViewportView(lstEmployees);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 90, 200, 280);

        jLabel1.setText("Selecionar Profissional:");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 30, 165, 22);
        getContentPane().add(txtNomePesquisado);
        txtNomePesquisado.setBounds(40, 60, 165, 20);

        btnPesquisar.setText("...");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(210, 60, 33, 23);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            this.lblError.setText("");

            if (this.lstEmployees.getSelectedValue() == null) {
                this.lblError.setText("Não foi possivel alterar dados.");
            } else if (!hasError()) {
                int idRegisteredEmployee = ((RegisteredEmployee) this.lstEmployees.getSelectedValue()).getId();
                int idType = ((Role) this.cbbTipo.getSelectedItem()).getId();

                RegisteredEmployee registeredEmployee = new RegisteredEmployee(idRegisteredEmployee, this.txtNome.getText(), this.txtSenha.getText(), this.txtLogin.getText());
                Employee employee = new Employee(idType);

                if (registeredEmployeeDAO.UpdateEmployee(registeredEmployee, employee)) {
                    JOptionPane.showMessageDialog(null, "Perfil foi alterado com sucesso!");
                    carregarProfissionais();
                    //this.setVisible(false);
                } else {
                    this.lblError.setText("Não foi possivel alterar dados.");
                }
            } else {
                this.lblError.setText("Campos preenchidos incorretamente.");
            }

        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown

        try {
            carregarRole();
            carregarProfissionais();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaAlterar_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_formComponentShown

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        try {
            List<RegisteredEmployee> registeredEmployees = this.employeeDAO.SearchEmployee(this.txtNomePesquisado.getText());
            this.lstEmployees.setListData(registeredEmployees.toArray());
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private boolean hasError() {

        return this.txtNome.getText() == null || this.txtNome.getText().isEmpty()
                || this.txtSenha.getText() == null || this.txtSenha.getText().isEmpty()
                || this.txtLogin.getText() == null || this.txtLogin.getText().isEmpty();
    }

    private void carregarRole() throws Exception {
        for (Role role : this.roleDAO.SelectAllRole()) {
            this.cbbTipo.addItem(role);
        }
    }

    private void carregarProfissionais() throws Exception {
        List<RegisteredEmployee> registeredEmployees = this.employeeDAO.SelectAllEmployee();
        this.lstEmployees.setListData(registeredEmployees.toArray());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cbbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JList lstEmployees;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomePesquisado;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
