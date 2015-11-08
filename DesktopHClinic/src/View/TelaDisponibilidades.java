package View;

import Module.DAO.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaDisponibilidades extends javax.swing.JFrame {
    private int id;
    private int idHealthProfessionals;
    private int idSpecialization;
    List<Availability> workdays = new ArrayList<Availability>();
    private int weekDay;
    private Time iniciation;
    private Time finish;
    private int inicio;
    private int fim;
   
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
        jScrollPane1 = new javax.swing.JScrollPane();
        diasSemana = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Disponibilidade do profissional");
        setAlwaysOnTop(true);

        labelDisponib.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelDisponib.setText(":: Horários disponíveis para consulta ::");

        jLabel1.setText("<html><center>Selecione cada dia da semana <br>e depois marque os horários disponíveis.</center></html>");

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

        horFim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" }));

        diasSemana.setFont(new java.awt.Font("Ubuntu", 0, 13)); // NOI18N
        diasSemana.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(diasSemana);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel5.setText("<html><center>Seus horários serão salvos quando <br>você selecionar um novo dia da semana. <br>Confirme para salvar todos.</center></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(labelDisponib)
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(horInicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(horFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCancela)))
                    .addComponent(jLabel2))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnConfirma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(labelDisponib)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(horInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(horFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancela)
                    .addComponent(btnConfirma))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmaActionPerformed
        //quando o botão confirmar é pressionado
        try {
            AvailabilityDAO insert = new AvailabilityDAO(ConnectionSetup.connection);
            //envia para o BD cada availability, que foram alocadas em uma lista chamada workdays
            for (Availability av : this.workdays){
                insert.SetAvailability(av);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmaActionPerformed

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelaActionPerformed

    private void addListenerToMenuList() {
        this.diasSemana.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    switch (diasSemana.getSelectedIndex()) {
                        case 0: //domingo
                            inicio = horInicio.getSelectedIndex() + 8;
                            fim = horFim.getSelectedIndex() + 8;
                            iniciation.setHours(inicio);
                            finish.setHours(fim);
                            weekDay = 1;
                            Availability dom;
                            try {
                                dom = new Availability(id, idHealthProfessionals, idSpecialization, weekDay, iniciation, finish);
                                workdays.add(dom);
                            } catch (Exception ex) {
                                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 1: //segunda
                            inicio = horInicio.getSelectedIndex() + 8;
                            fim = horFim.getSelectedIndex() + 8;
                            iniciation.setHours(inicio);
                            finish.setHours(fim);
                            weekDay = 2;
                            Availability seg;
                            try {
                                seg = new Availability(id, idHealthProfessionals, idSpecialization, weekDay, iniciation, finish);
                                workdays.add(seg);
                            } catch (Exception ex) {
                                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 2: //terça
                            inicio = horInicio.getSelectedIndex() + 8;
                            fim = horFim.getSelectedIndex() + 8;
                            iniciation.setHours(inicio);
                            finish.setHours(fim);
                            weekDay = 3;
                            Availability ter;
                            try {
                                ter = new Availability(id, idHealthProfessionals, idSpecialization, weekDay, iniciation, finish);
                                workdays.add(ter);
                            } catch (Exception ex) {
                                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 3: //quarta
                            inicio = horInicio.getSelectedIndex() + 8;
                            fim = horFim.getSelectedIndex() + 8;
                            iniciation.setHours(inicio);
                            finish.setHours(fim);
                            weekDay = 4;
                            Availability qua;
                            try {
                                qua = new Availability(id, idHealthProfessionals, idSpecialization, weekDay, iniciation, finish);
                                workdays.add(qua);
                            } catch (Exception ex) {
                                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 4: //quinta
                            inicio = horInicio.getSelectedIndex() + 8;
                            fim = horFim.getSelectedIndex() + 8;
                            iniciation.setHours(inicio);
                            finish.setHours(fim);
                            weekDay = 5;
                            Availability qui;
                            try {
                                qui = new Availability(id, idHealthProfessionals, idSpecialization, weekDay, iniciation, finish);
                                workdays.add(qui);
                            } catch (Exception ex) {
                                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 5: //sexta
                            inicio = horInicio.getSelectedIndex() + 8;
                            fim = horFim.getSelectedIndex() + 8;
                            iniciation.setHours(inicio);
                            finish.setHours(fim);
                            weekDay = 6;
                            Availability sex;
                            try {
                                sex = new Availability(id, idHealthProfessionals, idSpecialization, weekDay, iniciation, finish);
                                workdays.add(sex);
                            } catch (Exception ex) {
                                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case 6: //sabado
                            inicio = horInicio.getSelectedIndex() + 8;
                            fim = horFim.getSelectedIndex() + 8;
                            iniciation.setHours(inicio);
                            finish.setHours(fim);
                            weekDay = 7;
                            Availability sab;
                            try {
                                sab = new Availability(id, idHealthProfessionals, idSpecialization, weekDay, iniciation, finish);
                                workdays.add(sab);
                            } catch (Exception ex) {
                                Logger.getLogger(TelaDisponibilidades.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                    }
                } else {
                    System.out.println("Valor sendo ajustado.");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnConfirma;
    private javax.swing.JList diasSemana;
    private javax.swing.JComboBox horFim;
    private javax.swing.JComboBox horInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDisponib;
    // End of variables declaration//GEN-END:variables
}
