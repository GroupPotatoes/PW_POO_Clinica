package Module.DAO;

import Module.DBO.ConnectionSetup;
import Module.DBO.HealthProfessionals;
import Module.DBO.HealthProfessionalsHaveSpecialization;
import Module.DBO.RegisteredEmployee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HealthProfessionalsDAO {

    private Connection connection;
    
 
    public HealthProfessionalsDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean InsertHealthProfessionals(RegisteredEmployee registeredEmployee, HealthProfessionals healthProfessionals, int idSpecialization) throws SQLException, Exception {

        int healthProfessionalsID = 0;
        boolean inserted = true;

        int employeeID = new RegisteredEmployeeDAO(this.connection).InsertregisteredEmployee(registeredEmployee);
        inserted = inserted && employeeID > 0;

        String commandToInsertHealthProfessional = String.format("INSERT INTO health_professionals (id_registered_employee, cpf, id_class) VALUES (%d, '%s', '%s');",
                employeeID, healthProfessionals.getCPF(), healthProfessionals.getIDClass());

        this.connection.prepareStatement(commandToInsertHealthProfessional);
        Statement st = this.connection.createStatement();
        inserted = inserted && st.executeUpdate(commandToInsertHealthProfessional) > 0;

        ResultSet resultSet = st.executeQuery("SELECT id FROM [bdci17].[bdci17].[registered_employee] WHERE [login]='" + registeredEmployee.getLogin() + "';");
        if (resultSet.next()) {
            healthProfessionalsID = resultSet.getInt("id");
            healthProfessionals.setidRegisteredEmployee(healthProfessionalsID);
        }

        inserted = inserted && this.InsertHealthProfessionalsHaveSpecialization(new HealthProfessionalsHaveSpecialization(healthProfessionalsID, idSpecialization));

        return inserted;
    }
    
    /**
     * Atualiza perfil do health professional
     * @param registeredEmployee
     * @param healthProfessional
     * @return
     * @throws SQLException 
     */
    public boolean UpdateHealthProfessionals(RegisteredEmployee registeredEmployee, HealthProfessionals healthProfessional) throws SQLException {

        boolean wasUpdated = true;

        wasUpdated = wasUpdated && new RegisteredEmployeeDAO(this.connection).updateRegisteredEmployee(registeredEmployee);

        String commandToUpdateHealthProfessionals = String.format("UPDATE health_professionals SET cpf='%s', id_class='%s' WHERE id_registered_employee=%d;",
                healthProfessional.getCPF(), healthProfessional.getIDClass(), ConnectionSetup.currentEmployeeSelect.getId());
        Statement st = this.connection.createStatement();
        //this.connection.prepareStatement(commandToUpdateHealthProfessionals);
        wasUpdated = wasUpdated && (st.executeUpdate(commandToUpdateHealthProfessionals) > 0);

        return wasUpdated;
    }
    
    public HealthProfessionals getInfoHealthProfessional(int idHealthProfessional) throws Exception {
        HealthProfessionals healthprof;
        String commandToExecute = String.format("SELECT [health_professionals].[cpf], [health_professionals].[id_class] FROM [bdci17].[bdci17].[health_professionals] WHERE [id_registered_employee]=%d;", idHealthProfessional);
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
         
        if (resultSet.next()) {
            healthprof = new HealthProfessionals(idHealthProfessional, resultSet.getString("cpf"), resultSet.getString("id_class"));
            return healthprof;
        }
        
        return null;
    }
    
    /**
     * Busca por HP
     * @param filtrer
     * @param searchWord
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public List<String> SearchHealthProfessionals(String filtrer, String searchWord) throws SQLException, Exception {
        //RegistroNomeTipo de profissionalEspecialidade
        List<String> healthProfessionals = new ArrayList<String>();
        String commandToExecute = "";
        commandToExecute = "SELECT [health_professionals].[id_class], "
                + "[registered_employee].[name] as registered_employee_name, "
                + "[specialization].[name] as specialization_name, "
                + "[professions].[name] as professions_name "
                + "FROM [health_professionals] "
                + "JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals].[id_registered_employee] "
                + "JOIN [health_professionals_have_specialization] ON [health_professionals_have_specialization].[id_health_professionals] = [health_professionals].[id_registered_employee] "
                + "JOIN [specialization] ON [specialization].[id] = [health_professionals_have_specialization].[id_specialization]"
                + "JOIN [professions] ON [professions].[id] = [specialization].[id_professions]"
                + " WHERE [inactive] = 0 AND ";
        switch (filtrer) {
            case "Registro":
                commandToExecute += " [health_professionals].[id_class]='" + searchWord + "';";
                break;

            case "Nome":
                commandToExecute += " [registered_employee].[name] LIKE '%" + searchWord + "%';";
                break;

            case "Tipo de profissional":
                commandToExecute += "[professions].[name]='" + searchWord + "';";
                break;

            case "Especialidade":
                commandToExecute += "[specialization].[name]='" + searchWord + "';";
                break;
            default:
                break;
        }

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            healthProfessionals.add(String.format("Nome[%s] Registro[%s] Profissional[%s] Especialização[%s]",
                    resultSet.getString("registered_employee_name"), resultSet.getString("id_class"), resultSet.getString("professions_name"), resultSet.getString("specialization_name")));
        }

        return healthProfessionals;
    }

    public List<RegisteredEmployee> SearchHealthProfessionalsByName(String nameToSearch) throws SQLException, Exception{
        
        List<RegisteredEmployee> healthProfessionals = new ArrayList<RegisteredEmployee>();
        String commandToExecute = "";
        
        commandToExecute = " SELECT registered_employee.id AS id_registered_employee, " +
                            " registered_employee.name AS name, " +
                            " registered_employee.password AS password, " +
                            " registered_employee.login AS login " +
                            " FROM health_professionals " +
                            " JOIN registered_employee ON registered_employee.id = health_professionals.id_registered_employee " +
                            " WHERE [inactive] = 0 AND registered_employee.name LIKE '%" + nameToSearch + "%';";

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            RegisteredEmployee registeredEmployee = new RegisteredEmployee(
                    resultSet.getInt("id_registered_employee"), 
                    resultSet.getString("name"), 
                    resultSet.getString("password"), 
                    resultSet.getString("login"));
            
            healthProfessionals.add(registeredEmployee);
        }

        return healthProfessionals;
    }
    
    public List<RegisteredEmployee> SelectAllHealthProfessionals() throws SQLException, Exception {

        List<RegisteredEmployee> registeredEmployeeList = new ArrayList<RegisteredEmployee>();

        String commandToExecute = String.format("SELECT * "
                + " FROM [bdci17].[bdci17].[health_professionals] "
                + " JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals].[id_registered_employee] "
                + " WHERE [registered_employee].[inactive] = 0 AND [registered_employee].[id] != %d;", ConnectionSetup.id);

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //int id, String name, String password, String login
            RegisteredEmployee employee = new RegisteredEmployee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("login"));
            registeredEmployeeList.add(employee);
        }

        return registeredEmployeeList;
    }
    
    public List<String> SelectAllNameHealthProfessionals() throws SQLException, Exception {

        List<String> registeredEmployeeList = new ArrayList<String>();

        String commandToExecute = String.format("SELECT * "
                + " FROM [bdci17].[bdci17].[health_professionals] "
                + " JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals].[id_registered_employee] "
                + " WHERE [registered_employee].[inactive] = 0 AND [registered_employee].[id] != %d;", ConnectionSetup.id);

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //int id, String name, String password, String login
            //RegisteredEmployee employee = new RegisteredEmployee(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("login"));
            registeredEmployeeList.add(resultSet.getString("name"));
        }

        return registeredEmployeeList;
    }
    
    /**
     * Retorna lista de profissionais de saude sem login
     * @return
     * @throws SQLException
     * @throws Exception 
     */
    public List<RegisteredEmployee> listAllHealthProfessionals() throws SQLException, Exception {

        List<RegisteredEmployee> registeredEmployeeList = new ArrayList<RegisteredEmployee>();

        String commandToExecute = String.format("SELECT * "
                + " FROM [bdci17].[bdci17].[health_professionals] "
                + " JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals].[id_registered_employee] "
                + " WHERE [registered_employee].[inactive] = 0 AND [registered_employee].[id] != %d;", ConnectionSetup.id);

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //int id, String name
            RegisteredEmployee employee = new RegisteredEmployee(resultSet.getInt("id"), resultSet.getString("name"));
            registeredEmployeeList.add(employee);
        }

        return registeredEmployeeList;
    }
    
    public List<RegisteredEmployee> SelectHealthProfessionalBySpecialization(int specializationID) throws SQLException, Exception {

        List<RegisteredEmployee> registeredEmployeeList = new ArrayList<RegisteredEmployee>();

        String commandToExecute = String.format(" SELECT [registered_employee].[id] AS id_healthprofessional, " +
                                                " [registered_employee].[name] AS name_healthprofessional " +
                                                " FROM [specialization] " +
                                                " JOIN [health_professionals_have_specialization] ON [health_professionals_have_specialization].[id_specialization] = [specialization].[id] " +
                                                " JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals_have_specialization].[id_health_professionals] " +
                                                " WHERE [specialization].id = %d;", specializationID);

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //int id, String name
            RegisteredEmployee employee = new RegisteredEmployee(resultSet.getInt("id_healthprofessional"), resultSet.getString("name_healthprofessional"));
            registeredEmployeeList.add(employee);
        }

        return registeredEmployeeList;
    }
    
    /**
     * Metodo que insere id do health professional e o id de specialization na
     * tabela HealthProfessionalsHaveSpecialization
     *
     * @param hpHasSp variavel que traz o Health Professional Has Specialization
     * (no singular pois tratamos de um em um)
     * @return true caso tenha inserido e false caso não tenha inserido.
     * @throws java.sql.SQLException
     */
    public boolean InsertHealthProfessionalsHaveSpecialization(HealthProfessionalsHaveSpecialization hpHasSp) throws SQLException {
        String commandToExecute = String.format("INSERT INTO [bdci17].[bdci17].[health_professionals_have_specialization] "
                + "(id_health_professionals, id_specialization) VALUES (%d, %d)", hpHasSp.getIdHealthProfessionals(), hpHasSp.getIdSpecialization());
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }

       
        /*
                nao dei opcao de mexer nisso:
        UPDATE [bdci17].[bdci17].[health_professionals_have_specialization] 
        SET id_specialization = 2
        WHERE id_health_professionals = 1012;
                */
 
}
