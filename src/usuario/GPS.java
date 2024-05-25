package usuario;


// DELETE? 
public class GPS {	
	private Zona ubicacion;
	
	private GPS() {}
	
	protected GPS(Zona _ubicacion) {
		this.ubicacion = _ubicacion
	}
	
	protected ubicacion() {return this.ubicacion}
	protected ubicacion(Zona nuevaUbicacion) {
		this.ubicacion = nuevaUbicacion
	}
	
	
}
