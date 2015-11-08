/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Module.DAO;

import java.sql.Time;
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
    public Availability(int id, int idHealthProfessionals, int idSpecialization, int weekDay, Time iniciation, Time finish) throws Exception {
        this.setFinish(finish);
        this.setId(id);
        this.setIdHealthProfessionals(idHealthProfessionals);
        this.setIdSpecialization(idSpecialization);
        this.setIniciation(iniciation);
        this.setWeekDay(weekDay);
    }

    
         
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
        private int id;
        private int idHealthProfessionals;
        private int idSpecialization;
        private int weekDay;
        private Time iniciation;
        private Time finish;
           
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

        public void setIniciation(Time iniciation) throws Exception {
            if(iniciation == null)
                throw new Exception("TimeIniciation inválido");

            this.iniciation = iniciation;
        }

        public void setFinish(Time finish) throws Exception {
            if(finish == null)
                throw new Exception("TimeFinish inválido");

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

    public Time getIniciation() {
        return iniciation;
    }

    public Time getFinish() {
        return finish;
    }
    
    // </editor-fold>
    
}
