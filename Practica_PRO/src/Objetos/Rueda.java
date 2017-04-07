package Objetos;

import java.util.ArrayList;
import java.util.Date;

public class Rueda {
	public Rueda() {
		super();
		pinchazos = new ArrayList<Pinchazo>();
	}
	private Date FechaMontaje;
	private Date FechaRetirada;
	private int KmRealizados;
	private String Marca;
	private ArrayList<Pinchazo> pinchazos;
	
	public Date getFechaMontaje() {
		return FechaMontaje;
	}
	public void setFechaMontaje(Date fechaMontaje) {
		FechaMontaje = fechaMontaje;
	}
	public Date getFechaRetirada() {
		return FechaRetirada;
	}
	public void setFechaRetirada(Date fechaRetirada) {
		FechaRetirada = fechaRetirada;
	}
	public int getKmRealizados() {
		return KmRealizados;
	}
	public void setKmRealizados(int kmRealizados) {
		KmRealizados = kmRealizados;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public ArrayList<Pinchazo> getPinchazos() {
		return pinchazos;
	}
	public void setPinchazos(ArrayList<Pinchazo> pinchazos) {
		this.pinchazos = pinchazos;
	}
	
	
}
