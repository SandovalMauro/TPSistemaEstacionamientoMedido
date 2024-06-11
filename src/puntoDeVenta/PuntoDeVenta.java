package puntoDeVenta;


import java.time.LocalDateTime;

import appUsuario.AppUsuario;
import sem.EstacionamientoCompraPuntual;
import sem.RegistroEstacionamiento;
import sem.SEM;

public class PuntoDeVenta {
	
	private SEM sem;
	
	public PuntoDeVenta(SEM sem) {
		this.sem = sem;
	}

	public void cargarCredito(/*Usuario usuario, */ double credito, LocalDateTime fecha) {

		int celular = 0; // usuario.celular.nroCelular();
		this.sem.agregarCompra(new Recarga(this, fecha,credito, celular));
		//aumentar credito al usuario
		//usuario.aumentarCredito(credito);
	}
	

	public void iniciarEstacionamiento(/*Usuario usuario,*/ int cantidadHs, LocalDateTime fechaInicio, String patente) {

		CompraPuntual compraPuntual = new CompraPuntual(this,fechaInicio,cantidadHs);
		this.sem.agregarCompra(compraPuntual);
		this.sem.agregarEstacionamiento(new EstacionamientoCompraPuntual(compraPuntual, patente)); // agregarle los parametros que necesite
	}
	
}
