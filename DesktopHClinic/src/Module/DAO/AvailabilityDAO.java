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
public class AvailabilityDAO {
    
    private Connection connection;
    
    public AvailabilityDAO(Connection connection) {
        this.connection = connection;
    }
    /**
     * Grava no BD uma LISTA de disponibilidades (de um unico profissional)
     * @param schedule
     * @return
     * @throws SQLException 
     */
    public boolean setAvailability(List<Availability> schedule) throws SQLException {
       
        String commandToExecute = String.format("INSERT INTO [bdci17].[bdci17].[availability] "
                + "(week_day, iniciation, finish, id_health_professionals, id_specialization) "
                + "VALUES ");
        //Adiciona cada Availability criada na tela ao string:
        for (Availability workday : schedule) {
            if(workday.getId() < 1) {
                commandToExecute += "(" + workday.getWeekDay() + "," + "'" + workday.getIniciation() + "'" + "," 
                    + "'" + workday.getFinish() + "'"  + "," + workday.getIdHealthProfessionals() + "," + workday.getIdSpecialization() + "), ";
            }
        }
        //apaga o espaço e a virgula apos a ultima inserção de valores
        commandToExecute = commandToExecute.substring(0, commandToExecute.length() - 2);
        //insere ponto-e-virgula ao final da string!
        commandToExecute += ";";
        System.out.println(commandToExecute);
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }
    
    /**
     * Retorna uma lista com todas as disponibilidades de um profissional de id x
     * @param idHealthProfessional
     * @return
     * @throws SQLException 
     */
    public List<Availability> getAllAvailabilities(int idHealthProfessional) throws SQLException, Exception {
        Specialization specialization = new SpecializationDAO(ConnectionSetup.connection).getSpecialization(idHealthProfessional);

        String commandToExecute = String.format("SELECT id, week_day, iniciation, finish "
                + "FROM [bdci17].[bdci17].[availability] WHERE [availability].id_health_professionals = %d", idHealthProfessional);
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        List<Availability> availabilities = new ArrayList<Availability>();
        while(resultSet.next()) {
            availabilities.add(new Availability(resultSet.getInt("id"), idHealthProfessional, specialization.getId(), resultSet.getInt("week_day"), resultSet.getString("iniciation"), resultSet.getString("finish")));
        }
        return availabilities;
    }
    
    public boolean deleteAvailabilities(List<Availability> toDelete) throws SQLException {
        String commandToExecute = String.format("DELETE FROM [bdci17].[bdci17].[availability] "
                + "WHERE [availability].id ");
        if(toDelete.size() > 1) {
            commandToExecute += "IN (";
            //Adiciona cada Availability criada na tela ao string:
            for (Availability workday : toDelete) {
                commandToExecute += workday.getId() + ",";
            }
            //apaga o espaço e a virgula apos a ultima inserção de valores
            commandToExecute = commandToExecute.substring(0, commandToExecute.length() - 1);
            //insere ponto-e-virgula ao final da string!
            commandToExecute += ");";
        }
        else {
            commandToExecute += "= " + toDelete.get(0).getId() + ";";
        }
        System.out.println(commandToExecute);
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }
}
