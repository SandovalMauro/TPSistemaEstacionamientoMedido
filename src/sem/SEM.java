package sem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import puntoDeVenta.Compra;
import usuario.Usuario;

public class SEM {
	
	private Collection<Compra> compras;
	private Collection<RegistroEstacionamiento> estacionados;
	
	public SEM() {
		this.compras = new ArrayList<Compra>();
		this.estacionados = new ArrayList<RegistroEstacionamiento>();
	}
	
	public void generarEstacionamiento(Usuario usuario, int cantidadHs, LocalDate fechaInicio) {
		//genera el registro de estacionamiento
	}

	public void comprarEstacionamiento(Usuario usuario, int cantidadHs, LocalDate fechaInicio) {
		// TODO Auto-generated method stub
		// genera la compra puntual de hs
	}

	public void comprarRecargar(Usuario usuario, double credito, LocalDate fecha) {
		// TODO Auto-generated method stub
		// genera la compra de recarga
		
	}


}
