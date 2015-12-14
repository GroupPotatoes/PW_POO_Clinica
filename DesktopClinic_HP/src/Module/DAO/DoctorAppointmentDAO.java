package Module.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Module.DBO.DoctorAppointment;
import java.util.Calendar;

/**
 * DAO das consultas médicas.
 *
 * @author amanda
 */
public class DoctorAppointmentDAO {

    private Connection connection; //Conexão ao BD

    /**
     * Construtor da classe DoctorAppointmentDAO.
     *
     * @param connection conexão ao BD
     */
    public DoctorAppointmentDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Método que retorna uma lista de consultas em determinada data.
     *
     * @param data data da consulta
     * @return consultasDia consultas da data selecionada
     * @throws SQLException
     * @throws Exception
     */
    public List<String> searchDoctorAppointmentsComplete(Date data) throws SQLException, Exception {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dtBanco = formatador.format(data);
        List<String> consultasDia = new ArrayList<String>();
        String commandToExecute = "";
        commandToExecute = "SELECT[registered_employee].name AS Profissional,	"
                + " [doctor_appointment].iniciation AS horaInicio,"
                + " [doctor_appointment].finish AS horaFinal,	[specialization].name AS "
                + " Especializacao FROM [doctor_appointment] 	JOIN [availability]	"
                + " ON [availability].id = [doctor_appointment].[id_availability] "
                + " JOIN [registered_employee] 	ON [registered_employee].id = "
                + " [availability].[id_health_professionals] JOIN [specialization]"
                + " ON [specialization].id = [availability].[id_specialization]"
                + " WHERE [doctor_appointment].[date] = '" + dtBanco + "' and doctor_appointment.status_appointment = 1";
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            consultasDia.add(String.format("\tDr/Drª: %s \t[%s]; \n\tHorário: %s - %s;",
                    resultSet.getString("Profissional"), resultSet.getString("Especializacao"),
                    resultSet.getString("horaInicio").substring(0, 5),
                    resultSet.getString("horaFinal").substring(0, 5)));
        }
        return consultasDia;
    }

    /**
     * Método que retorna a lista de consultas.
     *
     * @return consultasDia consultas buscadas
     * @throws SQLException
     * @throws Exception
     */
    public List<String> searchDoctorAppointments() throws SQLException, Exception {
        List<String> consultas = new ArrayList<String>();
        String commandToExecute = "select [doctor_appointment].[date] from doctor_appointment where status_appointment = 1";
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            consultas.add(String.format(resultSet.getString("date")));
        }
        return consultas;
    }

    /**
     * Seleciona horários ocupados de acordo com certa data.
     *
     * @param date data a ser pesquisada.
     * @return horários para esta data.
     * @throws SQLException
     */
    public List<String> SelectBusyHours(String date) throws SQLException {
        List<String> busyHours = new ArrayList();
        String commandToExecute = String.format(" SELECT iniciation "
                + " FROM [doctor_appointment] "
                + " WHERE [doctor_appointment].date = '%s' and doctor_appointment.status_appointment = 1;", date);
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            busyHours.add(resultSet.getTime("iniciation").toString());
        }
        return busyHours;
    }

    /**
     * Método que seleciona os horários livres.
     *
     * @param date data a ser avaliada
     * @return
     * @throws SQLException
     */
    public List<String> selectFreeHours(Date date) throws SQLException {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dtBanco = formatador.format(date);
        List<String> consultasDia = new ArrayList<String>();
        String commandToExecute = "";
        //abaixo, eu vejo quais todas as consultas marcadas
        commandToExecute = "SELECT id_availability FROM [doctor_appointment] WHERE [date] like '" + dtBanco + "' and doctor_appointment.status_appointment = 1;"; //like --> algo como um equals                                                                                                       
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            consultasDia.add(String.format("%d", resultSet.getInt("id_availability")));//atribuindo os ids das consultas que já existem            
        }       
        List<String> horariosLivres = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK);
        //abaixo, vejo todas as disponibilidades existentes
        commandToExecute = "select availability.id as id, availability.iniciation as inicio, " +
            "availability.finish as fim, " +
            "specialization.name as especializacao, " +
            "[registered_employee].name as profissional " +
            "from availability " +
            "JOIN [specialization] 	ON [specialization].id =	 [availability].[id_specialization] " +
            "join [registered_employee]  	ON [registered_employee].id = 	[availability].[id_health_professionals] " +
            "where  availability.week_day = "+ diaDaSemana;
        st = this.connection.createStatement();
        resultSet = st.executeQuery(commandToExecute);
        String id="";
        while (resultSet.next()) {
            if (!consultasDia.contains(Integer.toString(resultSet.getInt("id")))) { //se a disponibilidade não for um dia que já tenha horário marcado
                horariosLivres.add(String.format("\tDr/Drª: %s \t[%s]; \n\tHorário: %s - %s;",
                    resultSet.getString("profissional"), resultSet.getString("especializacao"),
                    resultSet.getString("inicio").substring(0, 5),
                    resultSet.getString("fim").substring(0, 5)));
            }
        }
        return horariosLivres;
        //TODO: refazer esse método para que a lógica esteja no select
    }
    
    /**
     * Método que seleciona os horários livres.
     *
     * @param date data a ser avaliada
     * @return
     * @throws SQLException
     */
    public List<String> searchDoctorAppointments(Date date) throws SQLException {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dtBanco = formatador.format(date);
        List<String> horariosLivres = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK);
        String commandToExecute = "select availability.iniciation, availability.finish from availability "
                + "join doctor_appointment on availability.id = doctor_appointment.id "
                + "where doctor_appointment.date like '"+dtBanco+"' "
                + "and doctor_appointment.status_appointment = 1 "
                + "and availability.week_day = "+diaDaSemana;
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            horariosLivres.add(String.format("Horário livre: %s - %s", resultSet.getString("Iniciation").substring(0, 5), resultSet.getString("Finish").substring(0, 5)));//atribuindo os ids das consultas que já existem            
        }
        return horariosLivres;
    }

    /**
     * Seleciona todas as consultas agendadas para um medico especifico,
     * retornando uma lista com data, horarios, nome do paciente e id da
     * consulta
     *
     * @param healthProfessionalId
     * @return
     * @throws SQLException
     */
    public List<String> selectSpecificDoctorAppointments(int healthProfessionalId) throws SQLException {

        List<String> appointments = new ArrayList();
        String commandToExecute = "SELECT [doctor_appointment].id,"
                + " [doctor_appointment].date,"
                + " [doctor_appointment].iniciation,"
                + " [doctor_appointment].finish,"
                + " [patient].name"
                + " FROM [bdci17].[bdci17].[doctor_appointment]"
                + " JOIN [patient]"
                + " ON [patient].id = [doctor_appointment].id_patient"
                + " JOIN [availability]"
                + " ON [availability].id = [doctor_appointment].id_availability"
                + " WHERE [availability].id_health_professionals = " + healthProfessionalId + " and doctor_appointment.status_appointment = 1;";
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            String appointment = resultSet.getInt("id") + ", "
                    + resultSet.getDate("date") + ", "
                    + resultSet.getTime("iniciation").toString() + ", "
                    + resultSet.getTime("finish").toString() + ", "
                    + resultSet.getString("name");
            appointments.add(appointment);
        }

        return appointments;
    }

    /**
     * Desmarca consulta com id passado como parametro. Retorna boolean
     * determinando se deletou com sucesso
     *
     * @param appointmentId
     * @return
     * @throws SQLException
     */
    public boolean unscheduleAppointment(int appointmentId) throws SQLException {
        String commandToExecute = String.format("DELETE FROM [bdci17].[bdci17].[doctor_appointment] "
                + "WHERE [doctor_appointment].id = %d and doctor_appointment.status_appointment = 1", appointmentId);
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }

    public boolean InsertDoctorAppointment(DoctorAppointment docApp, String date) throws SQLException{
       String commandToExecute = String.format(" INSERT INTO [bdci17].[bdci17].[doctor_appointment] "
               + " (date, iniciation, finish, id_patient, id_availability, observation,recommendation, medical_exam_request, prescription, status_appointment) "
               + " VALUES ('%s', '%s', '%s', %d, %d, '', '', '', '', %d);", 
               date,
               docApp.getDateIniciation(),
               docApp.getDateFinish(),
               docApp.getIdPatient(), 
               docApp.getIdAvailability(),
               1); //status_appointment
       
       Statement st = this.connection.createStatement();
       return st.executeUpdate(commandToExecute) > 0;
    }
    
    public List<DoctorAppointment> SelectDoctorAppointmentByHealthProfessionals(int idHealthProfessionals) throws SQLException, Exception{
        
        List<DoctorAppointment> doctorAppointments = new ArrayList();
        
        String commandToExecute = String.format(" SELECT doctor_appointment.date AS date," +
                                                " doctor_appointment.id AS id_doctor_appointment, " +
                                                " doctor_appointment.iniciation AS iniciation, " +
                                                " doctor_appointment.id_availability AS id_availability, " +
                                                " doctor_appointment.id_patient AS id_patient, " +
                                                " doctor_appointment.finish AS finish, " +
                                                " doctor_appointment.observation AS observation, " +
                                                " doctor_appointment.recommendation AS recommendation, " +
                                                " doctor_appointment.medical_exam_request AS medical_exam_request, " +
                                                " doctor_appointment.prescription AS prescription, " +
                                                " patient.name AS patient_name " +
                                                " FROM doctor_appointment " +
                                                " JOIN availability ON availability.id = doctor_appointment.id_availability " +
                                                " JOIN patient ON doctor_appointment.id_patient = patient.id " +
                                                " WHERE availability.id_health_professionals = %d and doctor_appointment.status_appointment = 1;", idHealthProfessionals);
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            /*
            int idPatient, int idAvailability, String dateIniciation, String dateFinish, String observation, String recommendation, 
            String medicalExamRequest, String prescription, String namePatient
            */
            
            doctorAppointments.add(new DoctorAppointment(
                    resultSet.getInt("id_doctor_appointment"),
                    resultSet.getInt("id_patient"),
                    resultSet.getInt("id_availability"),
                    resultSet.getString("iniciation"),
                    resultSet.getString("finish"),
                    resultSet.getString("observation"),
                    resultSet.getString("recommendation"),
                    resultSet.getString("medical_exam_request"),
                    resultSet.getString("prescription"),
                    resultSet.getString("patient_name"),
                    resultSet.getString("date")
            ));
        }
        
        return doctorAppointments;
    }

    public boolean RemoveDoctorAppointment(int doctorAppointmentID) throws SQLException{       
        String commandToExecute = String.format("DELETE FROM doctor_appointment WHERE id = %d and doctor_appointment.status_appointment = 1;", doctorAppointmentID);
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }
    
    public boolean InsertDoctorAppointmentResult(DoctorAppointment doctorAppointment) throws SQLException{
        
        String commandToExecute = String.format(" UPDATE doctor_appointment " +
                                                " SET doctor_appointment.observation = '%s', " +
                                                " doctor_appointment.recommendation = '%s', " +
                                                " doctor_appointment.medical_exam_request = '%s', " +
                                                " doctor_appointment.prescription = '%s' " +
                                                " WHERE doctor_appointment.id = %d and doctor_appointment.status_appointment = 1;", 
                                                doctorAppointment.getObservation(),
                                                doctorAppointment.getRecommendation(),
                                                doctorAppointment.getMedicalExamRequest(),
                                                doctorAppointment.getPrescription(),
                                                doctorAppointment.getId());
        
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }
    
    public List<DoctorAppointment> SelectDoctorAppointmentUntilCurrentDate() throws SQLException, Exception{
        
        List<DoctorAppointment> doctorAppointments = new ArrayList();
   
        String commandToExecute = String.format(" SELECT doctor_appointment.date AS date," +
                                                " doctor_appointment.id AS id_doctor_appointment, " +
                                                " doctor_appointment.iniciation AS iniciation, " +
                                                " doctor_appointment.id_availability AS id_availability, " +
                                                " doctor_appointment.id_patient AS id_patient, " +
                                                " doctor_appointment.finish AS finish, " +
                                                " doctor_appointment.observation AS observation, " +
                                                " doctor_appointment.recommendation AS recommendation, " +
                                                " doctor_appointment.medical_exam_request AS medical_exam_request, " +
                                                " doctor_appointment.prescription AS prescription, " +
                                                " patient.name AS patient_name " +
                                                " FROM doctor_appointment " +
                                                " JOIN patient ON patient.id = doctor_appointment.id_patient " +
                                                " WHERE date <= GETDATE() AND date >= GETDATE() - 15 and doctor_appointment.status_appointment = 1; ");
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            doctorAppointments.add(new DoctorAppointment(
                    resultSet.getInt("id_doctor_appointment"),
                    resultSet.getInt("id_patient"),
                    resultSet.getInt("id_availability"),
                    resultSet.getString("iniciation"),
                    resultSet.getString("finish"),
                    resultSet.getString("observation"),
                    resultSet.getString("recommendation"),
                    resultSet.getString("medical_exam_request"),
                    resultSet.getString("prescription"),
                    resultSet.getString("patient_name"),
                    resultSet.getString("date")
            ));
        }
        
        return doctorAppointments;
    }
    
    public List<String> SelectAllDoctorAppointment(){
       
        List<String> datas = new ArrayList<String>();
        
        try {
             
            String commandToExecute = String.format(" SELECT [doctor_appointment].[date] AS data_consulta FROM doctor_appointment where doctor_appointment.status_appointment = 1; ");
             
             Statement st = this.connection.createStatement();
             ResultSet resultSet = st.executeQuery(commandToExecute);
             try {
                 while (resultSet.next()) {
                     datas.add(resultSet.getString("data_consulta"));
                 }} catch (SQLException ex) {
                     ex.printStackTrace();
                 }
             
        } 
        catch (SQLException ex) {
             ex.printStackTrace();
        }
         
        return datas;
    }
    
    public boolean UpdateDoctorAppointmentDate(DoctorAppointment doctorAppointment) throws SQLException{
        
        String sqlCommandToExecute = String.format(" UPDATE doctor_appointment " +
                                                   " SET doctor_appointment.date  = '%s', " +
                                                   " doctor_appointment.id_availability = %d " +
                                                   " WHERE doctor_appointment.id =  %d and doctor_appointment.status_appointment = 1; ", doctorAppointment.getDate(), doctorAppointment.getIdAvailability(), doctorAppointment.getId());

        Statement st = this.connection.createStatement();
        return st.executeUpdate(sqlCommandToExecute) > 0;    
    }

    /**
     * Método que retorna as consultas em determinado período.
     */
    public List<String> selectDoctorAppointmentInPeriod(Date inicio, Date fim, int idDoctor) throws Exception{
        List<String> todasConsutlasMedicasPeriodo = new ArrayList<String>();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dtInicio = formatador.format(inicio), //definindo as datas de acordo com o padrão do banco
               dtFinal = formatador.format(fim);    
        formatador = new SimpleDateFormat("yyyy-MM-dd");
        String commandToExecute="";        
        //abaixo, select que verá quais as consultas de determinado médico em determinado período
        commandToExecute = "select [availability].id_health_professionals as medico, "
                + "[doctor_appointment].date as data, "
                + "[doctor_appointment].iniciation as inicio, "
                + "[doctor_appointment].finish as fim "
                + "from doctor_appointment "
                + "join [availability]on [doctor_appointment].id_availability = [availability].id where	"
                + "[availability].id_health_professionals = "+idDoctor+" and "
                + "[doctor_appointment].date between '"+dtInicio+"' and '"+dtFinal+"' and doctor_appointment.status_appointment = 1;";
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
           todasConsutlasMedicasPeriodo.add(String.format("Data: %s \t\t Horário: %s - %s", resultSet.getString("data"), resultSet.getString("inicio").substring(0, 5),resultSet.getString("fim").substring(0, 5)));//atribuindo os ids das consultas que já existem            
        }  
        return todasConsutlasMedicasPeriodo; 
    }
    
    /**
     * Método que retorna as consultas em determinado período.
     */
    public List<String> selectDoctorAppointmentInPeriodForHealthProfessioanal(Date inicio, Date fim, int idDoctor) throws Exception{
        List<String> todasConsutlasMedicasPeriodo = new ArrayList<String>();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dtInicio = formatador.format(inicio), //definindo as datas de acordo com o padrão do banco
               dtFinal = formatador.format(fim);    
        formatador = new SimpleDateFormat("yyyy-MM-dd");
        String commandToExecute="";        
        //abaixo, select que verá quais as consultas de determinado médico em determinado período
        commandToExecute = "select [availability].id_health_professionals as medico, "
                + "[doctor_appointment].date as data, "
                + "[doctor_appointment].iniciation as inicio, "
                + "[doctor_appointment].finish as fim, "
                + "[patient].name as nome "
                + "from doctor_appointment "
                + "join [availability]on [doctor_appointment].id_availability = [availability].id "
                + "join [patient] on [doctor_appointment].id_patient = [patient].id "
                + "where "
                + "[availability].id_health_professionals = "+idDoctor+" and "
                + "[doctor_appointment].date between '"+dtInicio+"' and '"+dtFinal+"' and doctor_appointment.status_appointment = 1;";
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
           todasConsutlasMedicasPeriodo.add(String.format("Data: %s \t\t | Paciente: %s \t\t | Horário: %s - %s", resultSet.getString("data"), resultSet.getString("nome"),
                   resultSet.getString("inicio").substring(0, 5),resultSet.getString("fim").substring(0, 5)));//atribuindo os ids das consultas que já existem            
        }  
        return todasConsutlasMedicasPeriodo; 
    }
    
    /**
     * Método que retorna as consultas em determinado período.
     */
    public List<String> selectDoctorAppointmentInPeriod(Date dt, String nameDoctor) throws Exception{
        List<String> consultas = new ArrayList<String>();
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String data = formatador.format(dt);    
        String commandToExecute="";              
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK);
        //abaixo, select que verá quais as consultas de determinado médico em determinado período
        commandToExecute = "select availability.iniciation as inicio, " +
            "availability.finish as fim " +
            "from availability " +
            "join registered_employee " +
            "ON availability.id_health_professionals = registered_employee.id " +
            "where availability.week_day = "+diaDaSemana+" and registered_employee.name = '"+nameDoctor+"'";
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
           consultas.add(String.format("%s - %s", resultSet.getString("inicio").substring(0, 5),resultSet.getString("fim").substring(0, 5)));//atribuindo os ids das consultas que já existem            
        }  
        return consultas; 
    }
    
    /**
     * Verifica se médico trabalha em certo dia da semana.
     */
    public boolean workAt(Date dt, String nameDoctor) throws SQLException{
        boolean trabalha=false;        
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK);
        String command="select	availability.week_day as diaSemana, " +
            "availability.iniciation as horaInicio, " +
            "availability.finish as horaFinal " +
            "from availability " +
            "join registered_employee " +
            "	ON availability.id_health_professionals = registered_employee.id " +
            "	where registered_employee.name = '"+nameDoctor+"' and availability.week_day = "+diaDaSemana;
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(command);
        if(resultSet.next())
            trabalha=true;
        return trabalha;
    }

    /**
     * Insere uma indisponibilidade no BD.
     */
    public boolean insertDoctorUnavailability(Date dt, String hrInicio, String hrFinal, int idAvailability) throws SQLException{
        boolean insercao=false;
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String data = formatador.format(dt);    
        String comando = "insert into doctor_appointment(date, iniciation, finish, id_patient, id_availability, observation, recommendation, medical_exam_request, prescription, status_appointment) values"
                + "('"+data+"', '"+hrInicio.toString()+"', '"+hrFinal.toString()+"', 0, "+idAvailability+", '', '', '', '', 1)";
        Statement st = this.connection.createStatement();
        return st.executeUpdate(comando) > 0;
    }

    /**
     * Verificar se o dia e mês selecionados para consulta não são FERIADO
     *
     * @param day
     * @param month
     * @return
     * @throws SQLException
     */
    public String checkIfHoliday(int day, int month) throws SQLException {
        String result = "ok";
        String commandToExecute = "SELECT name"
                + " FROM holiday"
                + " WHERE day_holiday = '" + day + "'"
                + " AND month_holiday = '" + month + "';";
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        if (resultSet.next()) {
            result = resultSet.getString("name");
        }
        return result;
    }
}