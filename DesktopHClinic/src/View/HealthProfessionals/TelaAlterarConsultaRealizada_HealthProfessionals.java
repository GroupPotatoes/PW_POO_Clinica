package View.HealthProfessionals;

import Module.DBO.ConnectionSetup;
import Module.DAO.DoctorAppointmentDAO;
import Module.DBO.DoctorAppointment;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaAlterarConsultaRealizada_HealthProfessionals extends javax.swing.JPanel {
    
    private DoctorAppointmentDAO doctorAppointmentDAO = null;

    public TelaAlterarConsultaRealizada_HealthProfessionals() {
        initComponents();
        
        doctorAppointmentDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtPrescricao = new javax.swing.JTextArea();
        lblObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstConsultas = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtObservacao = new javax.swing.JTextArea();
        lblRecomendacoes = new javax.swing.JLabel();
        lblConsultasRealizadas = new javax.swing.JLabel();
        lblPrescricao = new javax.swing.JLabel();
        lblRequisicaoDeExame = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtRequisicaoDeExame = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtRecomendacao = new javax.swing.JTextArea();
        lblError = new javax.swing.JLabel();
        btnFechar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        txtPrescricao.setColumns(20);
        txtPrescricao.setRows(5);
        jScrollPane2.setViewportView(txtPrescricao);

        lblObservacao.setText("Observação:");

        jScrollPane1.setViewportView(lstConsultas);

        txtObservacao.setColumns(20);
        txtObservacao.setRows(5);
        jScrollPane6.setViewportView(txtObservacao);

        lblRecomendacoes.setText("Recomendações:");

        lblConsultasRealizadas.setText("Consultas Realizadas:");
        lblConsultasRealizadas.setToolTipText("");

        lblPrescricao.setText("Prescrição:");

        lblRequisicaoDeExame.setText("Requisição de exames:");

        txtRequisicaoDeExame.setColumns(20);
        txtRequisicaoDeExame.setRows(5);
        jScrollPane4.setViewportView(txtRequisicaoDeExame);

        txtRecomendacao.setColumns(20);
        txtRecomendacao.setRows(5);
        jScrollPane3.setViewportView(txtRecomendacao);

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnFechar.setText("Fechar");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRequisicaoDeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRecomendacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblConsultasRealizadas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(57, 57, 57))))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConsultasRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRequisicaoDeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRecomendacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnFechar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        try {

            this.lblError.setForeground(Color.RED);
            this.lblError.setText("");
            if(lstConsultas.getSelectedValue() != null)
            {
                DoctorAppointment doctorAppointment =  ((DoctorAppointment)lstConsultas.getSelectedValue());
                doctorAppointment.setObservation(this.txtObservacao.getText());
                doctorAppointment.setMedicalExamRequest(this.txtRequisicaoDeExame.getText());
                doctorAppointment.setPrescription(this.txtPrescricao.getText());
                doctorAppointment.setRecommendation(this.txtRecomendacao.getText());

                if(doctorAppointmentDAO.InsertDoctorAppointmentResult(doctorAppointment))
                {
                    this.lblError.setForeground(Color.GREEN);
                    this.lblError.setText("Consulta Alterada!");
                }
                else
                this.lblError.setText("Não foi possível alterar consulta.");
            }
            else
            this.lblError.setText("Selecione uma consulta!");
        }
        catch (Exception ex) {
            Logger.getLogger(TelaAlterarConsultaRealizada_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    
    
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            carregarConsultasValidas();
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterarConsultaRealizada_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void carregarConsultasValidas() throws Exception{
        this.lblError.setText("");
        List<DoctorAppointment> consultas = this.doctorAppointmentDAO.SelectDoctorAppointmentUntilCurrentDate();
        if(consultas.isEmpty())
            this.lblError.setText("Não há consultas para serem exibidas.");
        else
        {
            this.lstConsultas.setListData(consultas.toArray());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblConsultasRealizadas;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JLabel lblPrescricao;
    private javax.swing.JLabel lblRecomendacoes;
    private javax.swing.JLabel lblRequisicaoDeExame;
    private javax.swing.JList lstConsultas;
    private javax.swing.JTextArea txtObservacao;
    private javax.swing.JTextArea txtPrescricao;
    private javax.swing.JTextArea txtRecomendacao;
    private javax.swing.JTextArea txtRequisicaoDeExame;
    // End of variables declaration//GEN-END:variables
}
