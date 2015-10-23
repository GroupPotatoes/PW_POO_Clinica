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
public class HealthProfessionals {
    /*
        [health_professionals](
	[id_employee_registrer] [int] NOT NULL,
	[cpf] [numeric](18, 0) NOT NULL,
	[id_class] [nvarchar](50) NOT NULL,
    */
    
     
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
    private int idEmployeeRegistrer;
    private String cpf;
    private String idClass;
    
    // </editor-fold>
   
    // <editor-fold defaultstate="collapsed" desc="Construction">
    
    public HealthProfessionals(int idEmployeeRegistrer, String cpf, String idClass) throws Exception{
        this.setIDEmployeeRegistrer(idEmployeeRegistrer);
        this.setCPF(cpf);
        this.setIDClass(idClass);
    }
    
    public HealthProfessionals(String cpf, String idClass) throws Exception{
        this.setCPF(cpf);
        this.setIDClass(idClass);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    public int getIDEmployeeRegistrer() {
        return idEmployeeRegistrer;
    }

    public String getCPF() {
          return cpf;
    }

    public String getIDClass() {
        return idClass;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    public void setIDEmployeeRegistrer(int idEmployeeRegistrer) throws Exception {
        if(idEmployeeRegistrer <= 0)
            throw new Exception("ID inválido");
        
        this.idEmployeeRegistrer = idEmployeeRegistrer;
    }

    public void setCPF(String cpf) throws Exception {     
        if(cpf == null)
            throw new Exception("CPF inválido");
        
        this.cpf = cpf;
    }

    public void setIDClass(String idClass) throws Exception {
        if(idClass == null)
            throw new Exception("idClass inválido");
        
        this.idClass = idClass;
    }
    
    // </editor-fold>
    
}
