package batalla;

/**
 * @author Tomás Delgado Acosta
 */
public class Muerto {
    private int id;
    private String ejercito;

    public Muerto() {
    }

    public Muerto(int id, String ejercito) {
        this.id = id;
        this.ejercito = ejercito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEjercito() {
        return ejercito;
    }

    public void setEjercito(String ejercito) {
        this.ejercito = ejercito;
    }
   
}
