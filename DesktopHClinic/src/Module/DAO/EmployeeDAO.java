package Module.DAO;

import Module.DBO.ConnectionSetup;
import Module.DBO.RegisteredEmployee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }
    
    public List<RegisteredEmployee> SelectAllEmployee() throws SQLException, Exception {

        List<RegisteredEmployee> registeredEmployeeList = new ArrayList<RegisteredEmployee>();

        String commandToExecute = String.format(" SELECT * " +
                                                " FROM employee " +
                                                " JOIN registered_employee ON registered_employee.id = employee.id_registered_employee" + 
                                                " WHERE [registered_employee].[inactive] = 0 AND [registered_employee].[id] != %d;", ConnectionSetup.id);

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //int id, String name, String password, String login
            RegisteredEmployee employee = new RegisteredEmployee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("login"));
            registeredEmployeeList.add(employee);
        }

        return registeredEmployeeList;
    }
    
    public List<RegisteredEmployee> SearchEmployee(String searchWord) throws SQLException, Exception {

        List<RegisteredEmployee> registeredEmployeeList = new ArrayList<RegisteredEmployee>();
        
        String commandToExecute = "SELECT registered_employee.id AS id_registered_employee, " +
                                "registered_employee.name AS name, " +
                                "registered_employee.password AS password, " +
                                "registered_employee.login AS login " +
                                " FROM employee " +
                                " JOIN registered_employee ON registered_employee.id = employee.id_registered_employee " +
                                " WHERE [inactive] = 0 AND registered_employee.name LIKE '%" + searchWord + "%';";

        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //name, password, login
            RegisteredEmployee employee = new RegisteredEmployee(resultSet.getInt("id_registered_employee"), resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("login"));
            registeredEmployeeList.add(employee);
        }

        return registeredEmployeeList;
    }
    
}
