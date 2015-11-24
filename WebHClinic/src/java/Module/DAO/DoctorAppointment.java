package Module.DAO;

public class DoctorAppointment {

    /*
     [id] [int] NOT NULL,
     ///DATE - format YYYY-MM-DD
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
    private String specializationName;
    private String iniciation;
    private String finish;
    private String date;

    private String observation;
    private String recommendation;
    private String medicalExamRequest;
    private String prescription;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Construction">
    public DoctorAppointment(int id, int idPatient, int idAvailability, String iniciation, String finish, String date, String specializationName) throws Exception {
        this.setId(id);
        this.setFinish(finish);
        this.setDate(date);
        this.setIniciation(iniciation);
        this.setIdAvailability(idAvailability);
        this.setIdPatient(idPatient);
        this.setSpecializationName(specializationName);
    }
    
    public DoctorAppointment(int idPatient, int idAvailability, String iniciation, String finish, String date) throws Exception {
        this.setFinish(finish);
        this.setDate(date);
        this.setIniciation(iniciation);
        this.setIdAvailability(idAvailability);
        this.setIdPatient(idPatient);
    }

    public DoctorAppointment(int id, int idPatient, int idAvailability, String specializationName, String iniciation, String finish, String date, String observation, String recommendation, String medicalExamRequest, String prescription) {
        this.id = id;
        this.idPatient = idPatient;
        this.idAvailability = idAvailability;
        this.specializationName = specializationName;
        this.iniciation = iniciation;
        this.finish = finish;
        this.date = date;
        this.observation = observation;
        this.recommendation = recommendation;
        this.medicalExamRequest = medicalExamRequest;
        this.prescription = prescription;
    }

    // </editor-fold>    
    // <editor-fold defaultstate="collapsed" desc="Setter">
    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public void setId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }

        this.id = id;
    }

    public void setIdPatient(int idPatient) throws Exception {
        if (idPatient <= 0) {
            throw new Exception("ID inválido");
        }

        this.idPatient = idPatient;
    }

    public void setIdAvailability(int idAvailability) throws Exception {
        if (idAvailability <= 0) {
            throw new Exception("ID inválido");
        }

        this.idAvailability = idAvailability;
    }

    public void setIniciation(String iniciation) throws Exception {

        if (iniciation == null) {
            throw new Exception("StringIniciation inválido");
        }

        this.iniciation = iniciation;
    }

    public void setFinish(String finish) throws Exception {

        if (finish == null) {
            throw new Exception("StringFinish inválido");
        }

        this.finish = finish;
    }

    public void setObservation(String observation) throws Exception {

        if (observation == null) {
            throw new Exception("Observation inválido");
        }

        this.observation = observation;
    }

    public void setRecommendation(String recommendation) throws Exception {

        if (recommendation == null) {
            throw new Exception("Recommendation inválido");
        }

        this.recommendation = recommendation;
    }

    public void setMedicalExamRequest(String medicalExamRequest) throws Exception {

        if (medicalExamRequest == null) {
            throw new Exception("MedicalExamRequest inválido");
        }

        this.medicalExamRequest = medicalExamRequest;
    }

    public void setPrescription(String prescription) throws Exception {

        if (prescription == null) {
            throw new Exception("Prescription inválido");
        }

        this.prescription = prescription;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">   
    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public int getIdAvailability() {
        return idAvailability;
    }

    public String getIniciation() {
        return iniciation;
    }

    public String getFinish() {
        return finish;
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
    public String toString() {
        // substring para tirar os ultimos 11 caracteres presentes nos horarios (ver no BD)
        String inicio = this.iniciation;
        String fim = this.finish;
        inicio = inicio.substring(0, inicio.length() - 11);
        fim = fim.substring(0, fim.length() - 11);
        return String.format("\tEspecialização: %s Dia: %s \n\t\tHora inicial: %s Hora final: %s", this.specializationName, this.date, inicio, fim);
    }

}
