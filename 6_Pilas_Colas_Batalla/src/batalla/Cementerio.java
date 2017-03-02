package batalla;

import java.util.Stack;

/**
 * @author Tomás Delgado Acosta
 */
public class Cementerio {
    Stack<Muerto> cementerio = new Stack();

    public Stack<Muerto> getCementerio() {
        return cementerio;
    }

    public void setCementerio(Stack<Muerto> cementerio) {
        this.cementerio = cementerio;
    }
    Muerto fallecido;
    
    public void nuevoMuerto(Soldado s, String ejercito){
        fallecido = new Muerto();
        fallecido.setId(s.getId());
        fallecido.setEjercito(ejercito);
        cementerio.push(fallecido);
    }
    public void listaDeCadaveres(){
        
    }
    
}
