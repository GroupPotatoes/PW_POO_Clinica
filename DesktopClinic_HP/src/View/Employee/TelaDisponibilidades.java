package View.Employee;

import Module.DBO.ConnectionSetup;
import Module.DBO.Availability;
import Module.DAO.AvailabilityDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaDisponibilidades extends javax.swing.JFrame {

    private int id;
    private int idHealthProfessionals;
    private int idSpecialization;
    List<Availability> workdays = new ArrayList<Availability>();
    List<Availability> toAdd = new ArrayList<Availability>();
    List<Availability> toDelete = new ArrayList<Availability>();

    public TelaDisponibilidades(int idHealthProfessionals, int idSpecialization) {
        this.idHealthProfessionals = idHealthProfessionals;
        this.idSpecialization = idSpecialization;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRemover = new javax.swing.JButton();
        labelDisponib = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbDuracao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        diasDaSemana = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        horInicio = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        horFim = new javax.swing.JComboBox();
        btnRemover1 = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnConfirma = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstHorarios = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        labelDisponib.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelDisponib.setText(":: Horários disponíveis para consulta ::");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("<html><center>Selecione cada dia da semana e depois marque os horários disponíveis<br>\nExiste um intervalo de 10 minutos entre as consultas.</center></html>");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel5.setText("<html><center>Os horários serão salvos quando você clicar em <i>ADICIONAR</i>.  <br> O horário será exibido no lado direito da tela. <br> Confirme para salvar todos.</center></html>");

        jLabel7.setText("Duração da consulta");

        cmbDuracao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "15 min", "30 min", "45 min", "60 min" }));
        cmbDuracao.setSelectedIndex(-1);
        cmbDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDuracaoActionPerformed(evt);
            }
        });

        jLabel2.setText("Dia da semana");

        diasDaSemana.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Domingo", "Segunda", "Terca", "Quarta", "Quinta", "Sexta", "Sabado" }));
        diasDaSemana.setSelectedIndex(-1);
        diasDaSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diasDaSemanaActionPerformed(evt);
            }
        });

        jLabel3.setText("Início");

        horInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" }));
        horInicio.setSelectedIndex(-1);
        horInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horInicioActionPerformed(evt);
            }
        });

        jLabel4.setText("Fim");

        horFim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" }));
        horFim.setSelectedIndex(-1);

        btnRemover1.setText("Remover");
        btnRemover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemover1ActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnCancela.setText("Cancelar");
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        btnConfirma.setText("Confirmar");
        btnConfirma.setToolTipText("");
        btnConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstHorarios);

        jLabel6.setText("Horários selecionados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(labelDisponib))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(diasDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(cmbDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4))
                                            .addGap(48, 48, 48)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(horFim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(horInicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(btnAdicionar))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnRemover1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancela)
                                .addGap(18, 18, 18)
                                .addComponent(btnConfirma))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelDisponib)
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diasDaSemana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(horInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(horFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRemover1)
                            .addComponent(btnAdicionar)
                            .addComponent(btnCancela)
                            .addComponent(btnConfirma))
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDuracaoActionPerformed
        //formula pra ver se funciona c/ pausa de 10 min entre consultas

        //variaveis para setar horario de inicio
        int hrIn = 8;
        int minIn = 0;

        //transforma a string de duracao (15 min, por exemplo) em só os dois 1os. numeros
        String consulta = (String) this.cmbDuracao.getSelectedItem();
        consulta = consulta.substring(0, consulta.length() - 4);
        int duracao = Integer.parseInt(consulta);

        //inicio contador i zerado
        int i = 0;
        //declaro uma lista para horarios de inicio
        String[] horarioInicio = new String[50];
        //while de horario de inicio, enquanto não chegar na hora 20
        while (hrIn != 20) {
            if (minIn == 0) { //se os minutos estão zerados
                horarioInicio[i] = (String) (hrIn + ":" + minIn + "0"); //insere na lista como string com 0 no fim
            } else if (minIn >= 1 && minIn < 10) { //se os minutos são de 1 casa
                horarioInicio[i] = (String) (hrIn + ":" + "0" + minIn); //insere na lista como string com 0 antes do min
            } else { //todos os outros casos
                horarioInicio[i] = (String) (hrIn + ":" + minIn);
            }
            minIn += duracao + 10; // minutos atuais + duracao consulta + 10min de intervalo
            if (minIn >= 60) { // se os minutos estiverem em 60 ou mais
                hrIn++; // aumenta hora
                minIn -= 60; //tira 60 dos minutos
            }
            i++;
        }
        //zera contador
        i = 0;
        // setando horas de fim
        int hrFm = 8;
        int minFm = duracao;
        //nova lista de fim
        String[] horarioFim = new String[50];
        //while hora fim ainda nao for 20
        while (hrFm != 20) {
            if (minFm == 0) {
                horarioFim[i] = (String) (hrFm + ":" + minFm + "0");
            } else if (minFm >= 1 && minFm < 10) {
                horarioFim[i] = (String) (hrFm + ":" + "0" + minFm);
            } else {
                horarioFim[i] = (String) (hrFm + ":" + minFm);
            }
            minFm += duracao + 10; //10min de intervalo
            if (minFm >= 60) {
                hrFm++;
                minFm -= 60;
            }
            i++;
        }
        /*
        System.out.println("inicio - fim");
        for (i = 0; i < horarioInicio.length; i++) {
            if (horarioInicio[i] != null) {
                System.out.println(horarioInicio[i] + " às " + horarioFim[i]);
            }
        }
         */
        horInicio.setModel(new javax.swing.DefaultComboBoxModel(horarioInicio));
        horFim.setModel(new javax.swing.DefaultComboBoxModel(horarioFim));
    }//GEN-LAST:event_cmbDuracaoActionPerformed

    private void diasDaSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diasDaSemanaActionPerformed
        this.horInicio.setSelectedIndex(-1);
        this.horFim.setSelectedIndex(-1);
    }//GEN-LAST:event_diasDaSemanaActionPerformed

    private void horInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horInicioActionPerformed
        this.horFim.setSelectedIndex(this.horInicio.getSelectedIndex());
        this.horFim.setEnabled(false);
    }//GEN-LAST:event_horInicioActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (this.cmbDuracao.getSelectedIndex() != -1 && this.diasDaSemana.getSelectedIndex() != -1 && this.horInicio.getSelectedIndex() != -1 && this.horFim.getSelectedIndex() != -1 && validateSchedule()) {
            int dia = this.diasDaSemana.getSelectedIndex() + 1;

            String iniciation = (String) this.horInicio.getSelectedItem() + ":00.0000000";
            String finish = (String) this.horFim.getSelectedItem() + ":00.0000000";
            try {
                for (Availability workday : this.workdays) {
                    System.out.println(workday.toString());
                    if (workday.getWeekDay() == dia && workday.getIniciation().equals(iniciation) && workday.getFinish().equals(finish)) {
                        if (workday.getId() > 0) {
                            this.toDelete.add(workday);
                        }
                        this.workdays.remove(workday);
                        break;
                    }
                }
                this.addHorarioToScroll(this.workdays);
            } catch (Exception ex) {
                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //brotar um joptionpane de erro
            JOptionPane.showMessageDialog(this, "Horário inválido! Por favor, preencha todos os itens corretamente antes de remover.", "Erro ao remover o horário", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnRemover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemover1ActionPerformed
        if (this.cmbDuracao.getSelectedIndex() != -1 && this.diasDaSemana.getSelectedIndex() != -1 && this.horInicio.getSelectedIndex() != -1 && this.horFim.getSelectedIndex() != -1 && validateSchedule()) {
            int dia = this.diasDaSemana.getSelectedIndex() + 1;

            String iniciation = (String) this.horInicio.getSelectedItem() + ":00.0000000";
            String finish = (String) this.horFim.getSelectedItem() + ":00.0000000";
            try {
                for (Availability workday : this.workdays) {
                    System.out.println(workday.toString());
                    if (workday.getWeekDay() == dia && workday.getIniciation().equals(iniciation) && workday.getFinish().equals(finish)) {
                        if (workday.getId() > 0) {
                            this.toDelete.add(workday);
                        }
                        this.workdays.remove(workday);
                        break;
                    }
                }
                this.addHorarioToScroll(this.workdays);
            } catch (Exception ex) {
                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //brotar um joptionpane de erro
            JOptionPane.showMessageDialog(this, "Horário inválido! Por favor, preencha todos os itens corretamente antes de remover.", "Erro ao remover o horário", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRemover1ActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        /*
        criar availability com o index do dia da semana selecionado, os horarios inicio e fim
        selecionados e salvar no workdays
        impedir cara de colocar horarios iguais no mesmo dia OU horarios encavalados
         */
        if (this.cmbDuracao.getSelectedIndex() != -1 && this.diasDaSemana.getSelectedIndex() != -1 && this.horInicio.getSelectedIndex() != -1 && this.horFim.getSelectedIndex() != -1 && validateSchedule()) {
            int dia = this.diasDaSemana.getSelectedIndex() + 1;

            String iniciation = (String) this.horInicio.getSelectedItem() + ":00.0000000";
            String finish = (String) this.horFim.getSelectedItem() + ":00.0000000";

            try {
                if (shouldAddWorkday(dia, iniciation, finish)) {
                    workdays.add(new Availability(this.idHealthProfessionals, this.idSpecialization, dia, iniciation, finish));
                    toAdd.add(new Availability(this.idHealthProfessionals, this.idSpecialization, dia, iniciation, finish));
                    for (Availability day : workdays) {
                        System.out.println(day + ", ");
                    }
                } else {
                    //brotar um joptionpane de erro
                    JOptionPane.showMessageDialog(this, "Horário conflita com horário existente! \nPor favor, preencha todos os itens corretamente antes de adicionar.", "Erro ao adicionar o horário", JOptionPane.ERROR_MESSAGE);
                }
                this.addHorarioToScroll(workdays);
            } catch (Exception ex) {
                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private boolean shouldAddWorkday(int dia, String iniciation, String finish) {
        for (Availability day : workdays) {
            if (day.getWeekDay() == dia
                    && (iniciation.compareTo(day.getIniciation()) >= 0 && iniciation.compareTo(sumMinutesIntoString(day.getFinish(), 10)) < 0)
                    || (finish.compareTo(day.getIniciation()) >= 0 && finish.compareTo(sumMinutesIntoString(day.getFinish(), 10)) < 0)) {
                return false;
            }
        }
        return true;
    }

    private String sumMinutesIntoString(final String timeString, final Integer minutesToSum) {
        String[] hourMinuteSecond = timeString.split(":");
        int hour = Integer.parseInt(hourMinuteSecond[0]);
        int minutes = Integer.parseInt(hourMinuteSecond[1]);
        String secondsAndEverythingElse = hourMinuteSecond[2];
        minutes += 10;
        if (minutes > 60) {
            minutes = minutes - 60;
            hour += 1;
        }

        return hour + ":" + minutes + ":" + secondsAndEverythingElse;
    }

    private boolean validateSchedule() {
        if (this.horInicio.getSelectedIndex() > this.horFim.getSelectedIndex()) {
            return false;
        } else {
            return true;
        }
    }

    private void addHorarioToScroll(List<Availability> av) {
        this.lstHorarios.setListData(av.toArray());
    }

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelaActionPerformed

    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaActionPerformed
        //quando o botão confirmar é pressionado
        try {
            AvailabilityDAO handle = new AvailabilityDAO(ConnectionSetup.connection);
            //envia para o BD cada availability, que foram alocadas em uma lista chamada workdays
            System.out.println(workdays.toString());
            if (!toDelete.isEmpty()) {
                if (handle.deleteAvailabilities(toDelete)) {
                    JOptionPane.showMessageDialog(this, "Horários deletados com sucesso.", "Disponibilidade apagada", JOptionPane.OK_OPTION);
                    if (this.toAdd.isEmpty()) {
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ocorreu um erro ao deletar os horários. Tente novamente ou contate um administrador.", "Erro ao deletar os horários", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (!toAdd.isEmpty()) {
                if (handle.setAvailability(this.toAdd)) {
                    JOptionPane.showMessageDialog(this, "Horários registrados com sucesso!", "Horários registrados", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Ocorreu um erro ao adicionar os horários. Tente novamente ou contate um administrador.", "Erro ao adicionar os horários", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmaActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            this.workdays = new AvailabilityDAO(ConnectionSetup.connection).getAllAvailabilities(this.idHealthProfessionals);

            if (!workdays.isEmpty()) {
                this.addHorarioToScroll(workdays);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnConfirma;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnRemover1;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDisponib;
    private javax.swing.JList lstHorarios;
    // End of variables declaration//GEN-END:variables
}
