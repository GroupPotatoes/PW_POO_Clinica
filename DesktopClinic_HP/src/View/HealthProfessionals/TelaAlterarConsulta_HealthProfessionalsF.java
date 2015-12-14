package View.HealthProfessionals;

import Module.DBO.Availability;
import Module.DAO.AvailabilityDAO;
import Module.DBO.ConnectionSetup;
import Module.DBO.DoctorAppointment;
import Module.DAO.DoctorAppointmentDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TelaAlterarConsulta_HealthProfessionalsF extends javax.swing.JFrame {

    private DoctorAppointment consulta = null;
    private AvailabilityDAO availabilityDAO = null;
    private DoctorAppointmentDAO doctorAppDAO = null;
    
    public void setConsulta(DoctorAppointment consulta) throws Exception{
        if(consulta == null)
            throw new Exception("Valor para consulta inválido.");
        
        this.consulta = consulta;
    }
    
    public TelaAlterarConsulta_HealthProfessionalsF() {
        initComponents();
        
        this.availabilityDAO = new AvailabilityDAO(ConnectionSetup.connection);
        this.doctorAppDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNomePaciente.setText("Paciente:");
        getContentPane().add(lblNomePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 11, -1, 20));
        getContentPane().add(lblNomePaciente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 300, 20));

        lblData.setText("Data:");
        getContentPane().add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 50, 20));
        getContentPane().add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 20));

        btnDIsponibilidade.setText("Gerar disponibilidades");
        btnDIsponibilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDIsponibilidadeActionPerformed(evt);
            }
        });
        getContentPane().add(btnDIsponibilidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, -1));

        jScrollPane2.setViewportView(lstHorarios);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 320, -1));

        lblDisponibilidadeTitulo.setText("Horários disponíveis:");
        getContentPane().add(lblDisponibilidadeTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 80, -1));
        getContentPane().add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 320, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        carregarFormData();
    }//GEN-LAST:event_formComponentShown

    private void btnDIsponibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDIsponibilidadeActionPerformed
        try {
            carregarDisponibilidades();
        } catch (Exception ex) {
            Logger.getLogger(TelaAlterarConsulta_HealthProfessionalsF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDIsponibilidadeActionPerformed

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
                Logger.getLogger(TelaAlterarConsulta_HealthProfessionalsF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
