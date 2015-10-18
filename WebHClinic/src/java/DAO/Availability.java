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
        private int idHealthProfessionals;
        private int idSpecialization;
        private int weekDay;
        private Date iniciation;
        private Date finish;
           
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
        
        public void setId(int id)throws Exception {
            if(id <= 0)
                throw new Exception("ID inválido");
        
            this.id = id;
        }

        public void setIdHealthProfessionals(int idHealthProfessionals)throws Exception {
            if(idHealthProfessionals <= 0)
                throw new Exception("ID inválido");
        
            this.idHealthProfessionals = idHealthProfessionals;
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

    public int getIdHealthProfessionals() {
        return idHealthProfessionals;
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
    
}
