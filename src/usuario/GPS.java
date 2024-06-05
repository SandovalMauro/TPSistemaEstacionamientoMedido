package usuario;

import sem.Zona;

// DELETE? 
public class GPS {	
	private Zona ubicacion;
	
	private GPS() {}
	
	protected GPS(Zona _ubicacion) {
		this.ubicacion = _ubicacion;
	}
	
	protected Zona ubicacion() {return this.ubicacion;}
	protected void ubicacion(Zona nuevaUbicacion) {
		this.ubicacion = nuevaUbicacion;
	}
	
	
}
