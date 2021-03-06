/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Employee;

import Module.DAO.DoctorAppointmentDAO;
import Module.DBO.ConnectionSetup;
import Module.DAO.AvailabilityDAO;
import Module.DAO.HealthProfessionalsDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 * Tela de indisponibilização de horários.
 *
 * @author Maiara
 */
public class TelaIndisponibilizacao extends javax.swing.JFrame {

    protected DoctorAppointmentDAO daDAO;
    protected HealthProfessionalsDAO hpDAO;
    protected AvailabilityDAO avDAO;

    /**
     * Creates new form TelaIndisponibilizacao
     */
    public TelaIndisponibilizacao() {
        this.daDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
        this.hpDAO = new HealthProfessionalsDAO(ConnectionSetup.connection);
        this.avDAO = new AvailabilityDAO(ConnectionSetup.connection);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblData1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbbNome = new javax.swing.JComboBox();
        lblData2 = new javax.swing.JLabel();
        btnIndisp = new javax.swing.JButton();
        dtcDia = new datechooser.beans.DateChooserCombo();
        lblData3 = new javax.swing.JLabel();
        cbbHorarioInicio = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText(":: Indisponibilização de Horário ::");

        lblTitulo2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("Selecione o profissional e o horário que deseja indisponibilizar:");

        lblData1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblData1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblData1.setText("Profissional:");

        cbbNome.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        cbbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNomeActionPerformed(evt);
            }
        });

        lblData2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblData2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblData2.setText("Dia:");

        btnIndisp.setText("Indisponibilizar");
        btnIndisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndispActionPerformed(evt);
            }
        });

        dtcDia.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dtcDia.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
    dtcDia.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
    dtcDia.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
        public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
            dtcDiaOnSelectionChange(evt);
        }
    });

    lblData3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    lblData3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lblData3.setText("Horário inicial:");

    cbbHorarioInicio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um dia..." }));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblTitulo2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblData1)
                                .addComponent(lblData2)
                                .addComponent(lblData3))
                            .addGap(7, 7, 7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbbNome, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dtcDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbHorarioInicio, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addGap(141, 141, 141)
            .addComponent(btnIndisp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(13, 13, 13)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cbbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblData1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(17, 17, 17)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(dtcDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblData2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblData3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbbHorarioInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
            .addComponent(btnIndisp, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            this.cbbNome.setModel(new DefaultComboBoxModel(this.hpDAO.SelectAllNameHealthProfessionals().toArray()));
            this.carregaHorarios();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowActivated

    protected void carregaHorarios() {
        try {
            Date diaSelecionado = this.dtcDia.getCurrent().getTime();
//            List<RegisteredEmployee> datasConsultas = new ArrayList<RegisteredEmployee>();        
//            datasConsultas = this.hpDAO.SelectAllHealthProfessionals();          
            if (!this.daDAO.workAt(diaSelecionado, this.cbbNome.getSelectedItem().toString())) { //se ele n trabalha ness
                this.lblTitulo2.setText("Esse profissional não trabalha nesse dia :(");
            } else {
                this.cbbHorarioInicio.enable();
                this.cbbHorarioInicio.setModel(new DefaultComboBoxModel(this.daDAO.selectDoctorAppointmentInPeriod(diaSelecionado, this.cbbNome.getSelectedItem().toString()).toArray()));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void dtcDiaOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dtcDiaOnSelectionChange
        this.carregaHorarios();
    }//GEN-LAST:event_dtcDiaOnSelectionChange

    private void btnIndispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndispActionPerformed
        try {
            SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
            String horarios[] = this.cbbHorarioInicio.getSelectedItem().toString().split(" - "),
                    nome = this.cbbNome.getSelectedItem().toString().trim(); //pegando a hora
            Date diaIndisponibilizacao = this.dtcDia.getCurrent().getTime();
            Calendar cal = Calendar.getInstance();
            cal.setTime(diaIndisponibilizacao);
            int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK) + 1;
            int idDisponibilidade;
            idDisponibilidade = this.avDAO.idsAvailability(diaDaSemana - 1, formatador.parse(horarios[0]) + ".00000", nome);
            if (this.daDAO.insertDoctorUnavailability(diaIndisponibilizacao, (horarios[0]) + ":00.00000", (horarios[1]) + ":00.00000", idDisponibilidade)) {
                JOptionPane.showMessageDialog(null, "Indisponibilidade marcada com sucesso para o[a] médico[a] " + nome + ".", "Indisponibilização com sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao marcar indisponibilidade para o[a] médico[a] " + nome + ".", "Erro na indisponibilização!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnIndispActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.hide();
    }//GEN-LAST:event_formWindowClosing

    private void cbbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNomeActionPerformed
        this.carregaHorarios();
    }//GEN-LAST:event_cbbNomeActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        this.carregaHorarios();
    }//GEN-LAST:event_formComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIndisp;
    private javax.swing.JComboBox cbbHorarioInicio;
    private javax.swing.JComboBox cbbNome;
    private datechooser.beans.DateChooserCombo dtcDia;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblData1;
    private javax.swing.JLabel lblData2;
    private javax.swing.JLabel lblData3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo2;
    // End of variables declaration//GEN-END:variables
}

/*
    
 */
