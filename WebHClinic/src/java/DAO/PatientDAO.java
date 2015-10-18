/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection.DAO;

import Module.ConnectionSetup;
import clinic.MeuPreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class PatientDAO {
    
    private MeuPreparedStatement connection;
    
    public PatientDAO(){
        try {
            /*Criando conexão.
            
            con = new MeuPreparedStatement ("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://FS5:1433;databaseName=bdci17", "bdci17", "ert985");
            //WebClinic.con = DriverManager.getConnection("jdbc:sqlserver://FS5:1433;databaseName=bdci17", "bdci17", "ert985");
            
            String sql = "select * from [bdci17].[bdci17].[patient] where [login]='" + login + "' and [password]='" + senha + "'";
            con.prepareStatement(sql);
            MeuResultSet rs = (MeuResultSet) con.executeQuery();
            */
            
            this.connection = new MeuPreparedStatement ("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://"+ConnectionSetup.serverName+":"+ConnectionSetup.port+
                    ";databasename="+ConnectionSetup.database+";", ConnectionSetup.login, ConnectionSetup.password);
            if(!connection.execute())
                System.err.println("Erro na conexão!"); 
            
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }

    private ResultSet ExecuteCommand(String command) throws SQLException{
          return this.connection.executeQuery(command);
    }
    
    public boolean InsertPatient(Patient patient, PhoneNumber phoneNumber) throws SQLException{
        /*
            PATIENT
            String name, String cep, String rg, Date birthDate, String cpf, String number, 
            String complement, String login, String password
        
            PHONENUMBER
            int idPhoneType, int idPatient, int areaCode, String number
        */
        
        /// Verificar como o tipo Date será adicionado.
        String commandToInsertPatient = String.format("INSERT INTO patient(name, cpf, rg, birth_date, cep, number, complement, login, password) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
        patient.getName(), patient.getCpf(), patient.getRg(), patient.getBirthDate(), patient.getCep(),patient.getNumber(), patient.getComplement(), patient.getLogin(), patient.getPassword());
        
        String commandToInsertPhone = String.format("INSERT INTO phone_number(id_phone_type, id_patient, area_code, number) VALUES (%d, %d, %d, '%s');",
         phoneNumber.getIdPhoneType(), phoneNumber.getIdPatient(), phoneNumber.getAreaCode(), phoneNumber.getNumber());
        
        //Para teste
        System.out.println(commandToInsertPatient);
        System.out.println(commandToInsertPhone);
        
       // return ExecuteCommand(commandToInsertPatient).getRow() > 0 && ExecuteCommand(commandToInsertPhone).getRow() > 0;
        return false;
    }
    
    public boolean ExistLogin(String login, String password) throws SQLException{
        
        ///Criar coluna inactive
        String commandToExecute = String.format("SELECT * FROM patient WHERE NOT inactive AND login='%s' AND password='%s';", login, password); 
        
        //Testar
        System.out.println(commandToExecute);
        
        //return ExecuteCommand(commandToExecute).getRow() > 0;
        return false;

    }
   
    public boolean RemovePatient(int idPatient) throws SQLException{
        
        String commandToExecute = String.format("DELETE FROM Patient WHERE id=%d;", idPatient);
        
        //Testar
        System.out.println(commandToExecute);
        
        //Verificar o que o getRow() Retorna
       // return ExecuteCommand(commandToExecute).getRow() > 0;
        return false;
    }
    
    public boolean DisablePatient(int idPatient) throws SQLException{
        
        String commandToExecute = String.format("UPDATE patient SET inactive = 1 WHERE id = %d;", idPatient);
        
        //Teste
        System.out.println(commandToExecute);
        
        //Verificar se deu certo
        //return ExecuteCommand(commandToExecute).getRow() > 0;
        return false;
    }
    
    public boolean UpdatePatient(Patient patient) throws SQLException{
        
        /*
        int id, String name, String cep, String rg, Date birthDate, String cpf, String number, String complement, String login, String password
        */
        
        ///Verificar como insere Data
        String commandToExecute = String.format("UPDATE patient SET name='%s', cpf='%s', rg='%s', number='%s', complement='%s', cep='%s', birth_date='%s', login='%s', password='%s' WHERE id=%d;",
        patient.getName(), patient.getCpf(), patient.getRg(), patient.getNumber(), patient.getComplement(), patient.getCep(), patient.getBirthDate(), patient.getLogin(), patient.getPassword(), patient.getId());
        
        System.out.println(commandToExecute);
        
        //    return ExecuteCommand(commandToExecute).getRow() > 0;
        return false;
    
    }
    
    public List<Patient> SearchPatient(String searchType, String searchWord) throws SQLException{
        
        //LIKE '%%s%'; = pesquisa a palavra estando no começo, meio ou final 
        
        //String commandToExecute = String.format("SELECT * FROM patient WHERE %s LIKE '% %s %';", searchType, searchWord);
        String commandToExecute = "SELECT * FROM patient WHERE " + searchType + " LIKE '%"+searchWord+"%';";
        
        //ResultSet resultSet = ExecuteCommand(commandToExecute);
        ///Verificar como retornar todos
       //return resultSet.getArray("name").;
        
        System.out.println(commandToExecute);
        
        return null;
    }


}
