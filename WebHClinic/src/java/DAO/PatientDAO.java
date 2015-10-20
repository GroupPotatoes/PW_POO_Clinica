/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import clinic.MeuPreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class PatientDAO {
    
    private Connection connection;
    
    public PatientDAO(){
        try {
            /*Criando conexão.*/
                
                this.connection = DriverManager.getConnection("jdbc:sqlserver://"+ConnectionSetup.serverName+":"+ConnectionSetup.port+
                        ";databasename="+ConnectionSetup.database+";", ConnectionSetup.login, ConnectionSetup.password);

                if(!connection.isValid(0))
                    System.err.println(("Conexão inválida"));
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }
    
    public boolean InsertPatient(Patient patient, PhoneNumber phoneNumber) throws SQLException{
        /*
            PATIENT
            String name, String cep, String rg, Date birthDate, String cpf, String number, 
            String complement, String login, String password
        
            PHONENUMBER
            int idPhoneType, int idPatient, int areaCode, String number
        */
        
        /// TODO: Verificar como o tipo Date será adicionado.
        String commandToInsertPatient = String.format("INSERT INTO patient(name, cpf, rg, birth_date, cep, number, complement, login, password) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
        patient.getName(), patient.getCpf(), patient.getRg(), patient.getBirthDate(), patient.getCep(),patient.getNumber(), patient.getComplement(), patient.getLogin(), patient.getPassword());
        
        String commandToInsertPhone = String.format("INSERT INTO phone_number(id_phone_type, id_patient, area_code, number) VALUES (%d, %d, %d, '%s');",
         phoneNumber.getIdPhoneType(), phoneNumber.getIdPatient(), phoneNumber.getAreaCode(), phoneNumber.getNumber());
        
        
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
    
    public List<Patient> SearchPatient(String searchType, String searchWord) throws SQLException, Exception{
        
        List<Patient> patients = new ArrayList();
        
        //LIKE '%%s%'; = pesquisa a palavra estando no começo, meio ou final 
        String commandToExecute = "SELECT * FROM [bdci17].[bdci17].[patient] WHERE [" + searchType + "] LIKE '%"+searchWord+"%';";
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while(resultSet.next())
        {
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


}
