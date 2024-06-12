package puntoDeVenta;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Compra {
	
	private static int numeroActual = 1;
	private int numControl;
	private PuntoDeVenta punto;
	private LocalDateTime fechaYHora;
	
	public Compra(PuntoDeVenta puntoDeVenta, LocalDateTime fechaInicio) {
		this.numControl = numeroActual++;
		this.punto = puntoDeVenta;
		this.fechaYHora = fechaInicio;
	}
	
	public int numControl() {
		return this.numControl;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

}
