package com.gestion;

import com.objects.ClienteT1;
import com.objects.ClienteT2;
import com.objects.Clientes;

/**
 * @author Tomás Delgado Acosta
 */
public class Gestion {

    public static final double CONSUMO = 0.32;//€ m3
    public static final double ALCANTARILLADO = 0.298;// m3
    public static final double DEPURACION = 0.226;// m3
    private static final double CONSERVACIONCONTADOR = 0.83;
    Clientes[] clientes;
    private static String clientesFile = "config";

    public Gestion() {
        LoadProperties load = new LoadProperties();
        clientes = new Clientes[Integer.parseInt(load.loadPropertie(clientesFile, "clientes"))];
    }

    public void run() {
        setClientData();
        printBill();

    }

    private void setClientData() {
        
        LoadProperties load = new LoadProperties();
        for (int i = 0; i < Integer.parseInt(load.loadPropertie(clientesFile, "clientes")); i++) {
            switch (load.loadPropertie(clientesFile, ("cliente.T." + i))) {
                case "Normal":
                    clientes[i] = new Clientes();
                    break;
                case "Tipo1":
                    clientes[i] = new ClienteT1();
                    break;
            
                case "Tipo2":
                    clientes[i] = new ClienteT2();
                    break;
                default:
                    break;
                    // El resto de tipos que se creen.
            }
            clientes[i].setNombre(load.loadPropertie(clientesFile, ("cliente.N." + i)));
            clientes[i].setDNI(load.loadPropertie(clientesFile, ("cliente.D." + i)));
            clientes[i].setMetrosCubicosConsumidos(Double.parseDouble(load.loadPropertie(clientesFile, ("cliente.M." + i))));
        }

    }

    private void printBill() {
        StringBuffer data = new StringBuffer();
        LoadProperties load = new LoadProperties();
        //for (int i = 0; i < Integer.parseInt(load.loadPropertie(clientesFile, "clientes")); i++) {}
        
        for (int i = 0; i < Integer.parseInt(load.loadPropertie(clientesFile, "clientes")); i++) {
            
            data.append("\t╔════════════════════════════════════════");
            data.append("\n\t║ Cliente ").append(load.loadPropertie(clientesFile, ("cliente.T." + i))).append("\t\tFactura cliente ").append(clientes[i].getNombre());
            data.append("\n\t║ Consumo de Agua ").append(load.loadPropertie(clientesFile, ("cliente.M." + i))).append("\t").append("Importe consumo = ").append(clientes[i].getConsumo());
            data.append("\n\t║ Saneamiento: ").append(load.loadPropertie(clientesFile, (load.loadPropertie(clientesFile, ("cliente.T." + i))+".alcantarillado"))).append("\t").append(clientes[i].getSaneamiento());
            data.append("\n\t║ Depuracion: ").append(load.loadPropertie(clientesFile, (load.loadPropertie(clientesFile, ("cliente.T." + i))+".depuracion"))).append("\t").append(clientes[i].getResiduales());
            data.append("\n\t╚════════════════════════════════════════");
//            System.out.println(clientes[i].getDNI() + "\n");
//            System.out.println(clientes[i].getNombre() + "\n");
//            System.out.println(clientes[i].getMetrosCubicosConsumidos() + "\n");
//            System.out.println(clientes[i].getConsumo() + "\n");
//            System.out.println(clientes[i].getSaneamiento() + "\n");
//            System.out.println(clientes[i].getResiduales() + "\n");

            data.append("\n\n");
        }
        System.out.println(data);
                    
    }
}
