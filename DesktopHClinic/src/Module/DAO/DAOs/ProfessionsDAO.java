package Module.DAO;

import Module.DBO.Professions;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfessionsDAO {

    private Connection connection;

    public ProfessionsDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Professions> SelectAllProfessions() throws SQLException, Exception {

        List<Professions> professions = new ArrayList<Professions>();

        String commandToExecute = String.format("SELECT * FROM [bdci17].[bdci17].[professions];");

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //id, name
            Professions profession = new Professions(resultSet.getInt("id"), resultSet.getString("name"));
            professions.add(profession);
        }

        return professions;
    }
    /**
     * Retorna objeto Professions com id e nome, porém é necessário JÁ TER O ID!
     * Usar SpecializationDAO, metodo getSpecialization 
     * @param idProfession
     * @return 
     */
    public Professions getProfession(int idProfession) throws SQLException, Exception {
        Professions prof;
        String commandToExecute = String.format("SELECT * FROM [bdci17].[bdci17].[specialization]"
                    + "WHERE id = %d;", idProfession);
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        if (resultSet.next()) {
            //id, name
            prof = new Professions(resultSet.getInt("id"), resultSet.getString("name"));
            return prof;
        }
        return null;
    }
}
