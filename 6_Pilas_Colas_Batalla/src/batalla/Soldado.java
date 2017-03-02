package batalla;

/**
 * @author Tomás Delgado Acosta
 */
public class Soldado {
    private int id;
    private int vida;
   
    public Soldado() {
    }
    
    public Soldado(int i, int vida){
        this.id = i;
        this.vida = vida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
