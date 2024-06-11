package puntoDeVenta;


import java.time.LocalDateTime;

public class Compra {
	
	private static int numeroActual = 1;
	private int numControl;
	private PuntoDeVenta punto;
	private LocalDateTime fechaYHora;
	
	public Compra(PuntoDeVenta puntoDeVenta, LocalDateTime fechaYHora) {
		this.numControl = numeroActual++;
		this.punto = puntoDeVenta;
		this.fechaYHora = fechaYHora;
	}
	
	public int numControl() {
		return this.numControl;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

}
