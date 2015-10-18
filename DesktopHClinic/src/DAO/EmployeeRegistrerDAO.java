/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Module.ConnectionSetup;
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
public class EmployeeRegistrerDAO {
    
    private Connection connection;
    
    public EmployeeRegistrerDAO(){
        try {
                /*
                Criando conexão.
                */
                this.connection = DriverManager.getConnection("jdbc:sqlserver://"+ConnectionSetup.serverName+":"+ConnectionSetup.port+
                        ";databasename="+ConnectionSetup.database+";", ConnectionSetup.login, ConnectionSetup.password);

                if(!connection.isValid(0))
                    System.err.println("Erro na conexão!");

            } 
            catch (SQLException ex) {
                Logger.getLogger(EmployeeRegistrerDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
    }

    private ResultSet ExecuteCommand(String command) throws SQLException{
        
           Statement statement = this.connection.createStatement();
           return statement.executeQuery(command);  
           
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
        
        System.out.println(commandToInsertEmployee);
        
        return ExecuteCommand(commandToInsertEmployee).getRow();
    }

    public boolean InsertEmployee(EmployeeRegistrer employeeRegistrer, Employee employee) throws SQLException{
        
        //int idEmployeeRegistrer, int idRole
        
        int employeeID = InsertEmployeeRegistrer(employeeRegistrer);
                
        String commandToInsertEmployee = String.format("INSERT INTO employee (id_employee_registrer, role_id) VALUES (%d, %d);", 
        employeeID, employee.getIdRole());
        
        System.out.println(commandToInsertEmployee);
        
        return employeeID > 0 && ExecuteCommand(commandToInsertEmployee).getRow() > 0;
        
    }
    
    public boolean InsertHealthProfessionals(EmployeeRegistrer employeeRegistrer, HealthProfessionals healthProfessionals, Specialization specialization) throws SQLException{
         
        int employeeID = InsertEmployeeRegistrer(employeeRegistrer);
        
        String commandToInsertHealthProfessional = String.format("INSERT INTO health_professionals (id_employee_registrer, cpf, id_class) VALUES (%d, '%s', '%s');", 
        employeeID, healthProfessionals.getCPF(),healthProfessionals.getIDClass());
         
        System.out.println(commandToInsertHealthProfessional);
        
        int healthProfessionalID = ExecuteCommand(commandToInsertHealthProfessional).getRow();
        
        String commandToInsertSpecialization = String.format("INSERT INTO specialization (id, name, id_professions) VALUES (%d, '%s', %d);",
        specialization.getId(), specialization.getNome(), healthProfessionalID);
        
        System.out.println(commandToInsertSpecialization);
        
        return employeeID > 0 &&  healthProfessionalID > 0 && ExecuteCommand(commandToInsertSpecialization).getRow() > 0;
          
    }
    
    public boolean ExistLoginToEmployee(String login, String password) throws SQLException{
        
        ///Criar coluna inactive
        String commandToExecute = String.format("SELECT * FROM employee_registrer WHERE NOT inactive AND login='%s' AND password='%s';", login, password); 
        
        //Testar
        System.out.println(commandToExecute);
        
        return ExecuteCommand(commandToExecute).getRow() > 0;
   
    }
    
    public boolean ExistLoginToHealthProfessional(String login, String password) throws SQLException{
         
        ///Criar coluna inactive
        String commandToExecute = String.format("SELECT id FROM employee_registrer JOIN health_professionals ON id = health_professionals.id_employee_registrer WHERE NOT inactive AND (login='%s' OR id_class='%s') AND password='%s';", login, login, password);     
        
       //Testar
        System.out.println(commandToExecute);
        
        return ExecuteCommand(commandToExecute).getRow() > 0;
    }
    
    public boolean RemoveEmployeeRegistrer(){
        return false;
    }

    public boolean DisableEmployeeRegistrer(int idEmployeeRegistrer) throws SQLException{
        
        String commandToExecute = String.format("UPDATE employee_registrer SET inactive = 1 WHERE id = %d;", idEmployeeRegistrer);
        
        //Teste
        System.out.println(commandToExecute);
        
        //Verificar se deu certo
        return ExecuteCommand(commandToExecute).getRow() > 0;
    
    }
    
    private boolean UpdateEmployeeRegistrer(EmployeeRegistrer employeeRegistrer) throws SQLException{
                
        String commandToUpdateEmployee = String.format("UPDATE employee_registrer SET name='%s', password='%s', login='%s' WHERE id=%d;",
        employeeRegistrer.getName(), employeeRegistrer.getPassword(), employeeRegistrer.getLogin(), employeeRegistrer.getId());
        
        System.out.println(commandToUpdateEmployee);
        
        return ExecuteCommand(commandToUpdateEmployee).getRow() > 0;
              
    }
    
    public boolean UpdateHealthProfessionals(EmployeeRegistrer employeeRegistrer, HealthProfessionals healthProfessionals, Specialization specialization) throws SQLException{
        
        boolean wasUpdated = true;
        
        wasUpdated = wasUpdated && UpdateEmployeeRegistrer(employeeRegistrer);
        
        String commandToUpdateHealthProfessionals = String.format("UPDATE health_professionals SET cpf='%s', id_class='%s' WHERE id=%d;",
        healthProfessionals.getCPF(), healthProfessionals.getClass());
        
        System.out.println(commandToUpdateHealthProfessionals);
        
        wasUpdated = wasUpdated && ExecuteCommand(commandToUpdateHealthProfessionals).getRow() > 0;
        
        String commandToUpdateSpecialization = String.format("UPDATE specialization SET id=%d, name='%s' WHERE id=%d;",
        specialization.getId(), specialization.getNome(), specialization.getIdProfessions());
        
        System.out.println(commandToUpdateSpecialization);
        
        wasUpdated = wasUpdated && ExecuteCommand(commandToUpdateSpecialization).getRow() > 0;
        
        return wasUpdated;  
        
    }
    
    public boolean UpdateEmployee(EmployeeRegistrer employeeRegistrer, Employee employee) throws SQLException{
        
        boolean wasUpdated = UpdateEmployeeRegistrer(employeeRegistrer);
        
        String commandToUpdateEmployee = String.format("UPDATE employee SET role_id=%d WHERE id_employee_registrer=%d;",
        employee.getIdRole(), employee.getIdEmployeeRegistrer());
        
        System.out.println(commandToUpdateEmployee);
        
        return wasUpdated && ExecuteCommand(commandToUpdateEmployee).getRow() > 0;
       
    }
    
    public List<EmployeeRegistrer> SearchPatient(String searchWord) throws SQLException{
        
        //LIKE '%%s%'; = pesquisa a palavra estando no começo, meio ou final 
        String commandToExecute = String.format("SELECT * FROM employee_registrer WHERE name LIKE '%%s%';", searchWord);
        ResultSet resultSet = ExecuteCommand(commandToExecute);
        
        System.out.println(commandToExecute);
        
        ///Verificar como retornar todos
       //return resultSet.getArray("name").;
        return null;
    }


    
}
