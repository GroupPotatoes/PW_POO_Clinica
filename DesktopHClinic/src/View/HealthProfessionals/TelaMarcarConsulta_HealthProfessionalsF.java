package View.HealthProfessionals;

import Module.DBO.Availability;
import Module.DAO.AvailabilityDAO;
import Module.DBO.ConnectionSetup;
import Module.DBO.DoctorAppointment;
import Module.DAO.DoctorAppointmentDAO;
import Module.DBO.Patient;
import Module.DAO.PatientDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaMarcarConsulta_HealthProfessionalsF extends javax.swing.JFrame {

    private DoctorAppointmentDAO doctorAppointmentDAO = null;
    private PatientDAO patientDAO = null;
    private AvailabilityDAO availabilityDAO = null;
    private DoctorAppointmentDAO doctorAppDAO = null;
    
    public TelaMarcarConsulta_HealthProfessionalsF() {
        initComponents();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        this.doctorAppointmentDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
        this.patientDAO = new PatientDAO(ConnectionSetup.connection);
        this.availabilityDAO = new AvailabilityDAO(ConnectionSetup.connection);
        this.doctorAppDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstHorarios = new javax.swing.JList();
        lblDisponibilidadeTitulo = new javax.swing.JLabel();
        btnDisponibilidade = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConfimar = new javax.swing.JButton();
        lblData = new javax.swing.JLabel();
        txtNomePesquisado = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        dateSelected = new datechooser.beans.DateChooserCombo();
        lblError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPacientes = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Selecionar Paciente:");

        jScrollPane2.setViewportView(lstHorarios);

        lblDisponibilidadeTitulo.setText("Horários disponíveis:");

        btnDisponibilidade.setText("Disponibilidade");
        btnDisponibilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponibilidadeActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConfimar.setText("Confirmar");
        btnConfimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfimarActionPerformed(evt);
            }
        });

        lblData.setText("Data:");

        btnPesquisar.setText("...");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        dateSelected.setNothingAllowed(false);
        dateSelected.setMaxDate(new java.util.GregorianCalendar(2015, 11, 31));
        dateSelected.setMinDate(new java.util.GregorianCalendar(2015, 11, 12));

        lblError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jScrollPane1.setViewportView(lstPacientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfimar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNomePesquisado, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblDisponibilidadeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnDisponibilidade))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomePesquisado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnDisponibilidade)
                        .addGap(23, 23, 23)
                        .addComponent(lblDisponibilidadeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnConfimar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDisponibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponibilidadeActionPerformed
        try {     
            carregarDisponibilidades();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_HealthProfessionalsF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDisponibilidadeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfimarActionPerformed
        try {

            if(lstPacientes.getSelectedValue() == null)
            this.lblError.setText("Selecione um paciente!");
            else if(lstHorarios.getSelectedValue() == null)
            this.lblError.setText("Selecione um horário!");
            else
            {
                int idPatient = ((Patient)lstPacientes.getSelectedValue()).getId();
                int idAvailability = ((Availability)lstHorarios.getSelectedValue()).getId();

                String dateIniciation = ((Availability)lstHorarios.getSelectedValue()).getIniciation();
                String dateFinish = ((Availability)lstHorarios.getSelectedValue()).getFinish();

                dateIniciation = dateIniciation.substring(0, dateIniciation.length() - 11);
                dateFinish = dateFinish.substring(0, dateFinish.length() - 11);

                String date = getValidDate();

                //int idPatient, int idAvailability, Date dateIniciation, Date dateFinish
                DoctorAppointment doctorAppointment = new DoctorAppointment(idPatient, idAvailability, dateIniciation, dateFinish);
                if(this.doctorAppointmentDAO.InsertDoctorAppointment(doctorAppointment, date))
                {
                    JOptionPane.showMessageDialog(this, "Consulta marcada!");
                    recarregarForm();
                }
                else
                {
                    recarregarForm();
                    this.lblError.setText("Erro ao tentar marcar consulta.");
                }
            }

        }
        catch (Exception ex) {
            this.lblError.setText("Erro ao tentar marcar consulta.");
        }
    }//GEN-LAST:event_btnConfimarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
  
        try {
            List<Patient> pacientes = this.patientDAO.SearchPatient(this.txtNomePesquisado.getText());
            this.lstPacientes.setListData(pacientes.toArray());
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_HealthProfessionalsF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            carregarPacientes();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_HealthProfessionalsF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown
    
    private void carregarPacientes() throws Exception{
        this.lblError.setText("");
        List<Patient> pacientes = this.patientDAO.SelectAllPatient();
        if(!pacientes.isEmpty())
            this.lstPacientes.setListData(pacientes.toArray());
        else
            this.lblError.setText("Não existe pacientes.");
    }
    
    private void recarregarForm() throws Exception{
        this.lblError.setText("");
        carregarDisponibilidades();
    } 
    
    private void carregarDisponibilidades() throws Exception{
        
        List<Availability> availabilities = new ArrayList<Availability>();
        this.lstHorarios.setListData(availabilities.toArray());
        
        String date = getValidDate();
        int dayOfWeek = this.getDayOfWeek();
        availabilities = getValidAvailability(ConnectionSetup.id, dayOfWeek, date);
        if(!availabilities.isEmpty())
        {  
           this.lblError.setText("");
           this.lstHorarios.setListData(availabilities.toArray());
        }
        else
           this.lblError.setText("Não foi encontrado disponibilidades para esse dia!");
    }
   
    private List<Availability> getValidAvailability(int healthProfessionalID, int  dayOfWeek, String data) throws Exception{
   
        List<Availability> availabilities = this.availabilityDAO.SelectAllAvailability(healthProfessionalID, dayOfWeek); 
        List<Availability> avscopy = new ArrayList(availabilities);
        
        List<String> busyHours = this.doctorAppDAO.SelectBusyHours(data);
        
        for(String h : busyHours)
            for(Availability av : avscopy)
            {
                String iniciation = av.getIniciation().toString().substring(0, av.getIniciation().toString().length() - 8);
                if(h.equals(iniciation))
                    availabilities.remove(av);
            }
         
        return availabilities;
    }

    private String getValidDate() {
        Calendar c = this.dateSelected.getSelectedDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(c.getTime());    
    }
    
    private int getDayOfWeek() {
       Calendar c = this.dateSelected.getSelectedDate();
       return c.get(Calendar.DAY_OF_WEEK);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfimar;
    private javax.swing.JButton btnDisponibilidade;
    private javax.swing.JButton btnPesquisar;
    private datechooser.beans.DateChooserCombo dateSelected;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDisponibilidadeTitulo;
    private javax.swing.JLabel lblError;
    private javax.swing.JList lstHorarios;
    private javax.swing.JList lstPacientes;
    private javax.swing.JTextField txtNomePesquisado;
    // End of variables declaration//GEN-END:variables
}
