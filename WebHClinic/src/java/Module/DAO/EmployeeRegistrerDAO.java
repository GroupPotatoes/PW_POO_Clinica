/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Module.DAO;

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
public class EmployeeRegistrerDAO {
    
    private Connection connection;
    
    public EmployeeRegistrerDAO() throws ClassNotFoundException{
        try {
                /*Criando conexão.*/
                
                this.connection = DriverManager.getConnection("jdbc:sqlserver://"+ConnectionSetup.serverName+":"+ConnectionSetup.port+
                        ";databasename="+ConnectionSetup.database+";", ConnectionSetup.login, ConnectionSetup.password);

                if(!connection.isValid(0))
                    System.err.println(("Conexão inválida"));
            } 
            catch (SQLException ex) {
                Logger.getLogger(EmployeeRegistrerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }   
    }

    /**
     * Método que insere na tabela Employee_Registrer
     * @param employeeRegistrer
     * @return id do employeeRegistrer
     * @throws SQLException 
     */
    private int InsertEmployeeRegistrer(EmployeeRegistrer employeeRegistrer) throws SQLException{
                
        String commandToInsertEmployee = String.format("INSERT INTO [bdci17].[bdci17].[employee_registrer] (name, password, login) VALUES ('%s', '%s', '%s');", 
        employeeRegistrer.getName(),employeeRegistrer.getPassword(),employeeRegistrer.getLogin());
        
        ///TODO: Retornar ID
        Statement st = this.connection.createStatement();
        st.executeUpdate(commandToInsertEmployee);
        ResultSet resultSet = st.executeQuery("SELECT id FROM [bdci17].[bdci17].[employee_registrer] WHERE [login]='"+employeeRegistrer.getLogin()+"'");
        if(resultSet.next())
            return resultSet.getInt("id");
        
        return 0;
    }

    /**
     * Método que insere na tabela Employee e EmployeeRegistrer
     * @param employeeRegistrer
     * @param employee
     * @return true caso tenha inserido e false caso não tenha inserido.
     * @throws SQLException 
     */
    public boolean InsertEmployee(EmployeeRegistrer employeeRegistrer, Employee employee) throws SQLException{
        
        int employeeID = InsertEmployeeRegistrer(employeeRegistrer);
         
        String commandToInsertEmployee = String.format("INSERT INTO [bdci17].[bdci17].[employee] (id_employee_registrer, role_id) VALUES (%d, %d);", 
        employeeID, employee.getIdRole());
        
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToInsertEmployee) > 0; // TODO igual no PatientDAO
    }
    
    /**
     * Método que insere na tabela HealthProfessionals
     * @param employeeRegistrer
     * @param healthProfessionals
     * @return true se inseriu dados e false caso não tenha inserido.
     * @throws SQLException 
     */
    public boolean InsertHealthProfessionals(EmployeeRegistrer employeeRegistrer, HealthProfessionals healthProfessionals) throws SQLException{
         /*
        int employeeID = InsertEmployeeRegistrer(employeeRegistrer);
        
        String commandToInsertHealthProfessional = String.format("INSERT INTO health_professionals (id_employee_registrer, cpf, id_class) VALUES (%d, '%s', '%s');", 
        employeeID, healthProfessionals.getCPF(),healthProfessionals.getIDClass());
        
        this.connection.prepareStatement(commandToInsertHealthProfessional);
        int healthProfessionalID =  this.connection.executeQuery(commandToInsertHealthProfessional).getInt("id");
        
        //String commandToInsertSpecialization = String.format("INSERT INTO specialization (id, name, id_professions) VALUES (%d, '%s', %d);",
        //specialization.getId(), specialization.getNome(), healthProfessionalID);
        
        return employeeID > 0; &&  healthProfessionalID > 0; && ExecuteCommand(commandToInsertSpecialization).getRow() > 0;
          */
        return false;
    }
     
    /**
     * Verifica se esse login e senha existe no banco de dados
     * @param login
     * @param password
     * @return true se login e senha existir e false caso contrário.
     * @throws SQLException 
     */
    public boolean existLogin(String login, String password) throws SQLException{
         
        //String commandToExecute = String.format("SELECT [employee_registrer].[id] FROM [bdci17].[bdci17].[employee_registrer] JOIN [health_professionals] ON [employee_registrer].[id] = [health_professionals].[id_employee_registrer] JOIN [employee] ON [employee].[id_employee_registrer] = [employee_registrer].[id] WHERE [employee_registrer].[inactive] = 0 AND ([employee_registrer].[login]='%s' OR [health_professionals].[id_class]='%s') AND [employee_registrer].[password]='%s';", login, login, password);     
        
        String commandToExecute = String.format("SELECT [employee_registrer].[id] FROM [bdci17].[bdci17].[employee_registrer] WHERE [inactive]=0 AND [login]='%s';", login);
        ///TODO: retornar ID para o ConnectSetup.id
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        if(resultSet.next())
            ConnectionSetup.id = resultSet.getInt("id");
        
        return ConnectionSetup.id > 0;
    }
    
