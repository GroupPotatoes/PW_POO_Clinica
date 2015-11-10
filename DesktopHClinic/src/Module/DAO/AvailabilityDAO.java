/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author amanda
 */
public class AvailabilityDAO {
    
    private Connection connection;
    
    public AvailabilityDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean setAvailability(List<Availability> schedule) throws SQLException {
       
        String commandToExecute = String.format("INSERT INTO [bdci17].[bdci17].[availability] "
                + "(week_day, iniciation, finish, id_health_professionals, id_specialization) "
                + "VALUES ");
        //Adiciona cada Availability criada na tela ao string:
        for (Availability workday : schedule) {
            commandToExecute += "(" + workday.getWeekDay() + "," + "'" + workday.getIniciation() + "'" + "," 
                    + "'" + workday.getFinish() + "'"  + "," + workday.getIdHealthProfessionals() + "," + workday.getIdSpecialization() + "), ";
        }
        //apaga o espaço e a virgula apos a ultima inserção de valores
        commandToExecute = commandToExecute.substring(0, commandToExecute.length() - 2);
        //insere ponto-e-virgula ao final da string!
        commandToExecute += ";";
        System.out.println(commandToExecute);
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }
}
