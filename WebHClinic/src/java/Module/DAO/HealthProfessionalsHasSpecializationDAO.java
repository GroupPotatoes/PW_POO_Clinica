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
public class HealthProfessionalsHasSpecializationDAO {
     
    /*[id_health_professionals] [int] NOT NULL,
	[id_specialization] [int] NOT NULL*/
    
         
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
    private int idHealthProfessionals;
    private int idSpecialization;
        
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
       
        public void setIdHealthProfessionals(int idHealthProfessionals) throws Exception {
            if(idHealthProfessionals <= 0)
                throw new Exception("ID inválido");
        
            this.idHealthProfessionals = idHealthProfessionals;
        }

        public void setIdSpecialization(int idSpecialization)throws Exception {
            if(idSpecialization <= 0)
                throw new Exception("ID inválido");
        
            this.idSpecialization = idSpecialization;
        }
        
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="Getter">
    public int getIdHealthProfessionals() {
        return idHealthProfessionals;
    }

    public int getIdSpecialization() {
        return idSpecialization;
    }
    
    // </editor-fold>
}
