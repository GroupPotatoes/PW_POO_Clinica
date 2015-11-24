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
public class RoleDAO {
   private Connection connection;

    public RoleDAO(Connection connection) {
        this.connection = connection;
    }
    
    /**
     * Devolve lista com roles presentes no BD. 
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public List<Role> SelectAllRole() throws SQLException, Exception {

        List<Role> roles = new ArrayList<Role>();

        String commandToExecute = String.format("SELECT * FROM [bdci17].[bdci17].[role];");

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //id, name
            Role role = new Role(resultSet.getInt("id"), resultSet.getString("name"));
            roles.add(role);
        }

        return roles;
    }
}
