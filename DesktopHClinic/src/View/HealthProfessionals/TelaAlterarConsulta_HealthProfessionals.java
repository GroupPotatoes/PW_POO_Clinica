package View.HealthProfessionals;

import Module.DBO.Availability;
import Module.DBO.ConnectionSetup;
import Module.DAO.AvailabilityDAO;
import Module.DAO.DoctorAppointmentDAO;
import Module.DBO.DoctorAppointment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaAlterarConsulta_HealthProfessionals extends javax.swing.JPanel {

    private AvailabilityDAO availabilityDAO = null;
    private DoctorAppointmentDAO doctorAppDAO = null;
    private DoctorAppointment consulta = null;
    
    public TelaAlterarConsulta_HealthProfessionals() {
        initComponents();
        
        this.doctorAppDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
        this.availabilityDAO = new AvailabilityDAO(ConnectionSetup.connection);
    }
 
    public void setConsulta(DoctorAppointment consulta) throws Exception{
        if(consulta == null)
            throw new Exception("Valor para consulta inválido.");
        
        this.consulta = consulta;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomePaciente = new javax.swing.JLabel();
        lblNomePaciente2 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        Date = new datechooser.beans.DateChooserCombo();
        btnDIsponibilidade = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstHorarios = new javax.swing.JList();
        lblDisponibilidadeTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lblNomePaciente.setText("Paciente:");

        lblData.setText("Data:");

        btnDIsponibilidade.setText("Gerar disponibilidades");
        btnDIsponibilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDIsponibilidadeActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lstHorarios);

        lblDisponibilidadeTitulo.setText("Horários disponíveis:");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNomePaciente)
                            .addGap(7, 7, 7)
                            .addComponent(lblNomePaciente2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(lblDisponibilidadeTitulo))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(72, 72, 72)
                            .addComponent(btnCancelar)
                            .addGap(5, 5, 5)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(btnDIsponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(lblNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblNomePaciente2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addComponent(btnDIsponibilidade)
                    .addGap(17, 17, 17)
                    .addComponent(lblDisponibilidadeTitulo)
                    .addGap(6, 6, 6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCancelar)
                        .addComponent(btnSalvar))
                    .addGap(0, 4, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDIsponibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDIsponibilidadeActionPerformed
        try {
            carregarDisponibilidades();
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterarConsulta_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDIsponibilidadeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            this.lblError.setText("");
            if(lstHorarios.getSelectedValue() != null)
            {

                int id_Availability = ((Availability)lstHorarios.getSelectedValue()).getId();
                String date = getValidDate();

                this.consulta.setIdAvailability(id_Availability);
                this.consulta.setDate(date);

                if(this.doctorAppDAO.UpdateDoctorAppointmentDate(consulta)){
                    JOptionPane.showMessageDialog(this, "Consulta alterada!");
                    this.setVisible(false);
                }
                else
                this.lblError.setText("Não foi possível alterar data.");
            }
            else
            this.lblError.setText("Selecione uma disponibilidade!");
        }
        catch (Exception ex) {
            Logger.getLogger(TelaAlterarConsulta_HealthProfessionals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       carregarFormData();
    }//GEN-LAST:event_formComponentShown
    
    private void carregarFormData(){
        this.lblNomePaciente2.setText(consulta.namePatient);
        this.Date.setText(consulta.getDate());
    }
    
    private void carregarDisponibilidades() throws Exception{
        
        this.lblError.setText("");
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
        Calendar c = this.Date.getSelectedDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(c.getTime());    
    }
    
    private int getDayOfWeek() {
       Calendar c = this.Date.getSelectedDate();
       return c.get(Calendar.DAY_OF_WEEK);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo Date;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDIsponibilidade;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDisponibilidadeTitulo;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblNomePaciente;
    private javax.swing.JLabel lblNomePaciente2;
    private javax.swing.JList lstHorarios;
    // End of variables declaration//GEN-END:variables
}
