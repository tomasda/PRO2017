package batalla;

/**
 * @author Tomás Delgado Acosta
 */
public class Batalla {
    Ejercito norte;
    Ejercito sur;
    Cementerio cementerio;
    
    public Batalla() {
        
    }
    
    public void run(){
        // Creo los soldados
        norte = new Ejercito(2, "norte", 100);
        sur = new Ejercito(10, "sur", 50);
        // Creo el Cementerio.
        cementerio = new Cementerio();
        // Batalla
        batalla();
        reporteDeBatalla();
    }
    
    private void batalla() {
        int guerra;
        int batallas = 1;
        do{
        guerra = 0;
        //obtengo 1 soldado ejercito 1
        Soldado solA = new Soldado();
        solA = norte.ejercito.poll();
        //obtengo 1 soldado ejercito 2
        Soldado solB = new Soldado();
        solB = sur.ejercito.poll();
        guerra = (solA.getVida()-solB.getVida());
        System.out.println("\nBatalla nº " + batallas );
        if ((guerra)>0){
            //Gana A
            solA.setVida((int)(guerra*1.2));
            norte.ejercito.offer(solA);
            solB.setVida(0);
            Cementerio(solB, sur.getNombre());
            System.out.println("\tGana norte " + solA.getVida() );
        }else if((guerra)<0){
            // Gana B
            guerra= Math.abs(guerra);
            solB.setVida((int)(guerra*1.2));
            sur.ejercito.offer(solB);
            solA.setVida(0);
            Cementerio(solA, norte.getNombre());
            System.out.println("\tGana sur " + solB.getVida() );
        }else{
            //Empate
            solA.setVida(guerra);
            norte.ejercito.offer(solA);
            solB.setVida(guerra);
            sur.ejercito.offer(solB);
            System.out.println("\tEmpate " + solA.getVida()+ " " + solB.getVida() );
        }
        batallas++;
        }while(sur.ejercito.size()>0 && norte.ejercito.size()>0);
        System.out.println("\n\tLa batalla la ha ganado ");
        if (sur.ejercito.size()>0){
            System.out.println("\n\tEl NORTE ");
        }else{
            System.out.println("\n\tEl SUR ");
        }
    }
    
    
    private void Cementerio(Soldado soldado, String ejercito) {
        cementerio.nuevoMuerto(soldado , ejercito);
    }
    
      
    public void repudio(){
                Soldado sol;
        int a = norte.ejercito.size();
        for (int i = 0; i < a; i++) {
            sol = new Soldado();
            sol=norte.ejercito.poll();
            System.out.println(sol.getId()+sol.getVida());
        }
        a = sur.ejercito.size();
        for (int i = 0; i < a; i++) {
            sol = new Soldado();
            sol=sur.ejercito.poll();
            System.out.println(sol.getId()+sol.getVida());
        }

    }

    private void reporteDeBatalla() {
        StringBuffer data = new StringBuffer();
        Muerto fallecido;
        System.out.println("\nListado de Muertos enterrados en el cementerio" );
        while (!cementerio.getCementerio().empty()){
            fallecido = new Muerto();
            fallecido = cementerio.getCementerio().pop();
            data.append("\n").append(fallecido.getEjercito()).append(" ").append(fallecido.getId());
        }
        System.out.println(data);
    }


 
}
