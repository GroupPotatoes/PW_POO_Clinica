package View.Employee;

import Module.DBO.ConnectionSetup;
import Module.DBO.RegisteredEmployee;
import Module.DAO.RegisteredEmployeeDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaPesquisa_Employee extends javax.swing.JPanel {

    public TelaPesquisa_Employee() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEnunciado = new javax.swing.JLabel();
        txtItemPesquisado = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstResultado = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEnunciado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEnunciado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnunciado.setText("Para efetuar sua pesquisa, digite um nome ou parte do nome do funcionário:");
        lblEnunciado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblEnunciado.setFocusable(false);
        lblEnunciado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(lblEnunciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 610, 50));

        txtItemPesquisado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        add(txtItemPesquisado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 220, 27));

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPesquisar.setText("Busca");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 100, 30));

        jScrollPane1.setViewportView(lstResultado);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 430, 230));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText(":: Pesquisar funcionários ::");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, 14));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            RegisteredEmployeeDAO registeredEmployeeDAO = new RegisteredEmployeeDAO(ConnectionSetup.connection);

            List<RegisteredEmployee> registeredEmployeeList = registeredEmployeeDAO.SearchregisteredEmployee(this.txtItemPesquisado.getText());

            if (registeredEmployeeList.size() > 0) {
                this.lstResultado.setListData(registeredEmployeeList.toArray());
            } else {
                //TODO: o form fecha depois que exibe o erro
                this.lstResultado.setListData(new Object[0]);
                this.txtItemPesquisado.setText("");
                //JOptionPane.showMessageDialog(null, "Nenhum dado encontrado.", "Sem dados!", INFORMATION_MESSAGE);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPesquisa_Employee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisa_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnunciado;
    private javax.swing.JList lstResultado;
    private javax.swing.JTextField txtItemPesquisado;
    // End of variables declaration//GEN-END:variables
}
