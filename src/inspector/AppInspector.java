package inspector;

import sem.SEM;

public class AppInspector {
	
	public boolean tieneEstacionamientoVigente(String Patente){
		return SEM.estaVigente(Patente);
	}
	
	public void altaDeInfraccion(String Patente){
		SEM.generarInfraccion(Patente);
	}
	
}
