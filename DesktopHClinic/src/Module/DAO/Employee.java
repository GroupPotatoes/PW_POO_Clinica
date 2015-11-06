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
    [id_registered_employee] [int] NOT NULL,
	[role_id] [int] NOT NULL
    */
    
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
    private int idRegisteredEmployee;
    private int idRole;
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructions">
    
    public Employee(int idRegisteredEmployee, int idRole) throws Exception{
        this.setidRegisteredEmployee(idRegisteredEmployee);
        this.setIdRole(idRole);
    }
    
    public Employee(int idRole) throws Exception{
        this.setIdRole(idRole);
    }
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    public void setidRegisteredEmployee(int idRegisteredEmployee)throws Exception {
            if(idRegisteredEmployee <= 0)
                throw new Exception("ID inválido");
        
        this.idRegisteredEmployee = idRegisteredEmployee;
    }

    public void setIdRole(int idRole)throws Exception {
        if(idRole <= 0)
            throw new Exception("ID inválido");
        
        this.idRole = idRole;
    }
    
    // </editor-fold>
 
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    public int getidRegisteredEmployee() {
        return idRegisteredEmployee;
    }

    public int getIdRole() {
        return idRole;
    }
    
    // </editor-fold>
}
