/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module.DAO;
import Module.Conexao.MeuPreparedStatement;
import java.sql.Array;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author William
 */
public class EmployeeRegistrerDAO {
    
    private MeuPreparedStatement connection;
    
    public EmployeeRegistrerDAO() throws ClassNotFoundException{
        try {
                /*
                Criando conexão.
                
                this.connection = DriverManager.getConnection("jdbc:sqlserver://"+ConnectionSetup.serverName+":"+ConnectionSetup.port+
                        ";databasename="+ConnectionSetup.database+";", ConnectionSetup.login, ConnectionSetup.password);
                if(!connection.isValid(0))
                    System.err.println("Erro na conexão!");*/
            
             
            this.connection = new MeuPreparedStatement ("com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://"+ConnectionSetup.serverName+":"+ConnectionSetup.port+
                    ";databasename="+ConnectionSetup.database+";", ConnectionSetup.login, ConnectionSetup.password);
            if(!connection.getConnection().isValid(0))
                System.err.println("Erro na conexão!"); 
            } 
            catch (SQLException ex) {
                Logger.getLogger(EmployeeRegistrerDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
    }
    private int InsertEmployeeRegistrer(EmployeeRegistrer employeeRegistrer) throws SQLException{
        
        /*
        EMPLOYEE
        String name, String password, String login
        
        HEALTHPROFESSIONALS
        int idEmployeeRegistrer, String cpf, String idClass
        
        SPECIALIZATION
        int id,String nome,int idProfessions
        
        */
        
        String commandToInsertEmployee = String.format("INSERT INTO employee_registrer (name, password, login) VALUES ('%s', '%s', '%s');", 
        employeeRegistrer.getName(),employeeRegistrer.getPassword(),employeeRegistrer.getLogin());
            
        this.connection.prepareStatement(commandToInsertEmployee);
        return this.connection.executeQuery(commandToInsertEmployee).getInt("id");
    }
    public boolean InsertEmployee(EmployeeRegistrer employeeRegistrer, Employee employee) throws SQLException{
        
        //int idEmployeeRegistrer, int idRole
        
        int employeeID = InsertEmployeeRegistrer(employeeRegistrer);
                
        String commandToInsertEmployee = String.format("INSERT INTO employee (id_employee_registrer, role_id) VALUES (%d, %d);", 
        employeeID, employee.getIdRole());
              
        this.connection.prepareStatement(commandToInsertEmployee);        
        return employeeID > 0 && this.connection.execute(commandToInsertEmployee);
    }
    
    public boolean InsertHealthProfessionals(EmployeeRegistrer employeeRegistrer, HealthProfessionals healthProfessionals, Specialization specialization) throws SQLException{
         
        int employeeID = InsertEmployeeRegistrer(employeeRegistrer);
        
        String commandToInsertHealthProfessional = String.format("INSERT INTO health_professionals (id_employee_registrer, cpf, id_class) VALUES (%d, '%s', '%s');", 
        employeeID, healthProfessionals.getCPF(),healthProfessionals.getIDClass());
        
        this.connection.prepareStatement(commandToInsertHealthProfessional);
        int healthProfessionalID =  this.connection.executeQuery(commandToInsertHealthProfessional).getInt("id");
        
        //String commandToInsertSpecialization = String.format("INSERT INTO specialization (id, name, id_professions) VALUES (%d, '%s', %d);",
        //specialization.getId(), specialization.getNome(), healthProfessionalID);
        
        return employeeID > 0 &&  healthProfessionalID > 0; //&& ExecuteCommand(commandToInsertSpecialization).getRow() > 0;
          
    }
     
    public boolean ExistLogin(String login, String password) throws SQLException{
         
        ///Criar coluna inactive
        /*
            SELECT id 
            FROM employee_registrer 
            JOIN health_professionals ON employee_registrer.id = health_professionals.id_employee_registrer
            JOIN employee ON employee.id_employee_registrer = employee_registrer.id 
            WHERE inactive = 0 AND (login='login' OR id_class='login') AND password='password';
        */
        String commandToExecute = String.format("SELECT id FROM employee_registrer JOIN health_professionals ON employee_registrer.id = health_professionals.id_employee_registrer JOIN employee ON employee.id_employee_registrer = employee_registrer.id WHERE inactive = 0 AND (login='%s' OR id_class='%s') AND password='%s';", login, login, password);     
        this.connection.prepareStatement(commandToExecute);
        ConnectionSetup.id =  this.connection.executeQuery(commandToExecute).getInt("id");
        
        return ConnectionSetup.id > 0; 
    }
    
    public boolean RemoveEmployeeRegistrer(){
        return false;
    }
    public boolean DisableEmployeeRegistrer(int idEmployeeRegistrer) throws SQLException{
        
        String commandToExecute = String.format("UPDATE employee_registrer SET inactive = 1 WHERE id = %d;", idEmployeeRegistrer);
        this.connection.prepareStatement(commandToExecute);
        return this.connection.execute(commandToExecute);
    }
    
    private boolean UpdateEmployeeRegistrer(EmployeeRegistrer employeeRegistrer) throws SQLException{
                
        String commandToUpdateEmployee = String.format("UPDATE employee_registrer SET name='%s', password='%s', login='%s' WHERE id=%d;",
        employeeRegistrer.getName(), employeeRegistrer.getPassword(), employeeRegistrer.getLogin(), employeeRegistrer.getId());
        
        this.connection.prepareStatement(commandToUpdateEmployee);
        return this.connection.execute(commandToUpdateEmployee);    
    }
    
    public boolean UpdateHealthProfessionals(EmployeeRegistrer employeeRegistrer, HealthProfessionals healthProfessionals, Specialization specialization) throws SQLException{
        
        boolean wasUpdated = true;
        
        wasUpdated = wasUpdated && UpdateEmployeeRegistrer(employeeRegistrer);
        
        String commandToUpdateHealthProfessionals = String.format("UPDATE health_professionals SET cpf='%s', id_class='%s' WHERE id=%d;",
        healthProfessionals.getCPF(), healthProfessionals.getClass(), ConnectionSetup.id);
        
        this.connection.prepareStatement(commandToUpdateHealthProfessionals);
        wasUpdated = wasUpdated &&  this.connection.execute(commandToUpdateHealthProfessionals);   
        
        return wasUpdated;
        
        //String commandToUpdateSpecialization = String.format("UPDATE specialization SET id=%d, name='%s' WHERE id=%d;",
        //specialization.getId(), specialization.getNome(), specialization.getIdProfessions());
                
        //wasUpdated = wasUpdated && ExecuteCommand(commandToUpdateSpecialization).getRow() > 0;   
    }
    
    public boolean UpdateEmployee(EmployeeRegistrer employeeRegistrer, Employee employee) throws SQLException{
        
        boolean wasUpdated = true;
        
        wasUpdated = wasUpdated && UpdateEmployeeRegistrer(employeeRegistrer);
        
        String commandToUpdateEmployee = String.format("UPDATE employee SET role_id=%d WHERE id_employee_registrer=%d;",
        employee.getIdRole(), employee.getIdEmployeeRegistrer());
        
        this.connection.prepareStatement(commandToUpdateEmployee);
        wasUpdated = wasUpdated &&  this.connection.execute(commandToUpdateEmployee);   
        
        return wasUpdated;
    }
    
    /**
     * Searches database for employees named or partly named specific term, searchWord
     * @param searchWord
     * @return
     * @throws SQLException
     */
    public Array SearchEmployee(String searchWord) throws SQLException{
        
        //LIKE '%%s%'; = pesquisa a palavra estando no começo, meio ou final 
        String commandToExecute = "SELECT * FROM employee_registrer WHERE name LIKE '%"+searchWord+"%';";
        this.connection.prepareStatement(commandToExecute);
        Array array = this.connection.executeQuery(commandToExecute).getArray("name");
        
        return array;
    }
    
}