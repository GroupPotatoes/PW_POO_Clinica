package Module.DBO;

public class Professions {
    /*
     [id] [int] NOT NULL,
     [name] [varchar](50) NOT NULL,
      
     */

    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private int id;
    private String name;

    // </editor-fold>
    public Professions(int id, String name) throws Exception {
        this.setId(id);
        this.setName(name);
    }

    // <editor-fold defaultstate="collapsed" desc="Setter">
    public void setId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }

        this.id = id;
    }

    public void setName(String name) throws Exception {
        if (name == null) {
            throw new Exception("Nome inválido");
        }

        this.name = name;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Getter">
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    // </editor-fold>

    public String toString() {
        return this.name;
    }
}
