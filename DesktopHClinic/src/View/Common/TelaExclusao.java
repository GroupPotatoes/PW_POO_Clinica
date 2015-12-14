package View.Common;

import Module.DBO.ConnectionSetup;
import Module.DBO.RegisteredEmployee;
import Module.DAO.RegisteredEmployeeDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaExclusao extends javax.swing.JPanel {

    RegisteredEmployeeDAO registeredEmployeeDAO = new RegisteredEmployeeDAO(ConnectionSetup.connection);

    public TelaExclusao() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEnunciado = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmployees = new javax.swing.JList();
        txtNomePesquisado = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setRequestFocusEnabled(false);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEnunciado.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblEnunciado.setForeground(new java.awt.Color(255, 0, 0));
        lblEnunciado.setText("<html><center>O cadastro será inativado. </center><br> <center>Ele estará disponível apenas para consulta.</center></html>");
        add(lblEnunciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 136, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 136, -1));

        lstEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstEmployeesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstEmployees);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 430, 180));
        add(txtNomePesquisado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 210, -1));

        btnPesquisar.setText("Filtrar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, -1, -1));

        jLabel1.setText("Selecionar Profissional:");
        jLabel1.setToolTipText("");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 165, 22));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText(":: Excluir funcionário ::");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            if (this.lstEmployees.getSelectedValue() != null) {
                int idRegisteredEmployee = ((RegisteredEmployee) this.lstEmployees.getSelectedValue()).getId();
                if (registeredEmployeeDAO.DisableregisteredEmployee(idRegisteredEmployee)) {
                    JOptionPane.showMessageDialog(null, "<html><center>Seu cadastro foi inativado.</center><br>"
                            + "<center> Procure um administrador do sistema para reativá-lo.</center></html>");

                    this.setVisible(false);
                } else {
                    lblEnunciado.setText("<html><center> Sinto muito, houve algum problema ao inativar seu cadastro.</center>"
                            + "<br><center>Tente novamente ou contate um administrador do sistema.</center</html>");

                }

                btnExcluir.setVisible(false);
                btnCancelar.setVisible(false);
            } else {
                lblEnunciado.setText("Nenhum profissional foi selecionado. Selecione um para desabilitar!");
            }
        } catch (SQLException ex) {
            lblEnunciado.setText("<html><center> Sinto muito, houve algum problema ao inativar seu cadastro.</center>"
                    + "<br><center>Tente novamente ou contate um administrador do sistema.</center</html>");

            Logger.getLogger(TelaExclusao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        super.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lstEmployeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstEmployeesMouseClicked
        /*  try {
            loadHealthProfessionalsData();
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterar_HealthProfessional.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_lstEmployeesMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            List<RegisteredEmployee> registeredEmployees = this.registeredEmployeeDAO.SearchregisteredEmployee(this.txtNomePesquisado.getText());
            this.lstEmployees.setListData(registeredEmployees.toArray());
        } catch (Exception ex) {
            Logger.getLogger(TelaExclusao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
        try {
            loadRegisteredEmployee();
        } catch (Exception ex) {
            Logger.getLogger(TelaExclusao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentAdded

    private void loadRegisteredEmployee() throws Exception {
        List<RegisteredEmployee> registeredEmployees = this.registeredEmployeeDAO.SelectAllRegisteredEmployee();
        this.lstEmployees.setListData(registeredEmployees.toArray());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnunciado;
    private javax.swing.JList lstEmployees;
    private javax.swing.JTextField txtNomePesquisado;
    // End of variables declaration//GEN-END:variables
}
