package inspector;

import sem.SEM;

public class AppInspector {

	private Inspector inspector;
	private SEM sem;
	
	 // Constructor
	public AppInspector(SEM sem, Inspector inspector) {
		this.sem = sem;
		this.inspector = inspector;
	}

	// Metodos
	public boolean tieneEstacionamientoVigente(String patente){
		return this.getSem().estaVigente(patente);
	}
	
	public void altaDeInfraccion(String patente){
		Infraccion infraccion = new Infraccion(patente, this.getInspector());
		this.getSem().agregarInfraccion(infraccion);
	}
	
	// Getters y Setters
	public SEM getSem() {
		return sem;
	}
	
	public Inspector getInspector() {
		return inspector;
	}
	
}
