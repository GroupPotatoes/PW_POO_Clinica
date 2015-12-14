package Module.DAO;

import Module.DBO.Availability;
import Module.DBO.ConnectionSetup;
import Module.DBO.Specialization;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AvailabilityDAO {

    private Connection connection;

    public AvailabilityDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean setAvailability(List<Availability> schedule) throws SQLException {

        String commandToExecute = String.format("INSERT INTO [bdci17].[bdci17].[availability] "
                + "(week_day, iniciation, finish, id_health_professionals, id_specialization) "
                + "VALUES ");
        //Adiciona cada Availability criada na tela ao string:
        for (Availability workday : schedule) {
            if (workday.getId() < 1) {
                commandToExecute += "(" + workday.getWeekDay() + "," + "'" + workday.getIniciation() + "'" + ","
                        + "'" + workday.getFinish() + "'" + "," + workday.getIdHealthProfessionals() + "," + workday.getIdSpecialization() + "), ";
            }
        }
        //apaga o espaço e a virgula apos a ultima inserção de valores
        commandToExecute = commandToExecute.substring(0, commandToExecute.length() - 2);
        //insere ponto-e-virgula ao final da string!
        commandToExecute += ";";
        System.out.println(commandToExecute);
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }

    public List<Availability> getAllAvailabilities(int idHealthProfessional) throws SQLException, Exception {
        Specialization specialization = new SpecializationDAO(ConnectionSetup.connection).getSpecialization(idHealthProfessional);

        String commandToExecute = String.format("SELECT id, week_day, iniciation, finish "
                + "FROM [bdci17].[bdci17].[availability] WHERE [availability].id_health_professionals = %d", idHealthProfessional);
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        List<Availability> availabilities = new ArrayList<Availability>();
        while (resultSet.next()) {
            availabilities.add(new Availability(resultSet.getInt("id"), idHealthProfessional, specialization.getId(), resultSet.getInt("week_day"), resultSet.getString("iniciation"), resultSet.getString("finish")));
        }
        return availabilities;
    }

    public boolean deleteAvailabilities(List<Availability> toDelete) throws SQLException {
        String commandToExecute = String.format("DELETE FROM [bdci17].[bdci17].[availability] "
                + "WHERE [availability].id ");
        if (toDelete.size() > 1) {
            commandToExecute += "IN (";
            //Adiciona cada Availability criada na tela ao string:
            for (Availability workday : toDelete) {
                commandToExecute += workday.getId() + ",";
            }
            //apaga o espaço e a virgula apos a ultima inserção de valores
            commandToExecute = commandToExecute.substring(0, commandToExecute.length() - 1);
            //insere ponto-e-virgula ao final da string!
            commandToExecute += ");";
        } else {
            commandToExecute += "= " + toDelete.get(0).getId() + ";";
        }
        System.out.println(commandToExecute);
        Statement st = this.connection.createStatement();
        return st.executeUpdate(commandToExecute) > 0;
    }

    public List<Availability> SelectAllAvailability(int healthProfessionalID, int specializationID, int dayOfWeek) throws SQLException, Exception {

        List<Availability> availabilities = new ArrayList();
        String commandToExecute = "";
        if (healthProfessionalID != 0) {
            commandToExecute = String.format(" SELECT [health_professionals].id_registered_employee, "
                    + " [health_professionals].cpf, "
                    + " [health_professionals].id_class, "
                    + " [registered_employee].name, "
                    + " [availability].id AS availability_id, "
                    + " [availability].week_day, "
                    + " [availability].iniciation, "
                    + " [availability].finish "
                    + " FROM [bdci17].[bdci17].[availability] "
                    + " JOIN [health_professionals] ON [health_professionals].[id_registered_employee] = [availability].[id_health_professionals] "
                    + " JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals].[id_registered_employee] "
                    + " WHERE [availability].[id_specialization] = %d AND [availability].week_day = %d  AND [health_professionals].[id_registered_employee] = %d;", specializationID, dayOfWeek, healthProfessionalID);
        } else {
            commandToExecute = String.format(" SELECT [health_professionals].id_registered_employee AS id_registered_employee, "
                    + " [health_professionals].cpf, "
                    + " [health_professionals].id_class, "
                    + " [registered_employee].name, "
                    + " [availability].id AS availability_id, "
                    + " [availability].week_day, "
                    + " [availability].iniciation, "
                    + " [availability].finish "
                    + " FROM [bdci17].[bdci17].[availability] "
                    + " JOIN [health_professionals] ON [health_professionals].[id_registered_employee] = [availability].[id_health_professionals] "
                    + " JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals].[id_registered_employee] "
                    + " WHERE [availability].[id_specialization] = %d AND [availability].week_day = %d;", specializationID, dayOfWeek);
        }

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            //int idRegisteredEmployee, String cpf, String idClass
            //HealthProfessionals hp = new HealthProfessionals(resultSet.getInt("id_registered_employee"), resultSet.getString("cpf"), resultSet.getString("id_class"), resultSet.getString("name"));
            //int id, int idHealthProfessionals, int idSpecialization, int weekDay, String iniciation, String finish

            Availability av = new Availability(resultSet.getInt("availability_id"), resultSet.getInt("id_registered_employee"), specializationID, resultSet.getInt("week_day"), resultSet.getString("iniciation"), resultSet.getString("finish"));
            availabilities.add(av);
        }

        return availabilities;

    }

    public List<Availability> SelectAllAvailability(int healthProfessionalID, int dayOfWeek) throws SQLException, Exception {

        List<Availability> availabilities = new ArrayList();
        String commandToExecute = String.format(" SELECT [health_professionals].id_registered_employee, "
                + " [health_professionals].cpf, "
                + " [health_professionals].id_class, "
                + " [registered_employee].name, "
                + " [availability].id AS availability_id, "
                + " [availability].week_day, "
                + " [availability].iniciation, "
                + " [availability].finish "
                + " FROM [bdci17].[bdci17].[availability] "
                + " JOIN [health_professionals] ON [health_professionals].[id_registered_employee] = [availability].[id_health_professionals] "
                + " JOIN [registered_employee] ON [registered_employee].[id] = [health_professionals].[id_registered_employee] "
                + " WHERE [availability].week_day = %d  AND [health_professionals].[id_registered_employee] = %d;", dayOfWeek, healthProfessionalID);

        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(commandToExecute);
        while (resultSet.next()) {
            Availability av = new Availability(resultSet.getInt("availability_id"), resultSet.getInt("id_registered_employee"), resultSet.getInt("week_day"), resultSet.getString("iniciation"), resultSet.getString("finish"), 0);
            availabilities.add(av);
        }

        return availabilities;

    }

    /**
     * Seleciona id de determinada consulta em determinado horário.
     */
    public int idsAvailability(int weekDay, String hrInicio, String nomeDoctor) throws Exception {
        String con = "select availability.id as id from availability join registered_employee ON "
                + "availability.id_health_professionals = registered_employee.id where "
                + "registered_employee.name = '"+nomeDoctor+"' "
                + "and availability.week_day="+weekDay;
        //TODO: o código abaixo foi comentado por causa de uma gambiarra
//                + " and availability.iniciation = '"+hrInicio+"';";
//        "select	availability.id"
//                + "from availability "
//                + "join registered_employee ON registered_employee.id = availability.id_health_professionals"
//                + "where registered_employee.name = '" + nomeDoctor + "' and availability.week_day=" + weekDay + " "
//                + "and availability.iniciation like '" + hrInicio + "'";
        Statement st = this.connection.createStatement();
        ResultSet resultSet = st.executeQuery(con);
        int id=-1;
//        ,i=0;
//        ArrayList<int> ids = new ArrayList<int>();
//        ArrayList<String> reultados = new ArrayList<String>();        
        while (resultSet.next()) {
//            ids[i] = resultSet.getInt("id");
            id = resultSet.getInt("id");
            
        }
        return id;
    }
}

//TODO: testar tela
