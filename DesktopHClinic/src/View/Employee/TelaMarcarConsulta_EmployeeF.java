package View.Employee;

import Module.DBO.Availability;
import Module.DAO.AvailabilityDAO;
import Module.DBO.ConnectionSetup;
import Module.DBO.DoctorAppointment;
import Module.DAO.DoctorAppointmentDAO;
import Module.DAO.HealthProfessionalsDAO;
import Module.DBO.Patient;
import Module.DAO.PatientDAO;
import Module.DAO.ProfessionsDAO;
import Module.DBO.RegisteredEmployee;
import Module.DBO.Specialization;
import Module.DAO.SpecializationDAO;
import Module.DBO.Professions;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaMarcarConsulta_EmployeeF extends javax.swing.JFrame {

    private PatientDAO patientDAO = null;
    private SpecializationDAO specializationDAO = null;
    private HealthProfessionalsDAO healthProfessionalsDAO = null;
    private DoctorAppointmentDAO doctorAppDAO = null;
    private AvailabilityDAO availabilityDAO = null;
    private DoctorAppointmentDAO doctorAppointmentDAO = null;
    private ProfessionsDAO professionsDAO = null;

    public TelaMarcarConsulta_EmployeeF() {
        initComponents();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.patientDAO = new PatientDAO(ConnectionSetup.connection);
        this.specializationDAO = new SpecializationDAO(ConnectionSetup.connection);
        this.healthProfessionalsDAO = new HealthProfessionalsDAO(ConnectionSetup.connection);
        this.doctorAppDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
        this.availabilityDAO = new AvailabilityDAO(ConnectionSetup.connection);
        this.doctorAppointmentDAO = new DoctorAppointmentDAO(ConnectionSetup.connection);
        this.professionsDAO = new ProfessionsDAO(ConnectionSetup.connection);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblDisponibilidadeTitulo = new javax.swing.JLabel();
        lblPaciente1 = new javax.swing.JLabel();
        cboMedico = new javax.swing.JComboBox();
        btnCancelar = new javax.swing.JButton();
        btnConfimar = new javax.swing.JButton();
        txtNomePesquisado = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPacientes = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstHorarios = new javax.swing.JList();
        btnEncaixe = new javax.swing.JButton();
        btnDisponibilidade = new javax.swing.JButton();
        cboEspecialidade = new javax.swing.JComboBox();
        lblData = new javax.swing.JLabel();
        lblEspecialidade = new javax.swing.JLabel();
        dateSelected = new datechooser.beans.DateChooserCombo();
        lblError = new javax.swing.JLabel();
        cboProfissao = new javax.swing.JComboBox();
        lblprofissao = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Selecionar Paciente:");

        lblDisponibilidadeTitulo.setText("Horários disponíveis:");

        lblPaciente1.setText("Médico:");

        cboMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMedicoMouseClicked(evt);
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

        btnPesquisar.setText("...");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstPacientes);

        jScrollPane2.setViewportView(lstHorarios);

        btnEncaixe.setText("Encaixe");
        btnEncaixe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncaixeActionPerformed(evt);
            }
        });

        btnDisponibilidade.setText("Disponibilidade");
        btnDisponibilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponibilidadeActionPerformed(evt);
            }
        });

        cboEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEspecialidadeActionPerformed(evt);
            }
        });

        lblData.setText("Data:");

        lblEspecialidade.setText("Especialização:");
        lblEspecialidade.setToolTipText("");

        lblError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 51, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cboProfissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProfissaoActionPerformed(evt);
            }
        });

        lblprofissao.setText("Profissao:");
        lblprofissao.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText(":: Marcar consulta ::");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(37, 37, 37))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNomePesquisado, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblDisponibilidadeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(btnDisponibilidade)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnEncaixe, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblEspecialidade)
                                                        .addComponent(lblPaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(lblprofissao))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cboProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(cboEspecialidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cboMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(dateSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnConfimar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNomePesquisado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPesquisar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblprofissao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboMedico)
                                    .addComponent(lblPaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEncaixe)
                                    .addComponent(btnDisponibilidade, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDisponibilidadeTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnConfimar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        try {
            List<Patient> pacientes = this.patientDAO.SearchPatient(this.txtNomePesquisado.getText());
            this.lstPacientes.setListData(pacientes.toArray());
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cboMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMedicoMouseClicked
        /*   try {
             carregarMedicos();
        }
        catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_Employee.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_cboMedicoMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            carregarProfissao();
            carregarEspecialidade();
            carregarPacientes();
            carregarMedicos();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formComponentShown

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnDisponibilidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponibilidadeActionPerformed
        try {
            carregarDisponibilidades();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDisponibilidadeActionPerformed

    private void cboEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEspecialidadeActionPerformed
        try {
            carregarMedicos();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboEspecialidadeActionPerformed

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
            Logger.getLogger(TelaMarcarConsulta_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
            this.lblError.setText("Erro ao tentar marcar consulta.");
        }
    }//GEN-LAST:event_btnConfimarActionPerformed

    private void btnEncaixeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncaixeActionPerformed
        try {
            carregarEncaixes();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEncaixeActionPerformed

    private void cboProfissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProfissaoActionPerformed
        try {
            carregarEspecialidade();
        } catch (Exception ex) {
            Logger.getLogger(TelaMarcarConsulta_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cboProfissaoActionPerformed

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
            Logger.getLogger(TelaMarcarConsulta_EmployeeF.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel1;
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
