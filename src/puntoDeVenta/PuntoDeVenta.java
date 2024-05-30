package puntoDeVenta;

import java.time.LocalDate;

import sem.SEM;
import usuario.Usuario;

public class PuntoDeVenta {
	
	private SEM sem;
	
	public PuntoDeVenta(SEM sem) {
		this.sem = sem;
	}
	
	public void cargarCredito(Usuario usuario ,double credito, LocalDate fecha) {
		this.sem.comprarRecargar(usuario, credito, fecha);
	}
	
	public void iniciarEstacionamiento(Usuario usuario, int cantidadHs, LocalDate fechaInicio) {
		this.sem.comprarEstacionamiento(usuario, cantidadHs, fechaInicio);
		this.sem.generarEstacionamiento(usuario, cantidadHs, fechaInicio);
	}
	
}
