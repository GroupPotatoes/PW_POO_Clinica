package Module.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DAO das consultas médicas.
 * @author amanda
 */
public class DoctorAppointmentDAO {
    
    private Connection connection; //Conexão ao BD
     
    /**
     * Construtor da classe DoctorAppointmentDAO.
     * @param connection conexão ao BD
     */
    public DoctorAppointmentDAO(Connection connection){
        this.connection = connection;
    }
    
    /**
     * Método que retorna uma lista de consultas em determinada data.
     * @param data data da consulta
     * @return consultasDia consultas da data selecionada
     * @throws SQLException
     * @throws Exception 
     */
    public List<String> searchDoctorAppointments(Date data) throws SQLException, Exception {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        String dtBanco = formatador.format(data);
        List<String> consultasDia = new ArrayList<String>();
        String commandToExecute = "";
        commandToExecute =  "SELECT[registered_employee].name AS Profissional,	"
                + " [doctor_appointment].iniciation AS horaInicio,"
                + " [doctor_appointment].finish AS horaFinal,	[specialization].name AS "
                + " Especializacao FROM [doctor_appointment] 	JOIN [availability]	"
                + " ON [availability].id = [doctor_appointment].[id_availability] "
                + " JOIN [registered_employee] 	ON [registered_employee].id = "
                + " [availability].[id_health_professionals] JOIN [specialization]"
                + " ON [specialization].id = [availability].[id_specialization]"
                + " WHERE [doctor_appointment].[date] = '"+dtBanco+"'";
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            consultasDia.add(String.format(">> Dr/Drª: %s \t[%s] \tHorário: %s - %s",
                    resultSet.getString("Profissional"), resultSet.getString("Especializacao"), 
                    resultSet.getString("horaInicio").substring(0, 5), 
                    resultSet.getString("horaFinal").substring(0, 5)));
        }
        return consultasDia;
    }

    /**
     * Método que retorna a lista de consultas.
     * @return consultasDia consultas buscadas
     * @throws SQLException
     * @throws Exception 
     */
    public List<String> searchDoctorAppointments() throws SQLException, Exception {
        List<String> consultas = new ArrayList<String>();
        String commandToExecute = "";
        commandToExecute = "select date from doctor_appointment";
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            consultas.add(String.format(resultSet.getString("date")));
        }
        return consultas;
    }
}
