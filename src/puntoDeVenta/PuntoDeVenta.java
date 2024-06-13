package puntoDeVenta;




import java.time.LocalDateTime;

import appUsuario.AppUsuario;
import sem.EstacionamientoCompraPuntual;

import sem.SEM;

public class PuntoDeVenta {
	
	private SEM sem;
	
	public PuntoDeVenta(SEM sem) {
		this.sem = sem;
	}


	public void cargarCredito(AppUsuario app, double credito, LocalDateTime fecha) {
		
		this.sem.agregarCompra(new Recarga(this, fecha,credito, app.getNumero()));

		app.cargarSaldo(credito);
	}
	


	public void iniciarEstacionamiento(int cantidadHs, LocalDateTime fechaInicio, String patente) {

		CompraPuntual compraPuntual = new CompraPuntual(this,fechaInicio,cantidadHs);
		this.sem.agregarCompra(compraPuntual);
		this.sem.agregarEstacionamiento(new EstacionamientoCompraPuntual(compraPuntual, patente)); // agregarle los parametros que necesite
	}




}
