package Module.DAO;

import clinic.MeuPreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorAppointmentDAO {

    private MeuPreparedStatement connection;
    public static Patient currentPatient;

    public DoctorAppointmentDAO() throws ClassNotFoundException {
        try {
            /*Criando conexão.*/

            this.connection = new MeuPreparedStatement("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://" + ConnectionSetup.serverName + ":" + ConnectionSetup.port
                    + ";databasename=" + ConnectionSetup.database + ";", ConnectionSetup.login, ConnectionSetup.password);

            if (!connection.getConnection().isValid(0)) {
                System.err.println(("Conexão inválida"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<DoctorAppointment> SelectAllPatientDoctorAppointment(int patientID) throws SQLException, Exception {

        List<DoctorAppointment> doctorAppointmentList = new ArrayList();

        String commandToExecute = String.format("SELECT [doctor_appointment].[id] AS doctor_appointment_id, "
                + "[doctor_appointment].[date], "
                + "[doctor_appointment].[iniciation], "
                + "[doctor_appointment].[finish], "
                + "[doctor_appointment].[id_patient], "
                + "[doctor_appointment].[id_availability], "
                + "[doctor_appointment].[observation], "
                + "[doctor_appointment].[recommendation], "
                + "[doctor_appointment].[medical_exam_request], "
                + "[doctor_appointment].[prescription], "
                + "[specialization].[name] AS specialization_name "
                + "FROM [bdci17].[bdci17].[doctor_appointment] "
                + "JOIN [availability] ON [availability].[id] = [doctor_appointment].[id_availability] "
                + "JOIN [specialization] ON [specialization].[id] = [availability].[id_specialization] "
                + "WHERE [doctor_appointment].[id_patient] = %d;", patientID);
        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //int id, int idPatient, int idAvailability, String iniciation, String finish, String date
            DoctorAppointment doctorapp = new DoctorAppointment(
                    ///TODO: perguntar pro andré a questao de data e horario
                    resultSet.getInt("doctor_appointment_id"),
                    patientID,
                    resultSet.getInt("id_availability"),
                    resultSet.getString("specialization_name"),
                    resultSet.getString("iniciation"),
                    resultSet.getString("finish"),
                    resultSet.getString("date"),
                    resultSet.getString("observation"),
                    resultSet.getString("recommendation"),
                    resultSet.getString("medical_exam_request"),
                    resultSet.getString("prescription")
            );

            doctorAppointmentList.add(doctorapp);
        }

        return doctorAppointmentList;

    }

    /**
     * Retorna um objeto DoctorAppointment completo, com resultados.
     *
     * @param docAppId
     * @return docApp (se nulo, id inválido)
     * @throws SQLException
     */
    public DoctorAppointment getAppointmentResults(int docAppId) throws SQLException {
        DoctorAppointment docApp = null;
        String commandToExecute = "SELECT [doctor_appointment].[id] AS doctor_appointment_id, "
                + "[doctor_appointment].[date], "
                + "[doctor_appointment].[iniciation], "
                + "[doctor_appointment].[finish], "
                + "[doctor_appointment].[id_patient], "
                + "[doctor_appointment].[id_availability], "
                + "[doctor_appointment].[observation], "
                + "[doctor_appointment].[recommendation], "
                + "[doctor_appointment].[medical_exam_request], "
                + "[doctor_appointment].[prescription], "
                + "[specialization].[name] AS specialization_name "
                + "FROM [bdci17].[bdci17].[doctor_appointment] "
                + "JOIN [availability] ON [availability].[id] = [doctor_appointment].[id_availability] "
                + "JOIN [specialization] ON [specialization].[id] = [availability].[id_specialization] "
                + "WHERE [doctor_appointment].[id] LIKE '%" + docAppId + "%';";
        Statement st = this.connection.getConnection().createStatement();
        ResultSet rs = st.executeQuery(commandToExecute);
        if (rs.next()) {
            docApp = new DoctorAppointment(
                    rs.getInt("doctor_appointment_id"),
                    rs.getInt("id_patient"),
                    rs.getInt("id_availability"),
                    rs.getString("specialization_name"),
                    rs.getString("iniciation"),
                    rs.getString("finish"),
                    rs.getString("date"),
                    rs.getString("observation"),
                    rs.getString("recommendation"),
                    rs.getString("medical_exam_request"),
                    rs.getString("prescription")
            );
 //deste construtor: DoctorAppointment(int id, int idPatient, int idAvailability, String specializationName, 
            //String iniciation, String finish, String date, String observation, String recommendation, 
//String medicalExamRequest, String prescription)

        }
        return docApp;
    }

    public List<DoctorAppointment> SearchDoctorAppointment(String specializationName) throws SQLException, Exception {

        List<DoctorAppointment> doctorAppointmentList = new ArrayList();

        String commandToExecute = "SELECT [doctor_appointment].[id] AS doctor_appointment_id, "
                + "[doctor_appointment].[date], "
                + "[doctor_appointment].[iniciation], "
                + "[doctor_appointment].[finish], "
                + "[doctor_appointment].[id_patient], "
                + "[doctor_appointment].[id_availability], "
                + "[specialization].[name] AS specialization_name "
                + "FROM [bdci17].[bdci17].[doctor_appointment] "
                + "JOIN [availability] ON [availability].[id] = [doctor_appointment].[id_availability] "
                + "JOIN [specialization] ON [specialization].[id] = [availability].[id_specialization] "
                + "WHERE [specialization].[name] LIKE '%" + specializationName + "%';";

        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //int id, int idPatient, int idAvailability, String iniciation, String finish, String date
            DoctorAppointment doctorapp = new DoctorAppointment(
                    ///TODO: perguntar pro andré a questao de data e horario
                    resultSet.getInt("doctor_appointment_id"),
                    resultSet.getInt("id_patient"),
                    resultSet.getInt("id_availability"),
                    resultSet.getString("iniciation"),
                    resultSet.getString("finish"),
                    resultSet.getString("date"),
                    resultSet.getString("specialization_name")
            );

            doctorAppointmentList.add(doctorapp);
        }

        return doctorAppointmentList;
    }

    /**
     * Insere uma consulta agendada pelo paciente via WEB no bd.
     *
     * @param docApp
     * @return
     * @throws SQLException
     */
    public boolean insertDoctorAppointment(DoctorAppointment docApp) throws SQLException {

        boolean wasInsert = false;

        String commandToExecute = String.format(" INSERT INTO [bdci17].[bdci17].[doctor_appointment] "
                + " (date, iniciation, finish, id_patient, id_availability, observation,recommendation, medical_exam_request, prescription) "
                + " VALUES ('%s', '%s', '%s', %d, %d, '', '', '', '');", docApp.getDate(), docApp.getIniciation(), docApp.getFinish(), docApp.getIdPatient(), docApp.getIdAvailability());

        /*"INSERT INTO [bdci17][bdci17][doctor_appontment]"
         + "(date, iniciation, finish, id_patient, id_availability, observation, "
         + "recommendation, medical_exam_request, prescription) VALUES "
         + "('" + docApp.getDate() + "', '" + docApp.getIniciation() + "', '" + docApp.getFinish() 
         + "'," + docApp.getIdPatient() + "," + docApp.getIdAvailability() + ", '', '', '', '');";*/
        this.connection.prepareStatement(commandToExecute);
        wasInsert = this.connection.executeUpdate() > 0;
        this.connection.commit(); //envia de fato o update para o banco

        return wasInsert;
    }

    public List<String> SelectBusyHours(String date) throws SQLException {

        List<String> busyHours = new ArrayList();

        String commandToExecute = String.format(" SELECT iniciation "
                + " FROM [doctor_appointment] "
                + " WHERE [doctor_appointment].date = '%s';", date);

        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            busyHours.add(resultSet.getTime("iniciation").toString());
        }

        return busyHours;
    }

    public boolean RemoveDoctorAppointment(int doctorAppID) throws SQLException {

        boolean wasRemove = false;

        String commandToExecute = String.format("DELETE FROM [bdci17].[bdci17].[doctor_appointment] WHERE id = %d", doctorAppID);

        this.connection.prepareStatement(commandToExecute);
        wasRemove = this.connection.executeUpdate() > 0;
        this.connection.commit();

        return wasRemove;
    }
}
