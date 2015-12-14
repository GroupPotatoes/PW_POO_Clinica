
package Module.DAO;

import clinic.MeuPreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpecializationDAO {
    
    private MeuPreparedStatement connection;
    
    public SpecializationDAO(){
        try {
                /*Criando conexão.*/

                this.connection = new MeuPreparedStatement ("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://" + ConnectionSetup.serverName + ":" + ConnectionSetup.port
                        + ";databasename=" + ConnectionSetup.database + ";", ConnectionSetup.login, ConnectionSetup.password);

                if (!connection.getConnection().isValid(0)) {
                    System.err.println(("Conexão inválida"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(SpecializationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Specialization> SelectAllSpecialization() throws SQLException, Exception{
        
        List<Specialization> specializations = new ArrayList();
        
        String commandToExecute = String.format("SELECT * FROM [bdci17].[bdci17].[specialization];");
        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
               //int id,String nome,int idProfessions
              Specialization specialization = new Specialization(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("id_Professions"));
              specializations.add(specialization);
        }
        
        return specializations;
    }
}
