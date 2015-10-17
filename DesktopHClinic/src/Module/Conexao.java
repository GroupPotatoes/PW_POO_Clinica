package Module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe que valida, abre e fecha conexões com o Banco de Dados. 
 * @author Maiara Rodrigues
 */
public class Conexao {
    
    private Connection connection;
    private String nomeServidor;
    private int porta;
    private String database;
    private String login;
    private String senha;
    
    /**
     * Construtor da classe Conexao.
     * @param nomeServidor nome do servidor que a conexão fará.
     * @param porta nome da porta  que a conexão fará.
     * @param database nome do database  que a conexão fará.
     * @param login nome do login que a conexão fará.
     * @param senha nome da senha  que a conexão fará.
     */
    public Conexao(String nomeServidor, int porta, String database,String login,String senha){
        this.database=database;
        this.nomeServidor=nomeServidor;
        this.porta=porta;
        this.login=login;
        this.senha=senha;
    }

    /**
     * Getter da conexão.
     * @return connection
     */
    public Connection getConnection() {
        return connection;
    }
    
    /**
     * Getter do nome do servidor.
     * @return nomeServidor
     */
    public String getNomeServidor() {
        return nomeServidor;
    }

    /**
     * Getter da porta.
     * @return porta
     */
    public int getPorta() {
        return porta;
    }

    /**
     * Getter da database.
     * @return database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * Getter do login.
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Getter da senha.
     * @return senha
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Método que abre a conexão com o Banco de Dados.
     */
    public void abreConexao(){
        try{
            this.connection = DriverManager.getConnection("jdbc:sqlserver://"+nomeServidor+":"+porta+
                            ";databasename="+database+";", login, senha);            
            if(connection.isValid(0))
                System.out.println("Conexão efetuada");             
        }catch (SQLException ex) {
            // Se ocorrem erros de conexão
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }catch (Exception e) {
            // se ocorrerem outros erros
            System.err.println("Problemas ao tentar conectar com o banco de dados: " + e);
        }        
    }
    
    /**
     * Método que fecha a conexão com o Banco de Dados.
     */
    public void fechaConexao() {
        try{
            this.connection.close();
            System.out.println("Conexão fechada.");
        }catch (SQLException e) {
            // se ocorrerem erros na conexão
            System.out.println("Problemas ao fechar a conexão: " + e);
        }                   
    }   
}
