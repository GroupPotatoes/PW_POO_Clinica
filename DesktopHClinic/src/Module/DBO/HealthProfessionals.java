package Module.DBO;

public class HealthProfessionals {
    /*
        [health_professionals](
	[id_registered_employee] [int] NOT NULL,
	[cpf] [numeric](18, 0) NOT NULL,
	[id_class] [nvarchar](50) NOT NULL,
    */
    
     
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
    private int idRegisteredEmployee;
    private String cpf;
    private String idClass;
    
    // </editor-fold>
   
    // <editor-fold defaultstate="collapsed" desc="Construction">
    
    public HealthProfessionals(int idRegisteredEmployee, String cpf, String idClass) throws Exception{
        this.setidRegisteredEmployee(idRegisteredEmployee);
        this.setCPF(cpf);
        this.setIDClass(idClass);
    }
    
    public HealthProfessionals(String cpf, String idClass) throws Exception{
        this.setCPF(cpf);
        this.setIDClass(idClass);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    public int getidRegisteredEmployee() {
        return idRegisteredEmployee;
    }

    public String getCPF() {
          return cpf;
    }

    public String getIDClass() {
        return idClass;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    public void setidRegisteredEmployee(int idRegisteredEmployee) throws Exception {
        if(idRegisteredEmployee <= 0)
            throw new Exception("ID inválido");
        
        this.idRegisteredEmployee = idRegisteredEmployee;
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
