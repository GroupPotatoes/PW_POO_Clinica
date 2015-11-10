package View;

import Module.DAO.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaDisponibilidades extends javax.swing.JFrame {

    private int id;
    private int idHealthProfessionals;
    private int idSpecialization;
    List<Availability> workdays = new ArrayList<Availability>();
//    private int weekDay;
//    private String iniciation;
//    private String finish;
//    private int inicio;
//    private int fim;

    public TelaDisponibilidades(int idHealthProfessionals, int idSpecialization) {
        this.idHealthProfessionals = idHealthProfessionals;
        this.idSpecialization = idSpecialization;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelDisponib = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnConfirma = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        horInicio = new javax.swing.JComboBox();
        horFim = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        diasDaSemana = new javax.swing.JComboBox();
        btnAdicionar = new javax.swing.JButton();
        lblHorarios = new javax.swing.JLabel();
        cmbDuracao = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Disponibilidade do profissional");
        setAlwaysOnTop(true);

        labelDisponib.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelDisponib.setText(":: Horários disponíveis para consulta ::");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Selecione cada dia da semana e depois marque os horários disponíveis");

        btnConfirma.setText("Confirmar");
        btnConfirma.setToolTipText("");
        btnConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaActionPerformed(evt);
            }
        });

        btnCancela.setText("Cancelar");
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        jLabel2.setText("Dia da semana");

        jLabel3.setText("Início");

        jLabel4.setText("Fim");

        horInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" }));
        horInicio.setSelectedIndex(-1);
        horInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horInicioActionPerformed(evt);
            }
        });

        horFim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" }));
        horFim.setSelectedIndex(-1);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel5.setText("<html><center>Os horários serão salvos quando você clicar em <i>ADICIONAR</i>.  <br> O horário será exibido no lado direito da tela. <br> Confirme para salvar todos.</center></html>");

        diasDaSemana.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Domingo", "Segunda", "Terca", "Quarta", "Quinta", "Sexta", "Sabado" }));
        diasDaSemana.setSelectedIndex(-1);
        diasDaSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diasDaSemanaActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        lblHorarios.setText("Os horários aparecerão aqui! :)");
        lblHorarios.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        cmbDuracao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "15 min", "30 min", "45 min", "60 min" }));
        cmbDuracao.setSelectedIndex(-1);
        cmbDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDuracaoActionPerformed(evt);
            }
        });

        jLabel6.setText("Duração da consulta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdicionar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(horInicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(horFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(cmbDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(diasDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnCancela)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirma)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(labelDisponib))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelDisponib)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirma))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diasDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(horInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(horFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdicionar)
                            .addComponent(btnCancela))))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaActionPerformed
        //quando o botão confirmar é pressionado
        try {
            AvailabilityDAO insert = new AvailabilityDAO(ConnectionSetup.connection);
            //envia para o BD cada availability, que foram alocadas em uma lista chamada workdays
            System.out.println(workdays.toString());
            if(insert.setAvailability(this.workdays)) {
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Ocorreu um erros ao adicionar os horários. Tente novamente ou contate um administrador.", "Erro ao adicionar os horários", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmaActionPerformed

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelaActionPerformed
    
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        /*
         verificar se availability do index do dia da semana já existe SENAO
         criar availability com o index do dia da semana selecionado, os horarios inicio e fim 
         selecionados e salvar no workdays
         TODO: printar no label 
         */
        if (this.cmbDuracao.getSelectedIndex()!= -1 && this.diasDaSemana.getSelectedIndex() != -1 && this.horInicio.getSelectedIndex() != -1 && this.horFim.getSelectedIndex() != -1 && validateSchedule()) {
            int dia = this.diasDaSemana.getSelectedIndex() + 1;
            
            String iniciation = (String) this.horInicio.getSelectedItem() + ":00";
            String finish = (String) this.horFim.getSelectedItem() + ":00";
            //Verificação inutilizada!! verifica se o workday já foi definido e o usuário vai resetar o valor para outro valor:
//            for (Availability workday : workdays) {
//                if (workday.getWeekDay() == dia) {
//                    try {
//                        workday.setIniciation(iniciation);
//                        workday.setFinish(finish);
//                        this.setLabelHorario();
//                        return;
//                    } catch (Exception ex) {
//                        Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }

            try {
                workdays.add(new Availability(this.idHealthProfessionals, this.idSpecialization, dia, iniciation, finish));
                this.setLabelHorario();
            } catch (Exception ex) {
                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //brotar um joptionpane de erro
            JOptionPane.showMessageDialog(this, "Horário inválido! Por favor, preencha todos os itens corretamente antes de adicionar.", "Erro ao adicionar o horário", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed
    
    private boolean validateSchedule() {
        if(this.horInicio.getSelectedIndex() > this.horFim.getSelectedIndex()) {
            return false;
        } else {
            return true;
        }
    }
    
    private void diasDaSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diasDaSemanaActionPerformed
        //olhar lista workdays:
        //  caso vazia: setar index das combos inicio e fim para -1
        //  caso exista valor para o dia selecionado, carregar nas combos abaixo
//        int dia = this.diasDaSemana.getSelectedIndex() + 1;
//        if (this.workdays.isEmpty()) {
//            this.horInicio.setSelectedIndex(-1);
//            this.horFim.setSelectedIndex(-1);
//        } else {
//            for (Availability workday : workdays) {
//                if (workday.getWeekDay() == dia) {
//                    this.horInicio.setSelectedIndex(dia - 1);
//                    this.horFim.setSelectedIndex(dia - 1);
//                }
//            }
//        }
    }//GEN-LAST:event_diasDaSemanaActionPerformed

    private void cmbDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDuracaoActionPerformed
        switch(this.cmbDuracao.getSelectedIndex()) {
            case 0: //15min
                horInicio.setModel(new javax.swing.DefaultComboBoxModel(
                        new String[] { "08:00", "08:15", "08:30", "08:45", 
                                       "09:00", "09:15", "09:30", "09:45",
                                       "10:00", "10:15", "10:30", "10:45",
                                       "11:00", "11:15", "11:30", "11:45",
                                       "12:00", "12:15", "12:30", "12:45",
                                       "13:00", "13:15", "13:30", "13:45",
                                       "14:00", "14:15", "14:30", "14:45",
                                       "15:00", "15:15", "15:30", "15:45",
                                       "16:00", "16:15", "16:30", "16:45",
                                       "17:00", "17:15", "17:30", "17:45",
                                       "18:00", "18:15", "18:30", "18:45", "19:00"
                                      }));
                horFim.setModel(new javax.swing.DefaultComboBoxModel(
                        new String[] { "08:15", "08:30", "08:45", 
                                       "09:00", "09:15", "09:30", "09:45",
                                       "10:00", "10:15", "10:30", "10:45",
                                       "11:00", "11:15", "11:30", "11:45",
                                       "12:00", "12:15", "12:30", "12:45",
                                       "13:00", "13:15", "13:30", "13:45",
                                       "14:00", "14:15", "14:30", "14:45",
                                       "15:00", "15:15", "15:30", "15:45",
                                       "16:00", "16:15", "16:30", "16:45",
                                       "17:00", "17:15", "17:30", "17:45",
                                       "18:00", "18:15", "18:30", "18:45", "19:00"
                                      }));
                break;
            case 1: //30min
                horInicio.setModel(new javax.swing.DefaultComboBoxModel(
                        new String[] { "08:00", "08:30", "09:00", "09:30", 
                                       "10:00", "10:30", "11:00", "11:30",
                                       "12:00", "12:30", "13:00", "13:30",
                                       "14:00", "14:30", "15:00", "15:30",
                                       "16:00", "16:30", "17:00", "17:30",
                                       "18:00", "18:30", "19:00"
                                      }));
                horFim.setModel(new javax.swing.DefaultComboBoxModel(
                        new String[] { "08:30", "09:00", "09:30", 
                                       "10:00", "10:30", "11:00", "11:30",
                                       "12:00", "12:30", "13:00", "13:30",
                                       "14:00", "14:30", "15:00", "15:30",
                                       "16:00", "16:30", "17:00", "17:30",
                                       "18:00", "18:30", "19:00"
                                      }));
                break;
            case 2: //45min
                horInicio.setModel(new javax.swing.DefaultComboBoxModel(
                        new String[] { "08:00", "08:45", "09:30", "10:15",
                                       "11:00", "11:45", "12:30", "13:15",
                                       "14:00", "14:45", "15:30", "16:15",
                                       "17:30", "18:15", "19:00"
                                      }));
                horFim.setModel(new javax.swing.DefaultComboBoxModel(
                        new String[] { "08:45", "09:30", "10:15",
                                       "11:00", "11:45", "12:30", "13:15",
                                       "14:00", "14:45", "15:30", "16:15",
                                       "17:30", "18:15", "19:00"
                                      }));
                break;
            case 3: //60min
                horInicio.setModel(new javax.swing.DefaultComboBoxModel(
                        new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", 
                            "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" }));
                horFim.setModel(new javax.swing.DefaultComboBoxModel(
                        new String[] { "09:00", "10:00", "11:00", "12:00", 
                            "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" }));
                break;
        }
    }//GEN-LAST:event_cmbDuracaoActionPerformed

    private void horInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horInicioActionPerformed
        this.horFim.setSelectedIndex(this.horInicio.getSelectedIndex());
        this.horFim.setEnabled(false);
    }//GEN-LAST:event_horInicioActionPerformed

    private void setLabelHorario() {
        this.lblHorarios.setText(structureSchedule());
    }
    
    private String structureSchedule() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html>");
        for(Availability workday : this.workdays) {
            buffer.append(workday.toString());
            buffer.append("<br>");
        }
        buffer.append("</html>");
        return buffer.toString();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnConfirma;
    private javax.swing.JComboBox cmbDuracao;
    private javax.swing.JComboBox diasDaSemana;
    private javax.swing.JComboBox horFim;
    private javax.swing.JComboBox horInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelDisponib;
    private javax.swing.JLabel lblHorarios;
    // End of variables declaration//GEN-END:variables
}
