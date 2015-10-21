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
public class Specialization {
    /*
    [id] [int] NOT NULL,
	[name] [varchar](50) NOT NULL,
	[id_professions] [int] NOT NULL,
    */
    
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
    private int id;
    private String nome;
    private int idProfessions;
    
    // </editor-fold>
     
    // <editor-fold defaultstate="collapsed" desc="Constructions">
     
    public Specialization(int id,String nome,int idProfessions) throws Exception{
        this.setId(id);
        this.setNome(nome);
        this.setIdProfessions(idProfessions);
        
    }
    
    public Specialization(int id,String nome) throws Exception{
        this.setId(id);
        this.setNome(nome);
        
    }
    
    // </editor-fold>
       
    // <editor-fold defaultstate="collapsed" desc="Getter">
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdProfessions() {
        return idProfessions;
    }
    
    // </editor-fold>
   
    // <editor-fold defaultstate="collapsed" desc="Setter">
    
    public void setId(int id)throws Exception {
        if(id <= 0)
            throw new Exception("ID inválido");
        
        this.id = id;
    }

    public void setNome(String nome) throws Exception {     
        if(nome == null)
            throw new Exception("Nome inválido");
        
        this.nome = nome;
    }

    public void setIdProfessions(int idProfessions)throws Exception {
        if(idProfessions <= 0)
            throw new Exception("ID inválido");
        
        this.idProfessions = idProfessions;
    }
    
    // </editor-fold>
    
    
    
    
}
