package Module.DAO;

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

       //funcoes de inserir health professional e update hp estao no registered employee DAO. mudar para ca? 
        /*
        UPDATE [bdci17].[bdci17].[registered_employee] 
        SET name='%s', password='%s', login='%s'
        WHERE id = 1012;
        colocar esse update no registeredemployeedao?? ou chamar funcao q faca isso

        UPDATE [bdci17].[bdci17].[health_professionals]
        SET cpf='333', id_class='%s'
        WHERE id_registered_employee = 1012;

                nao dei opcao de mexer nisso:
        UPDATE [bdci17].[bdci17].[health_professionals_have_specialization] 
        SET id_specialization = 2
        WHERE id_health_professionals = 1012;
                */
 
}
