package inspector;

import java.time.LocalDateTime;

public class Infraccion {

	private String Patente;
	private Inspector Inspector;
	private LocalDateTime HoraActual;
	
	 // Constructor
    public Infraccion(String patente, Inspector inspector) {
        this.Patente = patente;
        this.Inspector = inspector;
        this.HoraActual = LocalDateTime.now(); // Obtiene la fecha y hora actuales
    }
	
    // Getters y Setters
    
	public String getPatente() {
		return Patente;
	}

	public void setPatente(String patente) {
		Patente = patente;
	}

	public Inspector getInspector() {
		return Inspector;
	}

	public LocalDateTime getHoraActual() {
		return HoraActual;
	}
}
