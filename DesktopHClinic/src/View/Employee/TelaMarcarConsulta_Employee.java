/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Employee;

import Module.DBO.Availability;
import Module.DBO.ConnectionSetup;
import Module.DAO.AvailabilityDAO;
import Module.DAO.DoctorAppointmentDAO;
import Module.DAO.HealthProfessionalsDAO;
import Module.DAO.PatientDAO;
import Module.DAO.ProfessionsDAO;
import Module.DAO.SpecializationDAO;
import Module.DBO.DoctorAppointment;
import Module.DBO.Patient;
import Module.DBO.Professions;
import Module.DBO.RegisteredEmployee;
import Module.DBO.Specialization;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Amanda
 */
public class TelaMarcarConsulta_Employee extends javax.swing.JPanel {

    private PatientDAO patientDAO = new PatientDAO(ConnectionSetup.connection);
    private SpecializationDAO specializationDAO = new SpecializationDAO(ConnectionSetup.connection);
    private HealthProfessionalsDAO healthProfessionalsDAO = new HealthProfessionalsDAO(ConnectionSetup.connection);
    private DoctorAppointmentDAO doctorAppDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
    private AvailabilityDAO availabilityDAO = new AvailabilityDAO(ConnectionSetup.connection);
    private DoctorAppointmentDAO doctorAppointmentDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
    private ProfessionsDAO professionsDAO = new ProfessionsDAO(ConnectionSetup.connection);

