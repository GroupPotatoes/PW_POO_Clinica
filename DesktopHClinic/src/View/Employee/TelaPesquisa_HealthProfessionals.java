package View.Employee;

import Module.DBO.ConnectionSetup;
import Module.DAO.HealthProfessionalsDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaPesquisa_HealthProfessionals extends javax.swing.JPanel {

    public TelaPesquisa_HealthProfessionals() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtItemPesquisado = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstResultado = new javax.swing.JList();
        cboFiltro = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtItemPesquisado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        add(txtItemPesquisado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 340, 27));

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPesquisar.setText("Buscar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 90, 30));

        jScrollPane1.setViewportView(lstResultado);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 430, 240));

        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Registro", "Nome", "Tipo de profissional", "Especialidade" }));
        add(cboFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 156, 26));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Para efetuar sua pesquisa, digite um nome ou parte do nome do funcionário:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 520, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Filtrar:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 63, -1));

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 397, 35));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText(":: Pesquisar profissionais de saúde ::");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            this.lblError.setText("");
            HealthProfessionalsDAO hpDAO = new HealthProfessionalsDAO(ConnectionSetup.connection);
            List<String> resultados = hpDAO.SearchHealthProfessionals(this.cboFiltro.getSelectedItem().toString(), this.txtItemPesquisado.getText());

            if (resultados.size() > 0) {
                this.lstResultado.setListData(resultados.toArray());
                this.lblError.setText("Não foi encontrado resultados.");
            } else {
                //TODO: o form fecha depois que exibe o erro
                this.lstResultado.setListData(new Object[0]);
                this.txtItemPesquisado.setText("");
                //JOptionPane.showMessageDialog(null, "Nenhum dado encontrado.", "Sem dados!", INFORMATION_MESSAGE);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPesquisa_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TelaPesquisa_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox cboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JList lstResultado;
    private javax.swing.JTextField txtItemPesquisado;
    // End of variables declaration//GEN-END:variables
}
