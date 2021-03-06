package View.TelasPrincipais;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que inicializa o formulário de login.
 * @author Maiara Rodrigues
 */
public class Main {
    
    /**
     * Método que inicializa o formulário de login.
     * @param args
     * @throws SQLException 
     *              Erro ao acessar o Banco de Dados.
     */
    public static void main(String args[]) throws SQLException {          
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
        
    }
}
