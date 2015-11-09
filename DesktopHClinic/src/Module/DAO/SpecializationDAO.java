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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amanda
 */
public class SpecializationDAO {

    private Connection connection;

    public SpecializationDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Specialization> SelectSpecializations(int professionId) throws SQLException, Exception {

        List<Specialization> specializations = new ArrayList<Specialization>();

        String commandToExecute = String.format("SELECT * FROM [bdci17].[bdci17].[specialization]"
                + "WHERE id_professions = %d;", professionId);

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //id, name
            Specialization specialization = new Specialization(resultSet.getInt("id"), resultSet.getString("name"));
            specializations.add(specialization);
        }

        return specializations;
    }

    /**
     * Get single specialization with the idHealthProfessionals, which is the same as idRegisteredEmployee
     * @param idHealthProfessionals
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public Specialization selectSpecialization(int idHealthProfessionals) throws SQLException, Exception {

        Specialization spec;

        String commandToGetProfessionId = String.format("SELECT * FROM [bdci17].[bdci17].[health_professionals_have_specialization]"
                + "WHERE id_health_professionals = %d;", idHealthProfessionals);
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToGetProfessionId);
        if (resultSet.next()) {

            int professionId = resultSet.getInt("id");
            String commandToExecute = String.format("SELECT * FROM [bdci17].[bdci17].[specialization]"
                    + "WHERE id_professions = %d;", professionId);

            resultSet = st.executeQuery(commandToExecute);
            if (resultSet.next()) {
                //id, name
                spec = new Specialization(resultSet.getInt("id"), resultSet.getString("name"));
                return spec;
            }
        }
        return null;
    }
}
