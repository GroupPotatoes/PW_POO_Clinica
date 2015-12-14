package Module.DBO;

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
        public String namePatient;
        private String dateIniciation;
        private String dateFinish;
        private String date;
        private String observation;
        private String recommendation;
        private String medicalExamRequest;
        private String prescription;
            
    // </editor-fold>
       
     public DoctorAppointment(int idPatient, int idAvailability, String dateIniciation, String dateFinish) throws Exception{
              this.setIdPatient(idPatient);
              this.setIdAvailability(idAvailability);
              this.setDateIniciation(dateIniciation);
              this.setDateFinish(dateFinish);
    }
    
    public DoctorAppointment(int id, int idPatient, int idAvailability, String dateIniciation, String dateFinish, String observation, String recommendation, 
            String medicalExamRequest, String prescription, String namePatient, String date) throws Exception{
              this.setId(id);
              this.setIdPatient(idPatient);
              this.setIdAvailability(idAvailability);
              this.setDateIniciation(dateIniciation);
              this.setDateFinish(dateFinish);
              this.setObservation(observation);
              this.setRecommendation(recommendation);
              this.setMedicalExamRequest(medicalExamRequest);
              this.setPrescription(prescription);
              this.namePatient = namePatient;
              this.setDate(date);
    }
        
        
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

        public void setDateIniciation(String dateIniciation) throws Exception {
            
            if(dateIniciation == null)
                throw new Exception("DateIniciation inválido");
            
            this.dateIniciation = dateIniciation;
        }

        public void setDateFinish(String dateFinish)  throws Exception {
            
            if(dateFinish == null)
                throw new Exception("DateFinish inválido");
            
            this.dateFinish = dateFinish;
        }
        
        public void setDate(String date)  throws Exception {
            
            if(date == null)
                throw new Exception("Date inválido");
            
            this.date = date;
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

    public String getDateIniciation() {
        return dateIniciation;
    }

    public String getDateFinish() {
        return dateFinish;
    }

    public String getDate() {
        return date;
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
    
    public String toString(){
        if(this.dateIniciation.length() > 5 )
            this.dateIniciation = this.dateIniciation.substring(0, this.dateIniciation.length() - 11);
        if(this.dateFinish.length() > 5 )
            this.dateFinish = this.dateFinish.substring(0, this.dateFinish.length() - 11);
        
        return String.format("Dia: %s das %s até às %s com o paciente %s", this.date, this.dateIniciation, this.dateFinish, this.namePatient);
    }
    
}
