package Module.DAO;

import clinic.MeuPreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvailabilityDAO {

    private MeuPreparedStatement connection;

    public AvailabilityDAO() {
        try {
            /*Criando conexão.*/

            this.connection = new MeuPreparedStatement("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://" + ConnectionSetup.serverName + ":" + ConnectionSetup.port
                    + ";databasename=" + ConnectionSetup.database + ";", ConnectionSetup.login, ConnectionSetup.password);

            if (!connection.getConnection().isValid(0)) {
                System.err.println(("Conexão inválida"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SpecializationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Availability> SelectAllAvailability(int idSpecialization, int dayofweek, int idHealthProfessionals) throws SQLException, Exception {

        List<Availability> availabilities = new ArrayList();
        String commandToExecute = "";
        if (idHealthProfessionals != 0) {
            commandToExecute = String.format(" SELECT [health_professionals].id_registered_employee, "
                    + " [health_professionals].cpf, "
                    + " [health_professionals].id_class, "
                    + " [registered_employee].name, "
                    + " [availability].id AS availability_id, "
                    + " [availability].week_day, "
                    + " [availability].iniciation, "
                    + " [availability].finish "
                    + " FROM [bdci17].[bdci17].[availability] "
                    + " JOIN [health_professionals] ON [health_professionals].[id_registered_employee] = [availability].[id_health_professionals] "
                    + " JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals].[id_registered_employee] "
                    + " WHERE [availability].[id_specialization] = %d AND [availability].week_day = %d  AND [health_professionals].[id_registered_employee] = %d;", idSpecialization, dayofweek, idHealthProfessionals);
        } else {
            commandToExecute = String.format(" SELECT [health_professionals].id_registered_employee, "
                    + " [health_professionals].cpf, "
                    + " [health_professionals].id_class, "
                    + " [registered_employee].name, "
                    + " [availability].id AS availability_id, "
                    + " [availability].week_day, "
                    + " [availability].iniciation, "
                    + " [availability].finish "
                    + " FROM [bdci17].[bdci17].[availability] "
                    + " JOIN [health_professionals] ON [health_professionals].[id_registered_employee] = [availability].[id_health_professionals] "
                    + " JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals].[id_registered_employee] "
                    + " WHERE [availability].[id_specialization] = %d AND [availability].week_day = %d;", idSpecialization, dayofweek, idHealthProfessionals);
        }

        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //int idRegisteredEmployee, String cpf, String idClass
            HealthProfessionals hp = new HealthProfessionals(resultSet.getInt("id_registered_employee"), resultSet.getString("cpf"), resultSet.getString("id_class"), resultSet.getString("name"));
            //int id, int week, Date iniciation, Date finish, HealthProfessionals healthProfessionals, int idSpecialization
            Availability av = new Availability(resultSet.getInt("availability_id"), resultSet.getInt("week_day"), resultSet.getTime("iniciation"), resultSet.getTime("finish"), hp, idSpecialization);
            availabilities.add(av);
        }

        return availabilities;
    }

    public String SelectIniciationAvailability(int idAvailability) throws SQLException {

        String commandToExecute = String.format("SELECT iniciation FROM [bdci17].[bdci17].[availability] WHERE [availability].[id] = %d", idAvailability);

        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        if (resultSet.next()) {
            return resultSet.getTime("iniciation").toString();
        }

        return null;
    }

    public String SelectFinishAvailability(int idAvailability) throws SQLException {

        String commandToExecute = String.format("SELECT finish FROM [bdci17].[bdci17].[availability] WHERE [availability].[id] = %d", idAvailability);

        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        if (resultSet.next()) {
            return resultSet.getTime("finish").toString();
        }

        return null;
    }

    /**
     * Retorna uma Availability de acordo com seu id
     *
     * @param idAvailability
     * @return
     * @throws SQLException
     */
    public Availability getAvailability(int idAvailability) throws SQLException, Exception {
        Availability av = null;
        String commandToExecute = String.format("SELECT [availability].week_day, [availability].iniciation, [availability].finish, [availability].id_specialization, "
                + " [bdci17].[bdci17].[registered_employee].[name] AS empName, "
                + " [bdci17].[bdci17].[registered_employee].[id] AS idRegisteredEmployee, "
                + " [bdci17].[bdci17].[health_professionals].[id_class] AS class "
                + " FROM [bdci17].[bdci17].[availability] "
                + " JOIN [bdci17].[bdci17].[health_professionals] ON [bdci17].[bdci17].[health_professionals].[id_registered_employee] = [availability].[id_health_professionals] "
                + " JOIN [bdci17].[bdci17].[registered_employee] ON [bdci17].[bdci17].[registered_employee].[id] = [health_professionals].[id_registered_employee] "
                + " WHERE [availability].id = %d", idAvailability);
        Statement st = this.connection.getConnection().createStatement();
        ResultSet rs = st.executeQuery(commandToExecute);
        if (rs.next()) {
            HealthProfessionals hp = new HealthProfessionals(rs.getInt("idRegisteredEmployee"), rs.getString("empName"), rs.getString("class"));
//nt id, int week, Date iniciation, Date finish, HealthProfessionals healthProfessionals, int idSpecialization) throws Exception{
            av = new Availability(
                    idAvailability,
                    rs.getInt("week_day"),
                    rs.getTime("iniciation"),
                    rs.getTime("finish"),
                    hp,
                    rs.getInt("id_specialization")
            );
        }
        return av;
    }
}
