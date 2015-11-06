package Module.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegisteredEmployeeDAO {
    
    private Connection connection;
   
    public RegisteredEmployeeDAO(Connection connection){
        this.connection = connection;
    }
    
    /**
     * Método que insere na tabela registered_employee
     * @param registeredEmployee
     * @return id do registeredEmployee
     * @throws SQLException 
     */
    private int InsertregisteredEmployee(RegisteredEmployee registeredEmployee) throws SQLException{
                
        String commandToInsertEmployee = String.format("INSERT INTO [bdci17].[bdci17].[registered_employee] (name, password, login) VALUES ('%s', '%s', '%s');", 
        registeredEmployee.getName(),registeredEmployee.getPassword(),registeredEmployee.getLogin());
        
        ///TODO: Retornar ID
        Statement st = this.connection.createStatement();
        st.executeUpdate(commandToInsertEmployee);
        ResultSet resultSet = st.executeQuery("SELECT id FROM [bdci17].[bdci17].[registered_employee] WHERE [login]='"+registeredEmployee.getLogin()+"'");
        if(resultSet.next())
            return resultSet.getInt("id");
        
        return 0;
    }

    /**
     * Método que insere na tabela Employee e RegisteredEmployee
     * @param registeredEmployee
     * @param employee
     * @return true caso tenha inserido e false caso não tenha inserido.
     * @throws SQLException 
     */
    public boolean InsertEmployee(RegisteredEmployee registeredEmployee, Employee employee) throws SQLException{
        
        int employeeID = InsertregisteredEmployee(registeredEmployee);
         
        String commandToInsertEmployee = String.format("INSERT INTO [bdci17].[bdci17].[employee] (id_registered_employee, role_id) VALUES (%d, %d);", 
        employeeID, employee.getIdRole());
        
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToInsertEmployee) > 0;
    }
    
    
        //TODO: mudar esta funcao para o dao de HP
    /**
     * Método que insere na tabela HealthProfessionals
     * @param registeredEmployee
     * @param healthProfessionals
     * @return true se inseriu dados e false caso não tenha inserido.
     * @throws SQLException 
     */
    public boolean InsertHealthProfessionals(RegisteredEmployee registeredEmployee, HealthProfessionals healthProfessionals, int idSpecialization ) throws SQLException, Exception{
        
        int healthProfessionalsID = 0;
        boolean inserted = true;
        
        int employeeID = InsertregisteredEmployee(registeredEmployee);
        inserted = inserted && employeeID > 0;
        
        String commandToInsertHealthProfessional = String.format("INSERT INTO health_professionals (id_registered_employee, cpf, id_class) VALUES (%d, '%s', '%s');", 
        employeeID, healthProfessionals.getCPF(),healthProfessionals.getIDClass());
        
        this.connection.prepareStatement(commandToInsertHealthProfessional);
        Statement st = this.connection.createStatement();
        inserted = inserted && st.executeUpdate(commandToInsertHealthProfessional) > 0;
        
        ResultSet resultSet = st.executeQuery("SELECT id FROM [bdci17].[bdci17].[registered_employee] WHERE [login]='"+registeredEmployee.getLogin()+"';");
        if(resultSet.next())
            healthProfessionalsID = resultSet.getInt("id");
        
        HealthProfessionalsDAO hpDAO = new HealthProfessionalsDAO(ConnectionSetup.connection);
        inserted = inserted && hpDAO.InsertHealthProfessionalsHaveSpecialization(new HealthProfessionalsHaveSpecialization(healthProfessionalsID, idSpecialization));
        
        return inserted;
        //return employeeID > 0; &&  healthProfessionalID > 0; && ExecuteCommand(commandToInsertSpecialization).getRow() > 0;
    }
     
    /**
     * Verifica se esse login e senha existe no banco de dados
     * @param login
     * @param password
     * @return true se login e senha existir e false caso contrário.
     * @throws SQLException 
     */
    public boolean ExistLogin(String login, String password) throws SQLException{
         
        //String commandToExecute = String.format("SELECT [registered_employee].[id] FROM [bdci17].[bdci17].[registered_employee] JOIN [health_professionals] ON [registered_employee].[id] = [health_professionals].[id_registered_employee] JOIN [employee] ON [employee].[id_registered_employee] = [registered_employee].[id] WHERE [registered_employee].[inactive] = 0 AND ([registered_employee].[login]='%s' OR [health_professionals].[id_class]='%s') AND [registered_employee].[password]='%s';", login, login, password);     
        
        //String commandToExecute = String.format("SELECT [registered_employee].[id] FROM [bdci17].[bdci17].[registered_employee] WHERE [inactive]=0 AND [login]='%s' AND [password]='%s';", login, password);
       
        String commandToExecute = String.format("SELECT registered_employee.id FROM registered_employee\n" +
                                                    "JOIN employee ON employee.id_registered_employee = registered_employee.id\n" +
                                                        "WHERE inactive=0 AND login = '%s' AND password = '%s' AND employee.role_id = 1;", login, password);
        
        ///TODO: retornar ID para o ConnectSetup.id
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        if(resultSet.next())
            ConnectionSetup.id = resultSet.getInt("id");
        
        return ConnectionSetup.id > 0;
    }
    
    public boolean IsUniqueLogin(String login, String password) throws SQLException{
        
        String commandToExecute = String.format("SELECT [registered_employee].[id] FROM [bdci17].[bdci17].[registered_employee] WHERE [login]='%s' AND [password]='%s';", login, password);
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        return !resultSet.next();      
    }
    
    public boolean RemoveregisteredEmployee(){
        return false;
    }

    /**
     * Desabilita a conta do EmployeeRegister que é passado
     * @param idRegisteredEmployee
     * @return true se desabilitou e false caso contrário
     * @throws SQLException 
     */
    public boolean DisableregisteredEmployee(int idRegisteredEmployee) throws SQLException{
        
        String commandToExecute = String.format("UPDATE [bdci17].[bdci17].[registered_employee] SET [inactive] = 1 WHERE [id] = %d;", idRegisteredEmployee);

        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }
    
    /**
     * Atualiza dados da tabela RegisteredEmployee
     * @param registeredEmployee
     * @return true caso tenha alterado e false caso contrário
     * @throws SQLException 
     */
    private boolean UpdateregisteredEmployee(RegisteredEmployee registeredEmployee) throws SQLException{
                
        String commandToUpdateEmployee = String.format("UPDATE [bdci17].[bdci17].[registered_employee] SET [name]='%s', [password]='%s', [login]='%s' WHERE [id]=%d;",
        registeredEmployee.getName(), registeredEmployee.getPassword(), registeredEmployee.getLogin(), registeredEmployee.getId());

        
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToUpdateEmployee) > 0;
        
    }
    
    //TODO: mudar esta funcao para o dao de HP
    public boolean UpdateHealthProfessionals(RegisteredEmployee registeredEmployee, HealthProfessionals healthProfessional) throws SQLException{
        
        boolean wasUpdated = true;
        
        wasUpdated = wasUpdated && UpdateregisteredEmployee(registeredEmployee);
        
        String commandToUpdateHealthProfessionals = String.format("UPDATE health_professionals SET cpf='%s', id_class='%s' WHERE id_registered_employee=%d;",
        healthProfessional.getCPF(), healthProfessional.getIDClass(), ConnectionSetup.currentEmployeeSelect.getId());
        Statement st = this.connection.createStatement();
        //this.connection.prepareStatement(commandToUpdateHealthProfessionals);
        wasUpdated = wasUpdated && (st.executeUpdate(commandToUpdateHealthProfessionals) > 0);   
        
        return wasUpdated;
    }
    
    /**
     * Atualiza dados da tabela Employee e RegisteredEmployee
     * @param registeredEmployee
     * @param employee
     * @return true caso tenha atualizado e false caso contrário
     * @throws SQLException 
     */
    public boolean UpdateEmployee(RegisteredEmployee registeredEmployee, Employee employee) throws SQLException{
        
        String commandToUpdateEmployee = String.format("UPDATE [bdci17].[bdci17].[employee] SET [role_id]=%d WHERE [id_registered_employee]=%d;",
        employee.getIdRole(), registeredEmployee.getId());
        
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToUpdateEmployee) > 0 && UpdateregisteredEmployee(registeredEmployee);
    }
    
    /**
     * Método que pesquisa nomes no bd
     * @param searchWord Nome a ser pesquisado
     * @return Retorna uma lista de dados pesquisados
     * @throws SQLException 
     */
    public List<RegisteredEmployee> SearchregisteredEmployee(String searchWord) throws SQLException, Exception{
        
        List<RegisteredEmployee> registeredEmployeeList = new ArrayList<RegisteredEmployee>();
        //LIKE '%%s%'; = pesquisa a palavra estando no começo, meio ou final 
        String commandToExecute = "SELECT * FROM [bdci17].[bdci17].[registered_employee] WHERE [inactive] = 0 AND [name] LIKE '%"+searchWord+"%';";
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while(resultSet.next())
        {
            //name, password, login
           RegisteredEmployee employee = new RegisteredEmployee(resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("login"));
           registeredEmployeeList.add(employee);
        }
        
        return registeredEmployeeList;
    }  
    
    public List<RegisteredEmployee> SelectAllEmployee() throws SQLException, Exception   {
        
        List<RegisteredEmployee> registeredEmployeeList = new ArrayList<RegisteredEmployee>();
       
        String commandToExecute = String.format("SELECT * " +
                                                " FROM [bdci17].[bdci17].[registered_employee] " +
                                                " JOIN [employee] ON [employee].[id_registered_employee] = [registered_employee].[id] " +
                                                " WHERE [registered_employee].[inactive] = 0 AND [registered_employee].[id] != %d;", ConnectionSetup.id);
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while(resultSet.next())
        {
            //int id, String name, String password, String login
           RegisteredEmployee employee = new RegisteredEmployee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("login"));
           registeredEmployeeList.add(employee);
        }
                  
        return registeredEmployeeList;
    }
    
    public List<RegisteredEmployee> SelectAllHealthProfessionals() throws SQLException, Exception   {
        
        List<RegisteredEmployee> registeredEmployeeList = new ArrayList<RegisteredEmployee>();
       
        String commandToExecute = String.format("SELECT * " +
                                                "FROM [bdci17].[bdci17].[registered_employee] " +
                                                "JOIN [health_professionals] ON [health_professionals].[id_registered_employee] = [registered_employee].[id] " +
                                                "WHERE [registered_employee].[inactive] = 0 AND [registered_employee].[id] != %d;", ConnectionSetup.id);
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while(resultSet.next())
        {
            //int id, String name, String password, String login
           RegisteredEmployee employee = new RegisteredEmployee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("login"));
           registeredEmployeeList.add(employee);
        }
                  
        return registeredEmployeeList;
    }
    
    public List<Role> SelectAllRole() throws SQLException, Exception  {
        
        List<Role> roles = new ArrayList<Role>();
       
        String commandToExecute = String.format("SELECT * FROM [bdci17].[bdci17].[role];");
        
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while(resultSet.next())
        {
            //id, name
           Role role = new Role(resultSet.getInt("id"), resultSet.getString("name"));
           roles.add(role);
        }
                  
        return roles;
    }
    
}
