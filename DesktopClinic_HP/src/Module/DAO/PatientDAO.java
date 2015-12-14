package Module.DAO;

import Module.DBO.Patient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class PatientDAO {
    
    private Connection connection;
    
    public PatientDAO(Connection connection){
        this.connection = connection;
    }

    public List<Patient> SelectAllPatient() throws SQLException, Exception
    {
        List<Patient> patients = new ArrayList();
        
        String commandToExecute = "SELECT * FROM [bdci17].[bdci17].[patient] WHERE [inactive] = 0 AND [id] != 0;";
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while(resultSet.next())
        {
           //int id, String name, String cpf
           Patient patient = new Patient(
           resultSet.getInt("id"),
           resultSet.getString("name"),
           resultSet.getString("cpf")
           );
           
           patients.add(patient);
        }
        
        return patients;
    }
    
    public List<Patient> SearchPatient(String searchWord) throws SQLException, Exception{
        
        List<Patient> patients = new ArrayList();
        
        //LIKE '%%s%'; = pesquisa a palavra estando no começo, meio ou final 
        String commandToExecute = "SELECT * FROM [bdci17].[bdci17].[patient] WHERE [inactive] = 0 AND [id] != 0 AND [name] LIKE '%"+searchWord+"%';";
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while(resultSet.next())
        {
           //int id, String name, String cpf
           Patient patient = new Patient(
           resultSet.getInt("id"),
           resultSet.getString("name"),
           resultSet.getString("cpf")
           );
           
           patients.add(patient);
        }
        
        return patients;
    }
    
    public void FecharConexao()  {
        try{
            this.connection.close();
            System.out.println("Conexão fechada.");
        }catch (SQLException e) {
            // se ocorrerem erros na conexão
            System.out.println("Problemas ao fechar a conexão: " + e);
        }  
    }
}
