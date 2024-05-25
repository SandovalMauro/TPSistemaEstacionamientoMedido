package usuario;

public class Usuario {
	private String patente;
	private Celular celular;
	
	
	public Usuario() {}
	
	public Usuario(String patente, int numTelefono, Zona ubicacion) {
		this.patente = patente;
		this.celular = new Celular(numTelefono, ubicacion);
	}
	
	
}









