/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clinic.MeuPreparedStatement;
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

    private MeuPreparedStatement connection;
    public static Patient currentPatient;

    public PatientDAO() throws ClassNotFoundException {
        try {
            /*Criando conexão.*/

            this.connection = new MeuPreparedStatement ("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://" + ConnectionSetup.serverName + ":" + ConnectionSetup.port
                    + ";databasename=" + ConnectionSetup.database + ";", ConnectionSetup.login, ConnectionSetup.password);
       
            if (!connection.getConnection().isValid(0)) {
                System.err.println(("Conexão inválida"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean InsertPatient(Patient patient, PhoneNumber phoneNumber) throws SQLException {
        /*
         PATIENT
         String name, String cep, String cpf, String number, 
         String complement, String login, String password
        
         PHONENUMBER
         int idPhoneType, int idPatient, int areaCode, String number
         */

        ///TODO: Verificar se todos os campos existem no form
        String commandToInsertPatient = String.format("INSERT INTO [bdci17].[bdci17].[patient] (name, cpf, cep, number, complement, login, password) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                patient.getName(), patient.getCpf(), patient.getCep(), patient.getNumber(), patient.getComplement(), patient.getLogin(), patient.getPassword());

        String commandToInsertPhone = String.format("INSERT INTO [bdci17].[bdci17].[phone_number](id_phone_type, id_patient, area_code, number) VALUES (%d, %d, %d, '%s');",
                phoneNumber.getIdPhoneType(), phoneNumber.getIdPatient(), phoneNumber.getAreaCode(), phoneNumber.getNumber());

        Statement st = this.connection.getConnection().createStatement();
        this.connection.prepareStatement(commandToInsertPatient);
        this.connection.prepareStatement(commandToInsertPhone);
        try{
            this.connection.executeUpdate();
            this.connection.commit(); //envia de fato o update para o banco
            return true;
        }
        catch (SQLException e) {
            this.connection.rollback(); //descommita caso tenha dado erro no meio do caminho!
            System.err.println ("Erro na execucao de comando!");
            return false;
        }
    }

    public boolean ExistLogin(String login, String password) throws SQLException {

        String commandToExecute = String.format("SELECT * FROM  [bdci17].[bdci17].[patient] WHERE [inactive]=0 AND [login]='%s' AND [password]='%s';", login, password);

        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        if (resultSet.next()) {
            ConnectionSetup.id = resultSet.getInt("id");
        }

        return ConnectionSetup.id > 0;
    }

    public boolean RemovePatient(int idPatient) throws SQLException {

        return false;
    }

    public boolean DisablePatient(int idPatient) throws SQLException {
        System.out.println(idPatient);
        String commandToExecute = String.format("UPDATE [bdci17].[bdci17].[patient] SET [inactive] = 1 WHERE [id] = %d;", idPatient);
        this.connection.prepareStatement(commandToExecute);
        try{
            this.connection.executeUpdate();
            this.connection.commit(); //envia de fato o update para o banco
            return true;
        }
        catch (SQLException e) {
            this.connection.rollback(); //descommita caso tenha dado erro no meio do caminho!
            System.err.println ("Erro na execucao de comando!");
            return false;
        }
    }

    public boolean UpdatePatient(Patient patient) throws SQLException {
        /*
         int id, String name, String cep, String cpf, String number, String complement, String login, String password
         */
        String commandToExecute = String.format("UPDATE [bdci17].[bdci17].[patient] SET [name]='%s', [cpf]='%s', [number]='%s', [complement]='%s', [cep]='%s', [login]='%s', [password]='%s' WHERE [id]=%d;",
                patient.getName(), patient.getCpf(), patient.getNumber(), patient.getComplement(), patient.getCep(), patient.getLogin(), patient.getPassword(), patient.getId());

        this.connection.prepareStatement(commandToExecute);
        try{
            this.connection.executeUpdate();
            this.connection.commit(); //envia de fato o update para o banco
            return true;
        }
        catch (SQLException e) {
            this.connection.rollback(); //descommita caso tenha dado erro no meio do caminho!
            System.err.println ("Erro na execucao de comando!");
            return false;
        }
    }

    public List<Patient> SearchPatient(String searchType, String searchWord) throws SQLException, Exception {

        List<Patient> patients = new ArrayList();

        //LIKE '%%s%'; = pesquisa a palavra estando no começo, meio ou final 
        String commandToExecute = "SELECT * FROM [bdci17].[bdci17].[patient] WHERE [" + searchType + "] LIKE '%" + searchWord + "%';";

        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //TODO: Verificar o tipo Data.
            //String name, String cep, String rg, Date birthDate, String cpf, String number, String complement, String login, String password
            Patient patient = new Patient(
                    resultSet.getString("name"),
                    resultSet.getString("cep"),
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

    public void FecharConexao() {
        try {
            this.connection.close();
            System.out.println("Conexão fechada.");
        } catch (SQLException e) {
            // se ocorrerem erros na conexão
            System.out.println("Problemas ao fechar a conexão: " + e);
        }
    }
}
