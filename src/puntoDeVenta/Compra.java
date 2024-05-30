package puntoDeVenta;

import java.time.LocalDate;

public class Compra {
	
	private static int numeroActual = 1;
	private int numControl;
	private PuntoDeVenta punto;
	private LocalDate fechaYHora;
	
	public Compra(PuntoDeVenta puntoDeVenta, LocalDate fechaYHora) {
		this.numControl = numeroActual++;
		this.punto = puntoDeVenta;
		this.fechaYHora = fechaYHora;
	}
	
	public int numControl() {
		return this.numControl;
	}
	
}
