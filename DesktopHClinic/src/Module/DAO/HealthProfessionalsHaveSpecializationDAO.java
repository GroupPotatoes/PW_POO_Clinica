/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Module.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HealthProfessionalsHaveSpecializationDAO {
    private Connection connection;

    public HealthProfessionalsHaveSpecializationDAO(Connection connection) {
        this.connection = connection;
    }
    /**
     * Retorna um objeto com idHealthProfessional e id_specialization 
     * @param id (idHealthProfessional OU id_registered_employee)
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public HealthProfessionalsHaveSpecialization getHealthProfessionalsHaveSpecialization(int id) throws SQLException, Exception {
        String commandToExecute = String.format("SELECT * FROM [bdci17].[bdci17].[health_professionals_have_specialization]"
                + "WHERE id_health_professionals = %d;", id);
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        HealthProfessionalsHaveSpecialization relation;
        if(resultSet.next()) {
            relation = new HealthProfessionalsHaveSpecialization(id, resultSet.getInt("id_specialization"));
            return relation;
        }
        return null;
    }
}
