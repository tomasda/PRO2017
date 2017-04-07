package GestionCamiones;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import GestionCamiones.Camion;
import GestionCamiones.Trailer;
import Objetos.Pinchazo;
import Objetos.Rueda;



public class Gestion {
	Pinchazo pinch;
	Rueda rueda;
	ArrayList<Pinchazo> alPinch;
	ArrayList<Rueda> alRueda;
	
	ArrayList<Camion> camiones = new ArrayList<Camion>();

	public void run() {
			
		
		
		Date date  = new Date();
		
		pinch = new Pinchazo();
		pinch.setFechaPinchazo(date);
		pinch.setKm(200);
		alPinch = new ArrayList<Pinchazo>();
		alPinch.add(pinch);
		
		rueda =  new Rueda();
		rueda.setFechaMontaje(date);
		rueda.setKmRealizados(1000);
		rueda.setMarca("Michelin");
		rueda.setPinchazos(alPinch);

		alRueda = new ArrayList<Rueda>();
		alRueda.add(rueda);
		
		Trailer pepe = new Trailer();
		pepe.setMatricula("TF-2345-AB");
		pepe.setNumRuedas(1);
		pepe.setRuedas(alRueda);
		
		camiones.add(pepe);
		
		System.out.println(pepe.NumBastidor);
		pepe.hora();
		System.out.println(pepe.getRuedas().get(0).getPinchazos().get(0).getKm());
		
		Queue a = new LinkedList();
		
		Deque b = new LinkedList();
		
	}

}
