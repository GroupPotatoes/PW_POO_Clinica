package clinic;

import java.sql.SQLException;
import Module.DAO.*;

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
     * @param comp Patient's complement, optional
     * @param phone_type Patient's phone type
     * @param phone_number Patient's phone number
     * @param area_code Patient's phone area code
     * @return a boolean that confirms if registration was completed or not
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static boolean registerValidate(String login, String senha, String name,
            String cpf, String cep, String number, String comp, String phone_type,
            String phone_number, String area_code) throws ClassNotFoundException, SQLException, Exception {
        PatientDAO consultor = new PatientDAO();
        try{
         
            //Criando um Paciente
            Patient paciente = new Patient(name, cep, cpf, number, comp, login, senha);
            
            //Criando o telefone
            PhoneType phonetype = new PhoneType(phone_type);
            phonetype.setId(Integer.parseInt(phone_type));
                                  
            PhoneNumber phoneNumber = new PhoneNumber(phonetype.getId(), 1, 
                    Integer.parseInt(area_code), phone_number);
            
            //Inserindo no BD
            consultor.InsertPatient(paciente, phoneNumber);
            
            return true;
        }catch(Exception e){
            e.getMessage();
        }
        return false;
    }
    
    public static void main(String[] args) {

    }
}