    public boolean IsUniqueLogin(String login, String password) throws SQLException{
        
        String commandToExecute = String.format("SELECT [employee_registrer].[id] FROM [bdci17].[bdci17].[employee_registrer] WHERE [login]='%s' AND [password]='%s';", login, password);
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        return !resultSet.next();      
    }
    
    public boolean RemoveEmployeeRegistrer(){
        return false;
    }

    /**
     * Desabilita a conta do EmployeeRegister que é passado
     * @param idEmployeeRegistrer
     * @return true se desabilitou e false caso contrário
     * @throws SQLException 
     */
    public boolean DisableEmployeeRegistrer(int idEmployeeRegistrer) throws SQLException{
        
        String commandToExecute = String.format("UPDATE [bdci17].[bdci17].[employee_registrer] SET [inactive] = 1 WHERE [id] = %d;", idEmployeeRegistrer);

        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }
    
    /**
     * Atualiza dados da tabela EmployeeRegistrer
     * @param employeeRegistrer
     * @return true caso tenha alterado e false caso contrário
     * @throws SQLException 
     */
    private boolean UpdateEmployeeRegistrer(EmployeeRegistrer employeeRegistrer) throws SQLException{
                
        String commandToUpdateEmployee = String.format("UPDATE [bdci17].[bdci17].[employee_registrer] SET [name]='%s', [password]='%s', [login]='%s' WHERE [id]=%d;",
        employeeRegistrer.getName(), employeeRegistrer.getPassword(), employeeRegistrer.getLogin(), employeeRegistrer.getId());

        
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToUpdateEmployee) > 0;
        
    }
    
    public boolean UpdateHealthProfessionals(EmployeeRegistrer employeeRegistrer, HealthProfessionals healthProfessionals, Specialization specialization) throws SQLException{
        
       /* boolean wasUpdated = true;
        
        wasUpdated = wasUpdated && UpdateEmployeeRegistrer(employeeRegistrer);
        
        String commandToUpdateHealthProfessionals = String.format("UPDATE health_professionals SET cpf='%s', id_class='%s' WHERE id=%d;",
        healthProfessionals.getCPF(), healthProfessionals.getClass(), ConnectionSetup.id);
        
        this.connection.prepareStatement(commandToUpdateHealthProfessionals);
        //wasUpdated = wasUpdated &&  this.connection.execute(commandToUpdateHealthProfessionals);   
        
        return wasUpdated;
        
        //String commandToUpdateSpecialization = String.format("UPDATE specialization SET id=%d, name='%s' WHERE id=%d;",
        //specialization.getId(), specialization.getNome(), specialization.getIdProfessions());
                
        //wasUpdated = wasUpdated && ExecuteCommand(commandToUpdateSpecialization).getRow() > 0;  
               */
        return false;
    }
    
    /**
     * Atualiza dados da tabela Employee e EmployeeRegistrer
     * @param employeeRegistrer
     * @param employee
     * @return true caso tenha atualizado e false caso contrário
     * @throws SQLException 
     */
    public boolean UpdateEmployee(EmployeeRegistrer employeeRegistrer, Employee employee) throws SQLException{
        
        String commandToUpdateEmployee = String.format("UPDATE [bdci17].[bdci17].[employee] SET [role_id]=%d WHERE [id_employee_registrer]=%d;",
        employee.getIdRole(), employee.getIdEmployeeRegistrer());
        
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToUpdateEmployee) > 0 && UpdateEmployeeRegistrer(employeeRegistrer);
    }
    
    /**
     * Método que pesquisa nomes no bd
     * @param searchWord Nome a ser pesquisado
     * @return Retorna uma lista de dados pesquisados
     * @throws SQLException 
     */
    public List<EmployeeRegistrer> SearchEmployeeRegistrer(String searchWord) throws SQLException, Exception{
        
        List<EmployeeRegistrer> employeeRegistrerList = new ArrayList<EmployeeRegistrer>();
        //LIKE '%%s%'; = pesquisa a palavra estando no começo, meio ou final 
        String commandToExecute = "SELECT * FROM [bdci17].[bdci17].[employee_registrer] WHERE [name] LIKE '%"+searchWord+"%';";
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while(resultSet.next())
        {
            //name, password, login
           EmployeeRegistrer employee = new EmployeeRegistrer(resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("login"));
           employeeRegistrerList.add(employee);
        }
        
        return employeeRegistrerList;
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
