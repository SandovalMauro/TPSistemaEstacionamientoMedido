package puntoDeVenta;

import java.time.LocalDate;

import appUsuario.AppUsuario;
import sem.RegistroEstacionamiento;
import sem.SEM;
import usuario.Usuario;

public class PuntoDeVenta {
	
	private SEM sem;
	
	public PuntoDeVenta(SEM sem) {
		this.sem = sem;
	}
	
	public void cargarCredito(AppUsuario usuario ,double credito, LocalDate fecha) {
		int celular = 0; // usuario.celular.nroCelular();
		this.sem.agregarCompra(new Recarga(this, fecha,credito, celular));
		//aumentar credito al usuario
		//usuario.aumentarCredito(credito);
	}
	
	public void iniciarEstacionamiento(AppUsuario usuario, int cantidadHs, LocalDate fechaInicio) {

		this.sem.agregarCompra(new CompraPuntual(this,fechaInicio,cantidadHs));
		this.sem.agregarEstacionamiento(new RegistroEstacionamiento()); // agregarle los parametros que necesite
	}
	
}
