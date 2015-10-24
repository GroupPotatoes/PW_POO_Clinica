/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Module.DAO;

import clinic.MeuPreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class PhoneType {
    
    private MeuPreparedStatement connection;
    
    /*
    [id] [int] NOT NULL,
    [name] [varchar](50) NOT NULL,
     */
    
    //TODO: fiz isso aqui porque, pensando a fundo, esse cara precisaria de um DAO
    public PhoneType(String tipoTelefone){
        try {
            this.setName(tipoTelefone);
        String commandGetId = String.format("SELECT id WHERE name='%s'", tipoTelefone);
        Statement st = this.connection.getConnection().createStatement();
        ResultSet resultSet = st.executeQuery(commandGetId);
        if (resultSet.next()) {            
                this.setId(resultSet.getInt("id"));            
        }
        } catch (SQLException ex) {
            Logger.getLogger(PhoneType.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PhoneType.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
        private int id;
        private String name;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
        public void setId(int id) throws Exception {
            if(id <= 0)
                throw new Exception("ID inválido");
        
            this.id = id;
        }

        public void setName(String name)throws Exception {
            if(name == null)
                throw new Exception("Nome inválido");

            this.name = name;
        }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getter">
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    
    // </editor-fold>
    
}
