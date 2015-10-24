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
public class DoctorAppointment {
    
    /*
        [id] [int] NOT NULL,
	[date] [date] NOT NULL,
	[iniciation] [time](7) NOT NULL,
	[finish] [time](7) NOT NULL,
	[id_patient] [int] NOT NULL,
	[id_availability] [int] NOT NULL,
	[observation] [varchar](50) NOT NULL,
	[recommendation] [varchar](50) NOT NULL,
	[medical_exam_request] [varchar](50) NOT NULL,
	[prescription] [varchar](50) NOT NULL,
    */
         
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    
        private int id;
        private int idPatient;
        private int idAvailability;
        //Date tem a data e hora, eu acho
        private Date dateIniciation;
        private Date dateFinish;
        private String observation;
        private String recommendation;
        private String medicalExamRequest;
        private String prescription;
            
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Setter">
        public void setId(int id) throws Exception {
            if(id <= 0)
                throw new Exception("ID inválido");
        
            this.id = id;
        }

        public void setIdPatient(int idPatient) throws Exception {
            if(idPatient <= 0)
                throw new Exception("ID inválido");
        
            this.idPatient = idPatient;
        }

        public void setIdAvailability(int idAvailability) throws Exception {
            if(idAvailability <= 0)
                throw new Exception("ID inválido");
        
            this.idAvailability = idAvailability;
        }

        public void setDateIniciation(Date dateIniciation) throws Exception {
            
            if(dateIniciation == null)
                throw new Exception("DateIniciation inválido");
            
            this.dateIniciation = dateIniciation;
        }

        public void setDateFinish(Date dateFinish)  throws Exception {
            
            if(dateFinish == null)
                throw new Exception("DateFinish inválido");
            
            this.dateFinish = dateFinish;
        }

        public void setObservation(String observation) throws Exception {
            
            if(observation == null)
                throw new Exception("Observation inválido");
            
            this.observation = observation;
        }

        public void setRecommendation(String recommendation)throws Exception {
            
            if(recommendation == null)
                throw new Exception("Recommendation inválido");
            
            this.recommendation = recommendation;
        }

        public void setMedicalExamRequest(String medicalExamRequest)throws Exception {
            
            if(medicalExamRequest == null)
                throw new Exception("MedicalExamRequest inválido");
            
            this.medicalExamRequest = medicalExamRequest;
        }

        public void setPrescription(String prescription)throws Exception {
            
            if(prescription == null)
                throw new Exception("Prescription inválido");
            
            this.prescription = prescription;
        }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getter">
    public int getId() {
        return id;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public int getIdAvailability() {
        return idAvailability;
    }

    public Date getDateIniciation() {
        return dateIniciation;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public String getObservation() {
        return observation;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public String getMedicalExamRequest() {
        return medicalExamRequest;
    }

    public String getPrescription() {
        return prescription;
    }
    
    
    // </editor-fold>
    
}
