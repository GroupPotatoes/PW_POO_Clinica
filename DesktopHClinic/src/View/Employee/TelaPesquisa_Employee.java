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

        setMaximumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(300, 300));

        lblEnunciado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblEnunciado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnunciado.setText("<html><center>Para efetuar sua pesquisa, digite um nome ou parte do nome do funcionário:</center></html>");
        lblEnunciado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblEnunciado.setFocusable(false);
        lblEnunciado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtItemPesquisado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPesquisar.setText("Busca");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstResultado);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText(":: Pesquisar funcionários ::");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEnunciado, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtItemPesquisado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEnunciado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItemPesquisado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
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
