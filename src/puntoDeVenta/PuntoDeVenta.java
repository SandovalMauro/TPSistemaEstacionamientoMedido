package puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalDateTime;

import appUsuario.AppUsuario;
import sem.RegistroEstacionamiento;
import sem.SEM;

public class PuntoDeVenta {
	
	private SEM sem;
	
	public PuntoDeVenta(SEM sem) {
		this.sem = sem;
	}

	public void cargarCredito(AppUsuario appT,double credito, LocalDateTime localDateTime) {

		int celular = 0; // usuario.celular.nroCelular();
		this.sem.agregarCompra(new Recarga(this, localDateTime,credito, celular));
		//aumentar credito al usuario
		//usuario.aumentarCredito(credito);
	}
	

	public void iniciarEstacionamiento(/*Usuario usuario,*/ int cantidadHs, LocalDateTime fechaInicio) {


		this.sem.agregarCompra(new CompraPuntual(this,fechaInicio,cantidadHs));
		this.sem.agregarEstacionamiento(new RegistroEstacionamiento()); // agregarle los parametros que necesite
	}




}
