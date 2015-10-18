/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author William
 */
public class EmployeeRegistrer {
    /*
        [id] [int] NOT NULL,
	[name] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[id_login] [int] NULL,
    */
    
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
    private int id;
    private String name;
    private String password;
    private String login;
    
    // </editor-fold>
   
    // <editor-fold defaultstate="collapsed" desc="Construction">
    
    public EmployeeRegistrer(int id, String name, String password, String login) throws Exception{
        
        //Construtor para alterar employee registrer
        
        this.setId(id);
        this.setLogin(login);
        this.setName(name);
        this.setPassword(password);
    }
    
    public EmployeeRegistrer(String name, String password, String login) throws Exception{
        
        //Construtor para inserir employee registrer
        
        this.setLogin(login);
        this.setName(name);
        this.setPassword(password);
    }
    
     // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    public int getId() {
        return id;
    }

    public String getName() {
          return name;
    }

    public String getPassword() {
        return password;
    }
    
    public String getLogin() {
        return login;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    public void setId(int id) throws Exception {
        if(id <= 0)
            throw new Exception("ID inválido");
        
        this.id = id;
    }

    public void setName(String name) throws Exception {     
        if(name == null)
            throw new Exception("Name inválido");
        
        this.name = name;
    }

    public void setPassword(String password) throws Exception {
        if(password == null)
            throw new Exception("Password inválido");
        
                
        this.password = password;
    }
    
    public void setLogin(String login) throws Exception {
        if(login == null)
            throw new Exception("Login inválido");
        
        this.login = login;
    }
    
    // </editor-fold>
    
    
}
