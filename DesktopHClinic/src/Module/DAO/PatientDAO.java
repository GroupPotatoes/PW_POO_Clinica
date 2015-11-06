package Module.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
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
    
    public boolean InsertPatient(Patient patient, PhoneNumber phoneNumber) throws SQLException{
        /*
            PATIENT
            String name, String cep, String rg, Date birthDate, String cpf, String number, 
            String complement, String login, String password
        
            PHONENUMBER
            int idPhoneType, int idPatient, int areaCode, String number
        */
        
        ///TODO: Verificar se todos os campos existem no form
        /// TODO: Verificar como o tipo Date será adicionado.
        String commandToInsertPatient = String.format("INSERT INTO [bdci17].[bdci17].[patient] (name, cpf, rg, birth_date, cep, number, complement, login, password) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
        patient.getName(), patient.getCpf(), patient.getRg(), patient.getBirthDate(), patient.getCep(),patient.getNumber(), patient.getComplement(), patient.getLogin(), patient.getPassword());
        
        String commandToInsertPhone = String.format("INSERT INTO [bdci17].[bdci17].[phone_number](id_phone_type, id_patient, area_code, number) VALUES (%d, %d, %d, '%s');",
        phoneNumber.getIdPhoneType(), phoneNumber.getIdPatient(), phoneNumber.getAreaCode(), phoneNumber.getNumber());
        
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToInsertPatient) > 0 && st.executeUpdate(commandToInsertPhone) > 0;
    }
    
    public boolean ExistLogin(String login, String password) throws SQLException{
        
        String commandToExecute = String.format("SELECT * FROM  [bdci17].[bdci17].[patient] WHERE [inactive]=0 AND [login]='%s' AND [password]='%s';", login, password); 
       
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        if(resultSet.next())
            ConnectionSetup.id = resultSet.getInt("id");
        
        return ConnectionSetup.id > 0;
    }
   
    public boolean RemovePatient(int idPatient) throws SQLException{
        
        return false;
    }
    
    public boolean DisablePatient(int idPatient) throws SQLException{
        
        String commandToExecute = String.format("UPDATE [bdci17].[bdci17].[patient] SET [inactive] = 1 WHERE [id] = %d;", idPatient);
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }
    
    public boolean UpdatePatient(Patient patient) throws SQLException{
        
        /*
        int id, String name, String cep, String rg, Date birthDate, String cpf, String number, String complement, String login, String password
        */
        
        ///TODO: Verificar como insere Data
        String commandToExecute = String.format("UPDATE [bdci17].[bdci17].[patient] SET [name]='%s', [cpf]='%s', [rg]='%s', [number]='%s', [complement]='%s', [cep]='%s', [birth_date]='%s', [login]='%s', [password]='%s' WHERE [id]=%d;",
        patient.getName(), patient.getCpf(), patient.getRg(), patient.getNumber(), patient.getComplement(), patient.getCep(), patient.getBirthDate(), patient.getLogin(), patient.getPassword(), patient.getId());
        
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }
    
    public List<Patient> SearchPatient(String searchType, String searchWord) throws SQLException, Exception{
        
        List<Patient> patients = new ArrayList();
        
        //LIKE '%%s%'; = pesquisa a palavra estando no começo, meio ou final 
        String commandToExecute = "SELECT * FROM [bdci17].[bdci17].[patient] WHERE [" + searchType + "] LIKE '%"+searchWord+"%';";
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while(resultSet.next())
        {
            //TODO: Verificar o tipo Data.
           //String name, String cep, String rg, Date birthDate, String cpf, String number, String complement, String login, String password
           Patient patient = new Patient(
           resultSet.getString("name"),
           resultSet.getString("cep"),
           resultSet.getString("rg"),
           resultSet.getDate("birth_date"),
           resultSet.getString("cpf"),
           resultSet.getString("number"),
           resultSet.getString("complement"),
           resultSet.getString("login"),
           resultSet.getString("password")
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
