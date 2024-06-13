package inspector;

import java.time.LocalDateTime;

import sem.Zona;

public class Infraccion {

	private String Patente;
	private Inspector Inspector;
	private LocalDateTime HoraActual;
	private Zona zona;
	
	 // Constructor
    public Infraccion(String patente, Inspector inspector) {
        this.Patente = patente;
        this.Inspector = inspector;
        this.HoraActual = LocalDateTime.now(); // Obtiene la fecha y hora actuales
        this.zona = inspector.getZona();
    }
	
    // Getters y Setters
    
	public String getPatente() {
		return Patente;
	}

	public Inspector getInspector() {
		return Inspector;
	}

	public LocalDateTime getHoraActual() {
		return HoraActual;
	}
	
	public Zona getZona() {
		return zona;
	}
}
