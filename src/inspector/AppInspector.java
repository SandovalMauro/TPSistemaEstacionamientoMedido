package inspector;

import sem.SEM;

public class AppInspector {

	private SEM sem;
	
	 // Constructor
	public AppInspector(SEM sem) {
		this.sem = sem;
	}

	// Metodos
	public boolean tieneEstacionamientoVigente(String Patente){
		return this.getSem().estaVigente(Patente);
	}
	
	public void altaDeInfraccion(String Patente){
		sem.generarInfraccion(Patente);
	}
	
	// Getters y Setters
	public SEM getSem() {
		return sem;
	}

	public void setSem(SEM sem) {
		this.sem = sem;
	}
	
}
