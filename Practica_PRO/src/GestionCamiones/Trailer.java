package GestionCamiones;

import java.util.ArrayList;

import Objetos.Rueda;

public class Trailer extends Camion {
	
	private ArrayList<Rueda> ruedas;
	private int NumRuedas;
	
	public ArrayList<Rueda> getRuedas() {
		return ruedas;
	}
	public void setRuedas(ArrayList<Rueda> ruedas) {
		this.ruedas = ruedas;
	}
	public int getNumRuedas() {
		return NumRuedas;
	}
	public void setNumRuedas(int numRuedas) {
		NumRuedas = numRuedas;
	}
	public Trailer() {
		ruedas = new ArrayList<Rueda>();
	}
	@Override
	public void horario() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hora(){
		System.out.println("hora del Trailer");
	}
	@Override
	public void crearVehiculo() {
		// TODO Auto-generated method stub
		
	}
	

	

}
