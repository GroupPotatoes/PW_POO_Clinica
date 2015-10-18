/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.Date;

/**
 *
 * @author William
 */
public class Patient {
        /*
	[id] [int] NOT NULL,
	[name] [varchar](50) NOT NULL,
	[cep] [int] NOT NULL,
	[number] [int] NOT NULL,
	[complement] [varchar](50) NOT NULL,
	[id_login] [int] NULL,
    */
         
    // <editor-fold defaultstate="collapsed" desc="Attributes">
        
        private int id;
        private String name;
        private String cep;
        private String cpf;
        private String number;
        private String complement;
        private String login;
        private String password;
        private String rg;
        private Date birthDate;
        
    // </editor-fold>
      
    // <editor-fold defaultstate="collapsed" desc="Construction">    
        
     public Patient(String name, String cep, String rg, Date birthDate, String cpf, String number, String complement, String login, String password) throws Exception{
         /*
            Construtor para inserir patient no DB
         */
         this.setName(name);
         this.setCep(cep);
         this.setCpf(cpf);
         this.setRg(rg);
         this.setBirthDate(birthDate);
         this.setNumber(number);
         this.setComplement(complement);
         this.setLogin(login);
         this.setPassword(password);
     }   
     
     public Patient(int id, String name, String cep, String rg, Date birthDate, String cpf, String number, String complement, String login, String password) throws Exception{        
         /*
            Construtor completo
            Construtor para atualizar patient no DB
         */         
         this.setId(id);
         this.setName(name);
         this.setCep(cep);
         this.setCpf(cpf);
         this.setRg(rg);
         this.setBirthDate(birthDate);
         this.setNumber(number);
         this.setComplement(complement);
         this.setLogin(login);
         this.setPassword(password);
     }
     
     // </editor-fold> 
     
    // <editor-fold defaultstate="collapsed" desc="Setter">
        
        public void setId(int id) throws Exception {
            if(id <= 0)
                throw new Exception("ID inválido");
        
            this.id = id;
        }

        public void setName(String name)throws Exception {
            
            if(name == null)
                throw new Exception("Name inválido.");
            
            this.name = name;
        }

        public void setCep(String cep) throws Exception {
            if(cep == null)
                throw new Exception("CEP inválido.");
            
            this.cep = cep;
        }


        public void setCpf(String cpf) throws Exception {
            if(cpf == null)
                throw new Exception("CPF inválido.");
            
            this.cpf = cpf;
        }

        public void setNumber(String number) throws Exception {
            if(number == null)
                throw new Exception("Number inválido.");
            
            this.number = number;
        }

        public void setComplement(String complement)  throws Exception {
            if(complement == null)
                throw new Exception("Complement inválido.");
            
            this.complement = complement;
        }

        public void setLogin(String login)throws Exception {
            if(login == null)
                throw new Exception("Login inválido.");
            
            this.login = login;
        }

        public void setPassword(String password) throws Exception {
            if(password == null)
                throw new Exception("Password inválido.");
            
            this.password = password;
        }

        public void setRg(String rg)  throws Exception {
            if(rg == null)
                throw new Exception("RG inválido.");
            
            this.rg = rg;
        }

        public void setBirthDate(Date birthDate)throws Exception {
           // if(birthDate == null)
             //   throw new Exception("BirthDate inválido.");
            
            this.birthDate = birthDate;
        }
          
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getter">
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCep() {
        return cep;
    }
    
    public String getCpf() {
        return cpf;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
        
    public String getRg() {
        return rg;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    
    // </editor-fold>

}
