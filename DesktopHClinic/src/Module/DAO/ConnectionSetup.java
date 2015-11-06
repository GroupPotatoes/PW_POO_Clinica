package Module.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionSetup {
    
    public static Connection connection;
    public static  int id=0;
    public static int id_hp=0;
    public static  RegisteredEmployee currentEmployeeSelect = null;
    private String serverName="FS5";
    private String port="1433";
    private String database="bdci17";
    private String login="bdci17";
    private String password="ert985";
  
    public ConnectionSetup() throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlserver://"+this.serverName+":"+this.port+
                        ";databasename="+this.database+";", this.login, this.password);

          if(!connection.isValid(0))
                    System.err.println(("Conexão inválida"));
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