    /**
     * Creates new form TelaMarcarConsulta_EmployeeP
     */
    public TelaMarcarConsulta_Employee() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEncaixe = new javax.swing.JButton();
        lblPaciente1 = new javax.swing.JLabel();
        btnDisponibilidade = new javax.swing.JButton();
        cboMedico = new javax.swing.JComboBox();
        cboEspecialidade = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();
        lblData = new javax.swing.JLabel();
        btnConfimar = new javax.swing.JButton();
        lblEspecialidade = new javax.swing.JLabel();
        txtNomePesquisado = new javax.swing.JTextField();
        dateSelected = new datechooser.beans.DateChooserCombo();
        btnPesquisar = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPacientes = new javax.swing.JList();
        cboProfissao = new javax.swing.JComboBox();
        lblprofissao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstHorarios = new javax.swing.JList();
        lblDisponibilidadeTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEncaixe.setText("Encaixe");
        btnEncaixe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncaixeActionPerformed(evt);
            }
        });
        add(btnEncaixe, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, 98, -1));

        lblPaciente1.setText("Médico:");
        add(lblPaciente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 72, 20));

        btnDisponibilidade.setText("Disponibilidade");
        btnDisponibilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponibilidadeActionPerformed(evt);
            }
        });
        add(btnDisponibilidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, -1, -1));

        cboMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMedicoMouseClicked(evt);
            }
        });
        add(cboMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 250, -1));

        cboEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEspecialidadeActionPerformed(evt);
            }
        });
        add(cboEspecialidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 250, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 530, 134, -1));

        lblData.setText("Data:");
        add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 72, 20));

        btnConfimar.setText("Confirmar");
        btnConfimar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfimarActionPerformed(evt);
            }
        });
        add(btnConfimar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, 134, -1));

        lblEspecialidade.setText("Especialização:");
        lblEspecialidade.setToolTipText("");
        add(lblEspecialidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, 22));
        add(txtNomePesquisado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 126, -1));
        add(dateSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 250, -1));

        btnPesquisar.setText("...");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 33, -1));

        lblError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 480, 60));

        jScrollPane1.setViewportView(lstPacientes);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 160, 400));

        cboProfissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProfissaoActionPerformed(evt);
            }
        });
        add(cboProfissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 250, -1));

        lblprofissao.setText("Profissao:");
        lblprofissao.setToolTipText("");
        add(lblprofissao, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, 22));

        jScrollPane2.setViewportView(lstHorarios);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 510, 174));

        lblDisponibilidadeTitulo.setText("Horários disponíveis:");
        add(lblDisponibilidadeTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 155, 26));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText(":: Marcar consulta ::");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncaixeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncaixeActionPerformed
        try {
            carregarEncaixes();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEncaixeActionPerformed

    private void btnDisponibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponibilidadeActionPerformed
        try {
            carregarDisponibilidades();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDisponibilidadeActionPerformed

    private void cboMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMedicoMouseClicked
        /*   try {
            carregarMedicos();
        }
        catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_cboMedicoMouseClicked

    private void cboEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEspecialidadeActionPerformed
        try {
            carregarMedicos();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboEspecialidadeActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfimarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfimarActionPerformed
        try {

            if (lstPacientes.getSelectedValue() == null) {
                this.lblError.setText("Selecione um paciente!");
            } else if (lstHorarios.getSelectedValue() == null) {
                this.lblError.setText("Selecione um horário!");
            } else {
                int idPatient = ((Patient) lstPacientes.getSelectedValue()).getId();
                int idAvailability = ((Availability) lstHorarios.getSelectedValue()).getId();

                String dateIniciation = ((Availability) lstHorarios.getSelectedValue()).getIniciation();
                String dateFinish = ((Availability) lstHorarios.getSelectedValue()).getFinish();

                dateIniciation = dateIniciation.substring(0, dateIniciation.length() - 11);
                dateFinish = dateFinish.substring(0, dateFinish.length() - 11);

                String date = getValidDate();

                //int idPatient, int idAvailability, Date dateIniciation, Date dateFinish
                DoctorAppointment doctorAppointment = new DoctorAppointment(idPatient, idAvailability, dateIniciation, dateFinish);
                if (this.doctorAppointmentDAO.InsertDoctorAppointment(doctorAppointment, date)) {
                    JOptionPane.showMessageDialog(this, "Consulta marcada!");
                    recarregarForm();
                } else {
                    recarregarForm();
                    this.lblError.setText("Erro ao tentar marcar consulta.");
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_Employee.class.getName()).log(Level.SEVERE, null, ex);
            this.lblError.setText("Erro ao tentar marcar consulta.");
        }
    }//GEN-LAST:event_btnConfimarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        try {
            List<Patient> pacientes = this.patientDAO.SearchPatient(this.txtNomePesquisado.getText());
            this.lstPacientes.setListData(pacientes.toArray());
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cboProfissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProfissaoActionPerformed
        try {
            carregarEspecialidade();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboProfissaoActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
        try {
            carregarProfissao();
            carregarEspecialidade();
            carregarPacientes();
            carregarMedicos();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentAdded

    private void carregarProfissao() throws Exception {
        for (Professions profession : professionsDAO.SelectAllProfessions()) {
            this.cboProfissao.addItem(profession);
        }
    }

    private void carregarEspecialidade() throws Exception {
        try {
            this.cboEspecialidade.removeAllItems();
            int professionsID = ((Professions) this.cboProfissao.getSelectedItem()).getId();

            for (Specialization specialization : this.specializationDAO.SelectSpecializations(professionsID)) {
                this.cboEspecialidade.addItem(specialization);
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregarMedicos() throws Exception {
        this.cboMedico.removeAllItems();
        this.cboMedico.addItem("Nenhum");
        int specializationID = ((Specialization) this.cboEspecialidade.getSelectedItem()).getId();
        List<RegisteredEmployee> registeredEmployees = this.healthProfessionalsDAO.SelectHealthProfessionalBySpecialization(specializationID);
        if (registeredEmployees.isEmpty()) {
            this.cboMedico.addItem("<SEM MÉDICO DISPONIVEL>");
        } else {
            for (RegisteredEmployee registeredEmployee : registeredEmployees) {
                this.cboMedico.addItem(registeredEmployee);
            }
        }
    }

    private void carregarPacientes() throws Exception {
        List<Patient> pacientes = this.patientDAO.SelectAllPatient();
        this.lstPacientes.setListData(pacientes.toArray());
    }

    private void carregarDisponibilidades() throws Exception {

        List<Availability> availabilities = new ArrayList<Availability>();
        this.lstHorarios.setListData(availabilities.toArray());

        String date = getValidDate();
        if (date != null) {
            int healthProfessionalID = this.cboMedico.getSelectedItem().equals("Nenhum") ? 0 : ((RegisteredEmployee) this.cboMedico.getSelectedItem()).getId();
            int specializationID = ((Specialization) this.cboEspecialidade.getSelectedItem()).getId();
            int dayOfWeek = this.getDayOfWeek();

            //availabilities = this.availabilityDAO.SelectAllAvailability(healthProfessionalID, specializationID, dayOfWeek); 
            availabilities = getValidAvailability(healthProfessionalID, specializationID, dayOfWeek, date);
            if (!availabilities.isEmpty()) {
                this.lblError.setText("");
                this.lstHorarios.setListData(availabilities.toArray());
            } else {
                this.lblError.setText("Não foi encontrado disponibilidades para esse dia!");
            }
        }

    }

    private void carregarEncaixes() throws Exception {
        List<Availability> availabilities = new ArrayList<Availability>();
        this.lstHorarios.setListData(availabilities.toArray());

        String date = getValidDate();
        int healthProfessionalID = this.cboMedico.getSelectedItem().equals("Nenhum") ? 0 : ((RegisteredEmployee) this.cboMedico.getSelectedItem()).getId();
        int specializationID = ((Specialization) this.cboEspecialidade.getSelectedItem()).getId();
        int dayOfWeek = this.getDayOfWeek();

        //availabilities = this.availabilityDAO.SelectAllAvailability(healthProfessionalID, specializationID, dayOfWeek); 
        availabilities = pegarEncaixesValidos(healthProfessionalID, specializationID, dayOfWeek, date);
        if (!availabilities.isEmpty()) {
            this.lblError.setText("");
            this.lstHorarios.setListData(availabilities.toArray());
        } else {
            this.lblError.setText("Não foi encontrado encaixes para esse dia!");
        }
    }

    private int getDayOfWeek() {
        Calendar c = this.dateSelected.getSelectedDate();
        return c.get(Calendar.DAY_OF_WEEK);
    }

    private List<Availability> getValidAvailability(int healthProfessionalID, int specializationID, int dayOfWeek, String data) throws Exception {

        List<Availability> availabilities = this.availabilityDAO.SelectAllAvailability(healthProfessionalID, specializationID, dayOfWeek);
        List<Availability> avscopy = new ArrayList(availabilities);

        List<String> busyHours = this.doctorAppDAO.SelectBusyHours(data);

        for (String h : busyHours) {
            for (Availability av : avscopy) {
                String iniciation = av.getIniciation().toString().substring(0, av.getIniciation().toString().length() - 8);
                if (h.equals(iniciation)) {
                    availabilities.remove(av);
                }
            }
        }

        return availabilities;
    }

    private List<Availability> pegarEncaixesValidos(int healthProfessionalID, int specializationID, int dayOfWeek, String data) throws Exception {

        List<Availability> encaixes = new ArrayList<Availability>();

        List<Availability> availabilities = this.availabilityDAO.SelectAllAvailability(healthProfessionalID, specializationID, dayOfWeek);
        for (int i = 0; i < availabilities.size() - 1; i++) {

            String iniciation = availabilities.get(i).getFinish();
            String finish = availabilities.get(i + 1).getIniciation();
            int idHealthProfessionals = availabilities.get(i).getIdHealthProfessionals();
            int idSpecialization = availabilities.get(i).getIdSpecialization();
            int idAvailability = availabilities.get(i).getId();
            int weekDay = availabilities.get(i).getWeekDay();

            encaixes.add(new Availability(idAvailability, idHealthProfessionals, idSpecialization, weekDay, iniciation, finish));
        }

        List<String> busyHours = this.doctorAppDAO.SelectBusyHours(data);

        List<Availability> encaixescopy = new ArrayList(encaixes);

        for (String h : busyHours) {
            for (Availability av : encaixescopy) {
                String iniciation = av.getIniciation().toString().substring(0, av.getIniciation().toString().length() - 8);
                if (h.equals(iniciation)) {
                    encaixes.remove(av);
                }
            }
        }

        return encaixes;
    }

    private String getValidDate() throws SQLException {
        Calendar c = this.dateSelected.getSelectedDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //TODO: aqui verificar com a tabela holiday do bd
        String[] date = format.format(c.getTime()).split("-");
        String valid = this.doctorAppDAO.checkIfHoliday(Integer.parseInt(date[2]), Integer.parseInt(date[1]));
        if (valid.equals("ok")) {
            valid = format.format(c.getTime());
        } else {
            this.lblError.setText("<html>Não é possível agendar consultas neste dia!<br>Feriado de " + valid + "</html>");
            valid = null;
        }
        return valid;
    }

    private void recarregarForm() throws Exception {
        this.lblError.setText("");
        carregarDisponibilidades();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfimar;
    private javax.swing.JButton btnDisponibilidade;
    private javax.swing.JButton btnEncaixe;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox cboEspecialidade;
    private javax.swing.JComboBox cboMedico;
    private javax.swing.JComboBox cboProfissao;
    private datechooser.beans.DateChooserCombo dateSelected;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDisponibilidadeTitulo;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblEspecialidade;
    private javax.swing.JLabel lblPaciente1;
    private javax.swing.JLabel lblprofissao;
    private javax.swing.JList lstHorarios;
    private javax.swing.JList lstPacientes;
    private javax.swing.JTextField txtNomePesquisado;
    // End of variables declaration//GEN-END:variables
}
