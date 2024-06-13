package inspector;

import sem.Zona;

public class Inspector {

	private String nombreInspector;
	private int IDinspector; //ID inspector es único por cada inspector.
	private AppInspector app;
	private Zona zona;
	
	// Constructor
	public Inspector(String nombreInspector, int iDinspector, AppInspector app, Zona zona) {
		this.nombreInspector = nombreInspector;
		IDinspector = iDinspector;
		this.app = app;
		this.zona = zona;
	}
	
	// Metodos
	public void tieneEstacionamientoValido(String patente) {
		if(!this.getApp().tieneEstacionamientoVigente(patente)) {
			this.getApp().altaDeInfraccion(patente);
		}
	}
	
	// Getters y Setters
	public String getNombreInspector() {
		return nombreInspector;
	}

	public int getIDinspector() {
		return IDinspector;
	}

	public AppInspector getApp() {
		return app;
	}
	
	public Zona getZona() {
		return zona;
	}

}
