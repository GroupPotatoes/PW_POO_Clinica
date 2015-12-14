package Module.DBO;

public class Availability {

    /*
    [id] [int] NOT NULL,
    [week_day] [int] NOT NULL,
    [iniciation] [String](7) NOT NULL,
    [finish] [String](7) NOT NULL,
    [id_health_professionals] [int] NOT NULL,
    [id_specialization] [int] NOT NULL,
     */
    public Availability(int idHealthProfessionals, int idSpecialization, int weekDay, String iniciation, String finish) throws Exception {
        this.setFinish(finish);
        this.setIdHealthProfessionals(idHealthProfessionals);
        this.setIdSpecialization(idSpecialization);
        this.setIniciation(iniciation);
        this.setWeekDay(weekDay);
    }

    public Availability(int id, int idHealthProfessionals, int idSpecialization, int weekDay, String iniciation, String finish) throws Exception {
        this.setId(id);
        this.setFinish(finish);
        this.setIdHealthProfessionals(idHealthProfessionals);
        this.setIdSpecialization(idSpecialization);
        this.setIniciation(iniciation);
        this.setWeekDay(weekDay);
    }

    public Availability(int id, int idHealthProfessionals, int weekDay, String iniciation, String finish, int gambs) throws Exception {
        this.setId(id);
        this.setFinish(finish);
        this.setIdHealthProfessionals(idHealthProfessionals);
        this.setIniciation(iniciation);
        this.setIniciation(iniciation);
        this.setWeekDay(weekDay);
        this.setWeekDay(weekDay);
    }

// <editor-fold defaultstate="collapsed" desc="Attributes">
    private int id;
    private int idHealthProfessionals;
    private int idSpecialization;
    private int weekDay;
    private String iniciation;
    private String finish;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Setter">
    public void setId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }

        this.id = id;
    }

    public void setIdHealthProfessionals(int idHealthProfessionals) throws Exception {
        if (idHealthProfessionals <= 0) {
            throw new Exception("ID inválido");
        }

        this.idHealthProfessionals = idHealthProfessionals;
    }

    public void setIdSpecialization(int idSpecialization) throws Exception {
        if (idSpecialization <= 0) {
            throw new Exception("ID inválido");
        }

        this.idSpecialization = idSpecialization;
    }

    public void setWeekDay(int weekDay) throws Exception {
        if (weekDay <= 0) {
            throw new Exception("WeekDay inválido");
        }

        this.weekDay = weekDay;
    }

    public void setIniciation(String iniciation) throws Exception {
        if (iniciation == null) {
            throw new Exception("Inicio inválido");
        }

        this.iniciation = iniciation;
    }

    public void setFinish(String finish) throws Exception {
        if (finish == null) {
            throw new Exception("Fim inválido");
        }

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

    public String getIniciation() {
        return iniciation;
    }

    public String getFinish() {
        return finish;
    }

    // </editor-fold>
    public String toString() {
        String day = "";
        switch (this.weekDay) {
            case 1:
                day = "Domingo";
                break;
            case 2:
                day = "Segunda";
                break;
            case 3:
                day = "Terça";
                break;
            case 4:
                day = "Quarta";
                break;
            case 5:
                day = "Quinta";
                break;
            case 6:
                day = "Sexta";
                break;
            case 7:
                day = "Sábado";
                break;
        }
        String inicio = this.iniciation;
        String fim = this.finish;
        inicio = inicio.substring(0, inicio.length() - 11);
        fim = fim.substring(0, fim.length() - 11);
        return (day + ", das " + inicio + " às " + fim);
    }

}
