package GestionCamiones;

public abstract class Camion implements Vehiculo {
	private String Matricula;
	private int Km;
	
	public String getMatricula() {
		return Matricula;
	}
	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	public int getKm() {
		return Km;
	}
	public void setKm(int km) {
		Km = km;
	}
	
	public abstract void horario();
	
	public void hora(){
		System.out.println("hora");
	}

}
