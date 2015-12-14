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
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setRequestFocusEnabled(false);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
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
        btnFechar.setMaximumSize(new java.awt.Dimension(200, 23));
        btnFechar.setMinimumSize(new java.awt.Dimension(200, 23));
        btnFechar.setPreferredSize(new java.awt.Dimension(200, 23));

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setMaximumSize(new java.awt.Dimension(200, 23));
        btnConfirmar.setMinimumSize(new java.awt.Dimension(200, 23));
        btnConfirmar.setPreferredSize(new java.awt.Dimension(200, 23));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(":: Alterar Consulta Realizada ::");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConsultasRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRequisicaoDeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRecomendacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConsultasRealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRequisicaoDeExame, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRecomendacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
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

    
    
    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        try {
            carregarConsultasValidas();
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterarConsultaRealizada_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentAdded

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
    private javax.swing.JLabel jLabel1;
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
