/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author amanda
 */
public class AvailabilityDAO {
    
    private Connection connection;
    
    public AvailabilityDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean SetAvailability(Availability schedule) throws SQLException {
        String commandToExecute = String.format("INSERT INTO [bdci17].[bdci17].[availability] "
                + "(week_day, iniciation, finish, id_health_professionals, id_specialization) "
                + "VALUES (%d, '%s', '%s', %d, %d)", schedule.getWeekDay(), schedule.getIniciation(), schedule.getFinish(), schedule.getIdHealthProfessionals(), schedule.getIdSpecialization());
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }
}
