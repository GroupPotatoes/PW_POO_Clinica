package Module.DAO;

import clinic.MeuPreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HealthProfessionalsDAO {

    private MeuPreparedStatement connection;
    public static Patient currentPatient;

    public HealthProfessionalsDAO() throws ClassNotFoundException {
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

    public List<HealthProfessionals> SelectHealthProfessionals(int specializationID, int dayofweek) throws Exception {

        List<HealthProfessionals> healthProfessionalsList = new ArrayList();

        String commandToExecute = String.format(" SELECT [registered_employee].[name] AS hp_name, "
                + " [registered_employee].[id] AS hp_id "
                + " FROM [specialization] "
                + " JOIN [health_professionals_have_specialization] ON [health_professionals_have_specialization].[id_specialization] = [specialization].[id] "
                + " JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals_have_specialization].[id_health_professionals] "
                + " JOIN [availability] ON [availability].[id_specialization] = [specialization].[id] "
                + " WHERE [specialization].id = %d AND [availability].[week_day] = %d; ", specializationID, dayofweek);

        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            HealthProfessionals hp = new HealthProfessionals(resultSet.getInt("hp_id"), resultSet.getString("hp_name"));
            healthProfessionalsList.add(hp);
        }

        return healthProfessionalsList;
    }

}
