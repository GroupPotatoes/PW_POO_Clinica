/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Module.DAO;

/**
 *
 * @author William
 */
public class Employee {
    /*
    [id_employee_registrer] [int] NOT NULL,
	[role_id] [int] NOT NULL
    */
    
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
    private int idEmployeeRegistrer;
    private int idRole;
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructions">
    
    public Employee(int idEmployeeRegistrer, int idRole) throws Exception{
        this.setIdEmployeeRegistrer(idEmployeeRegistrer);
        this.setIdRole(idRole);
    }
    
    public Employee(int idRole) throws Exception{
        this.setIdRole(idRole);
    }
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    public void setIdEmployeeRegistrer(int idEmployeeRegistrer)throws Exception {
            if(idEmployeeRegistrer <= 0)
                throw new Exception("ID inválido");
        
        this.idEmployeeRegistrer = idEmployeeRegistrer;
    }

    public void setIdRole(int idRole)throws Exception {
        if(idRole <= 0)
            throw new Exception("ID inválido");
        
        this.idRole = idRole;
    }
    
    // </editor-fold>
 
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    public int getIdEmployeeRegistrer() {
        return idEmployeeRegistrer;
    }

    public int getIdRole() {
        return idRole;
    }
    
    // </editor-fold>
}
