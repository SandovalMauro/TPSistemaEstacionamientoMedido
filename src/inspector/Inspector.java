package inspector;

public class Inspector {

	private String nombreInspector;
	private int IDinspector; //ID inspector es único por cada inspector.
	private AppInspector app;
	
	// Constructor
	public Inspector(String nombreInspector, int iDinspector, AppInspector app) {
		this.nombreInspector = nombreInspector;
		IDinspector = iDinspector;
		this.app = app;
	}
	
	// Metodos
	public void tieneEstacionamientoValido(String Patente) {
		if(!this.getApp().tieneEstacionamientoVigente(Patente)) {
			this.getApp().altaDeInfraccion(Patente);
		}
	}
	
	// Getters y Setters
	public String getNombreInspector() {
		return nombreInspector;
	}

	public void setNombreInspector(String nombreInspector) {
		this.nombreInspector = nombreInspector;
	}

	public int getIDinspector() {
		return IDinspector;
	}

	public void setIDinspector(int iDinspector) {
		IDinspector = iDinspector;
	}

	public AppInspector getApp() {
		return app;
	}

	public void setApp(AppInspector app) {
		this.app = app;
	}
}
