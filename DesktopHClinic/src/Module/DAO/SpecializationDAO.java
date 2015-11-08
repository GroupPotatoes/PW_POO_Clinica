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
}
