/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import Module.DAO.PatientDAO;
import java.sql.SQLException;
import Module.Controle;
import Module.DAO.Employee;
import Module.DAO.Patient;
import Module.DAO.PhoneNumber;
import Module.DAO.PhoneType;
import Module.DAO.Role;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author amanda
 */
public class WebClinic {

    //database connection
    private static MeuPreparedStatement con;

    /**
     * Validates login and password from database
     *
     * @param login login information from user input on html
     * @param senha password information from user input on html
     * @return boolean for correct combination (TRUE) or wrong combination
     * (FALSE)
     */
    public static boolean loginValidate(String login, String senha) throws ClassNotFoundException {
        // TODO: Change location of this method to the Servlet? 
        // TODO: USE DAO instead of this! 
        try {
            con = new MeuPreparedStatement("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://FS5:1433;databaseName=bdci17", "bdci17", "ert985");
            //WebClinic.con = DriverManager.getConnection("jdbc:sqlserver://FS5:1433;databaseName=bdci17", "bdci17", "ert985");

            String sql = "select * from [bdci17].[bdci17].[patient] where [login]='" + login + "' and [password]='" + senha + "'";
            con.prepareStatement(sql);
            MeuResultSet rs = (MeuResultSet) con.executeQuery();
            if (!rs.next()) {
                return false;
            }
        } catch (SQLException err) {
            System.err.println("Erro! " + err.getMessage());
        }
        return true;
    }

    /**
     * Registers a new patient to the system
     *
     * @param login
     * @param senha
     * @param name Patient's name
     * @param cpf
     * @param cep Patient's postal code
     * @param number Patient's house number
     * @param complement Patient's complement, optional
     * @param phone_type Patient's phone type
     * @param phone_number Patient's phone number
     * @param area_code Patient's phone area code
     * @return a boolean that confirms if registration was completed or not
     */
    public static boolean registerValidate(String login, String senha, String name,
            String cpf, String rg, String cep, String number,  String comp, String phone_type,
            String phone_number, String area_code, String date) throws ClassNotFoundException, SQLException, Exception {
        Module.DAO.PatientDAO consultor = new PatientDAO();
        if(!consultor.ExistLogin(login, senha)){
            //criar data a partir de String 
            SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            df.setLenient(false);
            Date dt = df.parse(date);
            
            //Criando um Paciente
            Module.DAO.Patient paciente = new Patient(name, cep, cpf, number, comp, login, senha);
            
            //Criando o telefone
            Module.DAO.PhoneType phonetype = new PhoneType(phone_type);
            phonetype.setName(phone_type);
            
            //TODO: QUE PORRA SER ISSO DE ID DE ONDE PEGO DEUS NÃO FAZ SENTIDO
            phonetype.setId(1);
            paciente.setId(1);
            
            Module.DAO.PhoneNumber phoneNumber = new PhoneNumber(phonetype.getId(), paciente.getId(), 
                    Integer.parseInt(area_code), phone_number);
            
            //Inserindo no BD
            consultor.InsertPatient(paciente, phoneNumber);
            
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
