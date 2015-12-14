package View.HealthProfessionals;

import Module.DBO.ConnectionSetup;
import Module.DBO.DoctorAppointment;
import Module.DAO.DoctorAppointmentDAO;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaRemoverAlterarConsulta_HealthProfessionalsF extends javax.swing.JFrame {

    private DoctorAppointmentDAO doctorAppointmentDAO = null;
    
    public TelaRemoverAlterarConsulta_HealthProfessionalsF() {
        initComponents();
        
        this.doctorAppointmentDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstConsultas = new javax.swing.JList();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 363, 35));

        jScrollPane1.setViewportView(lstConsultas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 480, 121));

        btnCancelar.setText("Fechar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 134, -1));

        jLabel1.setText("Consultas:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 480, 22));

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 134, -1));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 134, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            carregarConsultas();
        } catch (Exception ex) {
            Logger.getLogger(TelaRemoverAlterarConsulta_HealthProfessionalsF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
           
            this.lblError.setForeground(Color.RED);
            this.lblError.setText("");
            
            if(lstConsultas.getSelectedValue() != null){
                int idDoctorAppointment = ((DoctorAppointment)lstConsultas.getSelectedValue()).getId();

                    if(this.doctorAppointmentDAO.RemoveDoctorAppointment(idDoctorAppointment))
                    {
                        this.lblError.setForeground(Color.GREEN);
                        this.lblError.setText("Removido!");
                        try {
                            recarregarForm();
                        } catch (Exception ex) {
                            Logger.getLogger(TelaRemoverAlterarConsulta_HealthProfessionalsF.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                        this.lblError.setText("Não foi possível remover essa consulta.");
            }
            else{
                this.lblError.setText("Selecione uma consulta para excluir!");
            }
        } catch (SQLException ex) {
                Logger.getLogger(TelaRemoverAlterarConsulta_HealthProfessionalsF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       try { 
            lblError.setText("");
            if(this.lstConsultas.getSelectedValue() != null)
            {
                TelaAlterarConsulta_HealthProfessionalsF telaAlterarConsulta = new TelaAlterarConsulta_HealthProfessionalsF();
                telaAlterarConsulta.setConsulta(((DoctorAppointment)this.lstConsultas.getSelectedValue()));
                telaAlterarConsulta.setVisible(true);
                recarregarForm();
            }
            else
                lblError.setText("Selecione uma consulta para alterar!"); 
        } catch (Exception ex) {
                Logger.getLogger(TelaRemoverAlterarConsulta_HealthProfessionalsF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
         try {
            recarregarForm();
        } catch (Exception ex) {
            Logger.getLogger(TelaRemoverAlterarConsulta_HealthProfessionalsF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void carregarConsultas() throws Exception{
       lblError.setText("");
       List<DoctorAppointment> doctorAppointments = this.doctorAppointmentDAO.SelectDoctorAppointmentByHealthProfessionals(ConnectionSetup.id);
       if(!doctorAppointments.isEmpty())
            this.lstConsultas.setListData(doctorAppointments.toArray());  
       else
           lblError.setText("Não há consultas para exibir.");
    }
    
    private void recarregarForm() throws Exception{
        carregarConsultas();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblError;
    private javax.swing.JList lstConsultas;
    // End of variables declaration//GEN-END:variables
}
