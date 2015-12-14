
package Module.DAO;

import Module.DBO.ConnectionSetup;
import Module.DBO.Specialization;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public Specialization getSpecialization(int idHealthProfessionals) throws SQLException, Exception {

        Specialization spec;
        int id_specialization = new HealthProfessionalsHaveSpecializationDAO(ConnectionSetup.connection).getHealthProfessionalsHaveSpecialization(idHealthProfessionals).getIdSpecialization();
       
        String commandToExecute = String.format("SELECT * FROM [bdci17].[bdci17].[specialization]"
                    + "WHERE id = %d;", id_specialization);
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        if (resultSet.next()) {
            //id, name
            spec = new Specialization(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("id_professions"));
            return spec;
        }
        return null;
    }

    public List<Specialization> SelectAllSpecialization() throws SQLException, Exception{
        
        List<Specialization> specializations = new ArrayList();
        
        String commandToExecute = "SELECT * FROM [bdci17].[bdci17].[specialization];";
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while(resultSet.next())
        {
           //int id, String name
           Specialization specialization = new Specialization(
           resultSet.getInt("id"),
           resultSet.getString("name")
           );
           
           specializations.add(specialization);
        }
        
        return specializations;
        
    }
}
