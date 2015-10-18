/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

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
     * @param login
     * login information from user input on html
     * @param senha
     * password information from user input on html
     * @return
     * boolean for correct combination (TRUE) or wrong combination (FALSE)
     */
    public static boolean loginValidate(String login, String senha) throws ClassNotFoundException {
        try {
            con = new MeuPreparedStatement ("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://FS5:1433;databaseName=bdci17", "bdci17", "ert985");
            //WebClinic.con = DriverManager.getConnection("jdbc:sqlserver://FS5:1433;databaseName=bdci17", "bdci17", "ert985");
            
            String sql = "select * from [bdci17].[bdci17].[patient] where [login]='" + login + "' and [password]='" + senha + "'";
            con.prepareStatement(sql);
            MeuResultSet rs = (MeuResultSet) con.executeQuery();
            if(!rs.next()) {
                return false;
            }  
        } catch (SQLException err) {
            System.err.println("Erro! " + err.getMessage());
        }
        return true;
    }

    /**
     * Registers a new patient to the system
     * @param login
     * @param senha
     * @param name
     * Patient's name
     * @param cpf
     * @param cep
     * Patient's postal code
     * @param number
     * Patient's house number
     * @param complement
     * Patient's complement, optional
     * @param phone_type
     * Patient's phone type
     * @param phone_number
     * Patient's phone number
     * @param area_code
     * Patient's phone area code
     * @return 
     * a boolean that confirms if registration was completed or not
     */
    public static boolean registerValidate(String login, String senha, String name, String cpf, String cep, String number, String complement, String phone_type, String phone_number, String area_code){
        
    }
    
    public static void main(String[] args) {

    }
}
