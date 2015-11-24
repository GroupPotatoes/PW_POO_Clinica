/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Module.DAO;

import java.util.Date;

/**
 *
 * @author William
 */
public class Availability {
    
    /*
    [id] [int] NOT NULL,
	[week_day] [int] NOT NULL,
	[iniciation] [time](7) NOT NULL,
	[finish] [time](7) NOT NULL,
	[id_health_professionals] [int] NOT NULL,
	[id_specialization] [int] NOT NULL,
    */
    
         
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
        private int id;
        private HealthProfessionals healthProfessionals;
        private int idHealthProfessional;
        private int idSpecialization;
        private int weekDay;
        private Date iniciation;
        private Date finish;
           
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructions">
         
    public Availability(int week, Date iniciation, Date finish, HealthProfessionals healthProfessionals, int idSpecialization) throws Exception{
        this.setWeekDay(week);
        this.setFinish(finish);
        this.setIniciation(iniciation);
        this.setIdHealthProfessionals(healthProfessionals);
        this.setIdSpecialization(idSpecialization);
    }     
    
    public Availability(int id, int week, Date iniciation, Date finish, HealthProfessionals healthProfessionals, int idSpecialization) throws Exception{
        
        this.setId(id);
        this.setWeekDay(week);
        this.setFinish(finish);
        this.setIniciation(iniciation);
        this.setIdHealthProfessionals(healthProfessionals);
        this.setIdSpecialization(idSpecialization);
    }

    
    // </editor-fold>
        
    // <editor-fold defaultstate="collapsed" desc="Setter">
        
        public void setId(int id)throws Exception {
            if(id <= 0)
                throw new Exception("ID inválido");
        
            this.id = id;
        }

        public void setIdHealthProfessionals(HealthProfessionals healthProfessionals)throws Exception {
            if(healthProfessionals == null)
                throw new Exception("ID inválido");
        
            this.healthProfessionals = healthProfessionals;
        }

        public void setIdSpecialization(int idSpecialization)throws Exception {
            if(idSpecialization <= 0)
                throw new Exception("ID inválido");
        
            this.idSpecialization = idSpecialization;
        }

        public void setWeekDay(int weekDay)throws Exception {
            if(weekDay <= 0)
                throw new Exception("WeekDay inválido");
        
            this.weekDay = weekDay;
        }

        public void setIniciation(Date iniciation) throws Exception {
            if(iniciation == null)
                throw new Exception("DateIniciation inválido");

            this.iniciation = iniciation;
        }

        public void setFinish(Date finish) throws Exception {
            if(finish == null)
                throw new Exception("DateFinish inválido");

            this.finish = finish;
        }
        
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getter">
    public int getId() {
        return id;
    }

    public HealthProfessionals getIdHealthProfessionals() {
        return healthProfessionals;
    }

    public int getIdSpecialization() {
        return idSpecialization;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public Date getIniciation() {
        return iniciation;
    }

    public Date getFinish() {
        return finish;
    }
    
    // </editor-fold>
    
    public String toString()
    {
        return String.format("Médico: %s Dia da Semana: %s Horario: %s até %s", this.healthProfessionals.name, this.getDiaDaSemana(), this.getIniciation().toString(), this.getFinish().toString());
    }
    
    public String getDiaDaSemana(){
        switch(this.getWeekDay()){
            case 1: return "Domingo";
            case 2: return "Segunda-feira";
            case 3: return "Terça-feira";
            case 4: return "Quarta-feira";
            case 5: return "Quinta-feira";
            case 6: return "Sexta-feira";
            case 7: return "Sábado";
            default: return "Nenhum";
        }
    }
    
}
